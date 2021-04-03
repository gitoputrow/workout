package com.example.workoutchallange

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.ContentValues
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.database.*

class Level : AppCompatActivity() {
    var cekk = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        val ambil = intent
        val database = FirebaseDatabase.getInstance().getReference()
        database.child("data").child("data${ambil.getStringExtra("nama")}").child("dataworkout").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(ambil.getBooleanExtra("arm",false)){
                    warna(dataSnapshot,"arm")
                }
                else if(ambil.getBooleanExtra("abs",false)){
                    warna(dataSnapshot,"abs")
                }
                else if(ambil.getBooleanExtra("chest",false)){
                    warna(dataSnapshot,"chest")
                }
                else if(ambil.getBooleanExtra("leg",false)){
                    warna(dataSnapshot,"leg")
                }
                else if(ambil.getBooleanExtra("full",false)){
                    warna(dataSnapshot,"full")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })
        findViewById<CheckBox>(R.id.level1).setOnClickListener {
            findViewById<CheckBox>(R.id.level2).isChecked = false
            findViewById<CheckBox>(R.id.level3).isChecked = false
            anim(findViewById(R.id.level1))
        }
        findViewById<CheckBox>(R.id.level2).setOnClickListener {
            findViewById<CheckBox>(R.id.level1).isChecked = false
            findViewById<CheckBox>(R.id.level3).isChecked = false
            anim(findViewById(R.id.level2))
        }
        findViewById<CheckBox>(R.id.level3).setOnClickListener {
            findViewById<CheckBox>(R.id.level1).isChecked = false
            findViewById<CheckBox>(R.id.level2).isChecked = false
            anim(findViewById(R.id.level3))
        }
        findViewById<ImageView>(R.id.imageView).setOnClickListener {
            val balik = Intent(this,MainActivity::class.java)
            startActivity(balik)
        }
        findViewById<ImageView>(R.id.level).setOnClickListener {
            if (findViewById<CheckBox>(R.id.level1).isChecked){
                val level1 = Intent(this,activity2::class.java)
                level1.putExtra("lvl1",true)
                otot(ambil,level1)
                startActivity(level1)
            }
            else if (findViewById<CheckBox>(R.id.level2).isChecked){
                Log.d(ContentValues.TAG,findViewById<CheckBox>(R.id.level2).currentTextColor.toString());
                if (findViewById<CheckBox>(R.id.level1).currentTextColor != -9722671){
                    val level2 = Intent(this,activity2::class.java)
                    level2.putExtra("lvl2",true)
                    otot(ambil,level2)
                    startActivity(level2)
                }
                else{
                    Toast.makeText(baseContext,"Selesaikan Level 1 terlebih dahulu",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                if (findViewById<CheckBox>(R.id.level2).currentTextColor != -9722671) {
                    val level3 = Intent(this, activity2::class.java)
                    level3.putExtra("lvl3", true)
                    otot(ambil, level3)
                    startActivity(level3)
                }
                else{
                    Toast.makeText(baseContext,"Selesaikan Level 2 terlebih dahulu",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun otot(ambil : Intent,lempar :Intent){
        if (ambil.getBooleanExtra("arm",false)){
            lempar.putExtra("arm",true)
            lempar.putExtra("nama",ambil.getStringExtra("nama"))
        }
        else if (ambil.getBooleanExtra("abs",false)){
            lempar.putExtra("abs",true)
            lempar.putExtra("nama",ambil.getStringExtra("nama"))
        }
        else if (ambil.getBooleanExtra("leg",false)){
            lempar.putExtra("leg",true)
            lempar.putExtra("nama",ambil.getStringExtra("nama"))
        }
        else if (ambil.getBooleanExtra("chest",false)){
            lempar.putExtra("chest",true)
            lempar.putExtra("nama",ambil.getStringExtra("nama"))
        }
        else {
            lempar.putExtra("full",true)
            lempar.putExtra("nama",ambil.getStringExtra("nama"))
        }
    }
    fun anim(cek : CheckBox){
        if ((cek.isChecked == true) and (cekk == true)){
            findViewById<ImageView>(R.id.level).visibility = View.VISIBLE
            val anim1 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.level), View.TRANSLATION_Y,200f,0f)
            anim1.duration = 1200
            val anim2 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.level),View.ALPHA, 0f,1f)
            anim2.duration = 1200
            val anim :AnimatorSet = AnimatorSet()
            anim.playTogether(anim1,anim2)
            anim.start()
            cekk = false
        }
        else if ((cek.isChecked == false) and (cekk == false)){
            val anim1 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.level), View.TRANSLATION_Y,0f,200f)
            anim1.duration = 1200
            val anim2 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.level),View.ALPHA, 1f,0f)
            anim2.duration = 1200
            val anim :AnimatorSet = AnimatorSet()
            anim.playTogether(anim1,anim2)
            anim.start()
            anim.playTogether(anim1,anim2)
            anim.start()
            cekk = true
        }
    }
    fun warna(dataSnapshot : DataSnapshot,string : String){
        if (dataSnapshot.child(string).value.toString().toInt() >= 33){
            findViewById<CheckBox>(R.id.level1).setTextColor(Color.parseColor("#01CA1D"))
        }
        if (dataSnapshot.child(string).value.toString().toInt() >= 70){
            findViewById<CheckBox>(R.id.level2).setTextColor(Color.parseColor("#01CA1D"))
        }
        if (dataSnapshot.child(string).value.toString().toInt() == 100){
            findViewById<CheckBox>(R.id.level3).setTextColor(Color.parseColor("#01CA1D"))
        }
    }

}
