package com.example.workoutchallange

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.time.Duration

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val database = FirebaseDatabase.getInstance().getReference()
        var cek = false
        val ambil = intent
        database.child("data").child("data${ambil.getStringExtra("nama")}").child("dataworkout").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                findViewById<TextView>(R.id.tanganpersen).setText("${dataSnapshot.child("arm").value.toString()}%")
                findViewById<TextView>(R.id.kakipersen).setText("${dataSnapshot.child("leg").value.toString()}%")
                findViewById<TextView>(R.id.perutpersen).setText("${dataSnapshot.child("abs").value.toString()}%")
                findViewById<TextView>(R.id.dadapersen).setText("${dataSnapshot.child("chest").value.toString()}%")
                findViewById<TextView>(R.id.penuhpersen).setText("${dataSnapshot.child("full").value.toString()}%")
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })

        findViewById<TextView>(R.id.namauser).setText(ambil.getStringExtra("nama"))
        val anim1: ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.imageView3), View.ALPHA, 0f, 1f)
        anim1.duration = 1200
        val anim2: ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.imageView3), View.TRANSLATION_X, 200f, 0f)
        anim2.duration = 1200
        val anim: AnimatorSet = AnimatorSet()
        anim.playTogether(anim1,anim2)
        anim.start()
        findViewById<TextView>(R.id.namauser).alpha = 0f
        val anim1user: ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.namauser), View.ALPHA, 0f, 1f)
        anim1user.duration = 1200
        val anim2user: ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.namauser), View.TRANSLATION_Y, 200f, 0f)
        anim2user.duration = 1200
        val animuser: AnimatorSet = AnimatorSet()
        animuser.playTogether(anim1user,anim2user)
        animuser.startDelay = 600
        animuser.start()
        findViewById<ImageView>(R.id.imageView3).setOnClickListener {
            if (cek == false) {
                val anim1: ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.imageView4), View.ALPHA, 0f, 1f)
                anim1.duration = 1200
                val anim2: ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.imageView4), View.SCALE_Y, 0f, 1.5f, 1f)
                anim2.duration = 1200
                val anim3: ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.imageView4), View.SCALE_X, 0f, 1.5f, 1f)
                anim3.duration = 1200
                val anim: AnimatorSet = AnimatorSet()
                anim.playTogether(anim1, anim2, anim3)
                anim.start()
                val anim1progress: ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.progress), View.ALPHA, 0f, 1f)
                anim1progress.duration = 1200
                val anim2progress: ObjectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.progress), View.TRANSLATION_Y, 200f, 0f)
                anim2progress.duration = 1200
                val animprogress: AnimatorSet = AnimatorSet()
                animprogress.playTogether(anim1progress, anim2progress)
                animprogress.startDelay = 600
                animprogress.start()
                persen(findViewById(R.id.tangan), findViewById(R.id.tanganpersen), 1200)
                persen(findViewById(R.id.perut), findViewById(R.id.perutpersen), 1600)
                persen(findViewById(R.id.dada), findViewById(R.id.dadapersen), 2000)
                persen(findViewById(R.id.kaki), findViewById(R.id.kakipersen), 2400)
                persen(findViewById(R.id.penuh), findViewById(R.id.penuhpersen), 2800)
                cek = true
            }
        }
        findViewById<ImageView>(R.id.imageView4).setOnClickListener {
            val beralih = Intent(this,MainActivity::class.java)
            beralih.putExtra("nama",ambil.getStringExtra("nama"))
            startActivity(beralih)
        }
        findViewById<TextView>(R.id.textView5).setOnClickListener {
            val beralih = Intent(this,login::class.java)
            startActivity(beralih)
            finish()
        }

    }

    fun persen(text :TextView,text2 :TextView,time :Long){
        val anim: ObjectAnimator = ObjectAnimator.ofFloat(text, View.ALPHA, 0f, 1f)
        anim.duration = 1200
        val anim1: ObjectAnimator = ObjectAnimator.ofFloat(text2, View.ALPHA, 0f, 1f)
        anim1.duration = 1200
        val animasi: AnimatorSet = AnimatorSet()
        animasi.startDelay = time
        animasi.playTogether(anim,anim1)
        animasi.start()
    }
}