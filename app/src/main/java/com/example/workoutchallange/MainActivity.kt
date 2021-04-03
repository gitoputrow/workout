package com.example.workoutchallange

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var cekk = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coba = intent
        val full :CheckBox = findViewById(R.id.full)
        val abs :CheckBox = findViewById(R.id.abs)
        val chest :CheckBox = findViewById(R.id.chest)
        val arm :CheckBox = findViewById(R.id.arm)
        val leg :CheckBox = findViewById(R.id.leg)
        val gambar_full :ImageView = findViewById(R.id.fullbody)
        val gambar_abs :ImageView = findViewById(R.id.perut)
        val gambar_chest :ImageView = findViewById(R.id.dada)
        val gambar_arm :ImageView = findViewById(R.id.lengan)
        val gambar_leg :ImageView = findViewById(R.id.kaki)
        val gambar :ImageView = findViewById(R.id.kosong)

        full.setOnClickListener {
            check(gambar_full,gambar_chest,gambar_arm,gambar_abs,gambar_leg,gambar,full,chest,arm,abs,leg)
            animbutton(full)
        }

        abs.setOnClickListener {
            check(gambar_abs,gambar_chest,gambar_arm,gambar_full,gambar_leg,gambar,abs,chest,arm,full,leg)
            animbutton(abs)
        }

        chest.setOnClickListener {
            check(gambar_chest,gambar_abs,gambar_arm,gambar_full,gambar_leg,gambar,chest,abs,arm,full,leg)
            animbutton(chest)
        }

        arm.setOnClickListener {
            check(gambar_arm,gambar_abs,gambar_chest,gambar_full,gambar_leg,gambar,arm,abs,chest,full,leg)
            animbutton(arm)
        }

        leg.setOnClickListener {
            check(gambar_leg,gambar_chest,gambar_arm,gambar_full,gambar_abs,gambar,leg,chest,arm,full,abs)
            animbutton(leg)
        }

        findViewById<ImageView>(R.id.button).setOnClickListener {
            if (arm.isChecked){
                val arm = Intent(this,Level::class.java)
                arm.putExtra("arm",true)
                arm.putExtra("nama",coba.getStringExtra("nama"))
                startActivity(arm)
            }
            else if (chest.isChecked){
                val chest = Intent(this,Level::class.java)
                chest.putExtra("chest",true)
                chest.putExtra("nama",coba.getStringExtra("nama"))
                startActivity(chest)
            }
            else if (abs.isChecked){
                val abs = Intent(this,Level::class.java)
                abs.putExtra("abs",true)
                abs.putExtra("nama",coba.getStringExtra("nama"))
                startActivity(abs)
            }
            else if (leg.isChecked){
                val leg = Intent(this,Level::class.java)
                leg.putExtra("leg",true)
                leg.putExtra("nama",coba.getStringExtra("nama"))
                startActivity(leg)
            }
            else{
                val full = Intent(this,Level::class.java)
                full.putExtra("full",true)
                full.putExtra("nama",coba.getStringExtra("nama"))
                startActivity(full)
            }
            finish()
        }

    }
    fun check(vsble :ImageView,invsble1 :ImageView,invsble2 :ImageView,invsble3 :ImageView,invsble4 :ImageView,semua :ImageView,
              cektrue :CheckBox,cekfalse1 :CheckBox,cekfalse2 :CheckBox,cekfalse3 :CheckBox,cekfalse4 :CheckBox){
        if (cektrue.isChecked == true){
            vsble.visibility = View.VISIBLE
            invsble1.visibility = View.INVISIBLE
            invsble2.visibility = View.INVISIBLE
            invsble3.visibility = View.INVISIBLE
            invsble4.visibility = View.INVISIBLE
            semua.visibility = View.INVISIBLE
            cekfalse1.isChecked = false
            cekfalse2.isChecked = false
            cekfalse3.isChecked = false
            cekfalse4.isChecked = false
        }
        else{
            semua.visibility = View.VISIBLE
            vsble.visibility = View.INVISIBLE
        }
    }
    fun animbutton(cek :CheckBox){
        if((cek.isChecked==true) and (cekk == true)){
            findViewById<ImageView>(R.id.button).visibility = View.VISIBLE
            val anim1 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.button),View.ALPHA,0f,1f)
            anim1.duration = 1200
            val anim2 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.button),View.SCALE_Y,0f,1.5f,1f)
            anim2.duration = 1200
            val anim3 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.button),View.SCALE_X,0f,1.5f,1f)
            anim3.duration = 1200
            val anim :AnimatorSet = AnimatorSet()
            anim.playTogether(anim1,anim2,anim3)
            anim.start()
            cekk = false
        }
        else if ((cek.isChecked==false) and (cekk == false)){
            val anim1 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.button),View.ALPHA,1f,0f)
            anim1.duration = 1200
            val anim2 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.button),View.SCALE_Y,1f,0f)
            anim2.duration = 1200
            val anim3 :ObjectAnimator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.button),View.SCALE_X,1f,0f)
            anim3.duration = 1200
            val anim :AnimatorSet = AnimatorSet()
            anim.playTogether(anim1,anim2,anim3)
            anim.start()
            cekk = true
        }
    }
}