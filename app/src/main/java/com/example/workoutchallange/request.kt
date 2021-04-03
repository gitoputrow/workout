package com.example.workoutchallange
import java.sql.*
import java.sql.Connection
import java.sql.DriverManager;
import java.sql.SQLException;

class request (private var nama: String, private var pin :String){
    init {
        this.nama = nama
        this.pin = pin
    }
    fun setNama(nama :String){this.nama = nama}
    fun getNama(): String {return this.nama}
    fun setpin(pin :String){this.pin = pin}
    fun getpin(): String {return this.pin}
    override fun toString(): String{
        return " "+nama+"\n"+
                " "+pin
    }
}