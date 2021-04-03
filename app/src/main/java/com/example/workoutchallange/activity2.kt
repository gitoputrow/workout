package com.example.workoutchallange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.ActivityChooserView
import com.google.firebase.database.*
import pl.droidsonroids.gif.GifImageView

class activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pushup)
        val ambil = intent
        val selesai :Button = findViewById(R.id.selesai)
        var reps :List<Int> = listOf(10,12,12,14,10,12)
        val listnamareplatarm :List<String> = listOf("Push Up","Triceps Dips","Reversed Hands Push Up","Mountain Climb")
        val listnamareplatchest :List<String> = listOf("Archer Push Up","Push Up","Diamond Push Up","Elevated Push Up")
        val gambararm :List<GifImageView> = listOf(findViewById(R.id.pushup),findViewById(R.id.tricepsdips),findViewById(R.id.reversedhandspushup),findViewById(R.id.mountainclimb))
        val gambarchest :List<GifImageView> = listOf(findViewById(R.id.archerpu),findViewById(R.id.pushup),findViewById(R.id.diamondpushup),findViewById(R.id.elevatedpu))
        val gambarabs :List<GifImageView> = listOf(findViewById(R.id.crunchsitup),findViewById(R.id.situp),findViewById(R.id.legraise),findViewById(R.id.crunchbicycle))
        val gambarleg :List<GifImageView> = listOf(findViewById(R.id.squat),findViewById(R.id.jinjit),findViewById(R.id.lunges),findViewById(R.id.naikturun))
        val gambarfull :List<GifImageView> = listOf(findViewById(R.id.pushup),findViewById(R.id.archerpu),findViewById(R.id.situp),findViewById(R.id.crunchbicycle),
                findViewById(R.id.tricepsdips),findViewById(R.id.mountainclimb),findViewById(R.id.squat),findViewById(R.id.jinjit))
        val listnamareplatfull :List<String> = listOf("Push Up","Archer Push Up","Sit Up","Crunch Bicycle","Triceps Dips","Mountain Climb", "Squat","Tiptoe")
        val listnamareplatabs :List<String> = listOf("Crunch Sit Up","Sit Up","Leg Raise","Crunch Bicycle")
        val listnamareplatleg :List<String> = listOf("Squat","Tiptoe","Lunges","Step Ups Onto Chair")
        var i = 0
        val database = FirebaseDatabase.getInstance().getReference()

        if (ambil.getBooleanExtra("arm",false)){
            if (ambil.getBooleanExtra("lvl1",false)) {
                ganti(gambararm[i], gambararm[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatarm[i], "X ${reps[i + 1]}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambararm[i], gambararm[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatarm[i], "X ${reps[i + 1]}")
                    }
                    else{
                        persen(database,ambil,"33","arm","0")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl2",false)) {
                ganti(gambararm[i], gambararm[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatarm[i], "X ${reps[i + 1] + 6}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambararm[i], gambararm[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatarm[i], "X ${reps[i + 1] + 6}")
                    }
                    else{
                        persen(database,ambil,"70","arm","33")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl3",false)) {
                ganti(gambararm[i], gambararm[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatarm[i], "X ${reps[i + 1] + 10}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambararm[i], gambararm[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatarm[i], "X ${reps[i + 1] + 10}")
                    }
                    else{
                        persen(database,ambil,"100","arm","70")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
        }
        else if (ambil.getBooleanExtra("chest",false)){
            if (ambil.getBooleanExtra("lvl1",false)) {
                ganti(gambarchest[i], gambarchest[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatchest[i], "X ${reps[i]}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarchest[i], gambarchest[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatchest[i], "X ${reps[i]}")
                    }
                    else{
                        persen(database,ambil,"33","chest","0")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl2",false)) {
                ganti(gambarchest[i], gambarchest[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatchest[i], "X ${reps[i] + 6}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarchest[i], gambarchest[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatchest[i], "X ${reps[i] + 6}")
                    }
                    else{
                        persen(database,ambil,"70","chest","33")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl3",false)) {
                ganti(gambarchest[i], gambarchest[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatchest[i], "X ${reps[i] + 10}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarchest[i], gambarchest[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatchest[i], "X ${reps[i] + 10}")
                    }
                    else{
                        persen(database,ambil,"100","chest","70")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
        }
        else if (ambil.getBooleanExtra("abs",false)){
            if (ambil.getBooleanExtra("lvl1",false)) {
                ganti(gambarabs[i], gambarabs[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatabs[i], "X ${reps[3 - i]}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarabs[i], gambarabs[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatabs[i], "X ${reps[3 - i]}")
                    }
                    else{
                        persen(database,ambil,"33","abs","0")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl2",false)) {
                ganti(gambarabs[i], gambarabs[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatabs[i], "X ${reps[3 - i] + 6}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarabs[i], gambarabs[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatabs[i], "X ${reps[3 - i] + 6}")
                    }
                    else{
                        persen(database,ambil,"70","abs","33")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl3",false)) {
                ganti(gambarabs[i], gambarabs[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatabs[i], "X ${reps[3 - i] + 10}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarabs[i], gambarabs[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatabs[i], "X ${reps[3 - i] + 10}")
                    }
                    else{
                        persen(database,ambil,"100","abs","70")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
        }
        else if (ambil.getBooleanExtra("leg",false)){
            if (ambil.getBooleanExtra("lvl1",false)) {
                ganti(gambarleg[i], gambarleg[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatleg[i], "X ${reps[i + 2]}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarleg[i], gambarleg[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatleg[i], "X ${reps[i + 2]}")
                    }
                    else{
                        persen(database,ambil,"33","leg","0")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl2",false)) {
                ganti(gambarleg[i], gambarleg[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatleg[i], "X ${reps[i + 2] + 6}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarleg[i], gambarleg[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatleg[i], "X ${reps[i + 2] + 6}")
                    }
                    else{
                        persen(database,ambil,"70","leg","33")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl3",false)) {
                ganti(gambarleg[i], gambarleg[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatleg[i], "X ${reps[i + 2] + 10}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarleg[i], gambarleg[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatleg[i], "X ${reps[i + 2] + 10}")
                    }
                    else{
                        persen(database,ambil,"100","leg","70")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
        }
        else{
            if (ambil.getBooleanExtra("lvl1",false)) {
                ganti(gambarfull[i], gambarfull[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatfull[i], "X ${reps[i]}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarfull[i], gambarfull[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatfull[i], "X ${reps[i]}")
                    }
                    else{
                        persen(database,ambil,"33","full","0")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl2",false)) {
                ganti(gambarfull[i], gambarfull[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatfull[i], "X ${reps[i] + 6}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarfull[i], gambarfull[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatfull[i], "X ${reps[i] + 6}")
                    }
                    else{
                        persen(database,ambil,"70","full","33")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
            else if (ambil.getBooleanExtra("lvl3",false)) {
                ganti(gambarfull[i], gambarfull[i + 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatfull[i], "X ${reps[i] + 10}")
                selesai.setOnClickListener {
                    i++
                    if (i <= 3){
                        ganti(gambarfull[i], gambarfull[i - 1], findViewById(R.id.namalatihan), findViewById(R.id.replatihan), listnamareplatfull[i], "X ${reps[i] + 10}")
                    }
                    else{
                        persen(database,ambil,"100","full","70")
                        val ahli = Intent(this,profile::class.java)
                        ahli.putExtra("nama",ambil.getStringExtra("nama"))
                        startActivity(ahli)
                    }
                }
            }
        }

    }
    fun ganti(gambar :GifImageView,gambar2 :GifImageView,namalat :TextView,repslat :TextView,nama :String,reps :String){
        gambar.visibility = View.VISIBLE
        gambar2.visibility = View.INVISIBLE
        namalat.text = nama
        repslat.text = reps
    }
    fun persen(database : DatabaseReference,ambil : Intent,persen : String,jenis : String,awal : String){
        database.child("data").child("data${ambil.getStringExtra("nama")}").child("dataworkout").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.child(jenis).value.toString().equals(awal)){
                    database.child("data").child("data${ambil.getStringExtra("nama")}").child("dataworkout").child(jenis).setValue(persen)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })

    }
}

