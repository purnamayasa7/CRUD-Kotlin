package com.example.py7.crudkotlin

class Barang {

    var id: Int? = null
    var name: String? = null
    var jenis: String? = null
    var harga: String? = null

    constructor(id: Int, name: String, jenis: String, harga:String){
        this.id = id
        this.name = name
        this.jenis = jenis
        this.harga = harga
    }
}