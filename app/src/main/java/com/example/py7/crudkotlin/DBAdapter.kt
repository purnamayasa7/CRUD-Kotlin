package com.example.py7.crudkotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBAdapter {

    private val dbName = "dbBarang"
    private val dbTable = "Barang"
    private val colId = "Id"
    private val colName = "Nama"
    private val colJenis = "Jenis"
    private val colHarga = "Harga"
    private val dbVersion = 1

    private val CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " +
            dbTable + " (" + colId + " " + "INTEGER PRIMARY KEY," + colName + " TEXT, " +
            colJenis + " TEXT, " + colHarga + " TEXT);"
    private var db: SQLiteDatabase? = null

    constructor(context: Context){
        var dbHelper = DatabaseHelper(context)
        db = dbHelper.writableDatabase
    }

    fun allQuery(): Cursor {
        return db!!.rawQuery("select * from " + dbTable, null)
    }

    fun insert(values: ContentValues): Long{
        val ID = db!!.insert(dbTable, "", values)
        return ID
    }

    fun update(values: ContentValues, selection: String, selectionArgs: Array<String>): Int{
        val count = db!!.update(dbTable, values, selection, selectionArgs)
        return count
    }

    fun delete(selection: String, selectionArgs: Array<String>):Int{
        val count = db!!.delete(dbTable, selection, selectionArgs)
        return count
    }

    inner class DatabaseHelper : SQLiteOpenHelper {

        var context: Context? = null

        constructor(context: Context) : super(context, dbName, null, dbVersion){
            this.context = context
        }

        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL(CREATE_TABLE_SQL)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("Drop table IF EXISTS " + dbTable)
        }

    }
}