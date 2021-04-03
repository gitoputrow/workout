package com.example.workoutchallange

import android.content.ContentValues
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import android.content.ContentValues.TAG
import com.google.firebase.database.*


class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val database = FirebaseDatabase.getInstance().getReference()
        findViewById<EditText>(R.id.pinmasuk).setText("")
        findViewById<EditText>(R.id.namamasuk).setText("")
        database.child("data").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                findViewById<TextView>(R.id.user).text = "User : ${dataSnapshot.childrenCount} People"
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })

        findViewById<Button>(R.id.regis).setOnClickListener {
            if ((findViewById<EditText>(R.id.namamasuk).text.toString().equals("")) or (findViewById<EditText>(R.id.pinmasuk).text.toString().equals(""))){
                Toast.makeText(baseContext,"Lengkapi data", Toast.LENGTH_LONG).show()
            }
            else {
                database.child("data").addListenerForSingleValueEvent(object : ValueEventListener {
                    var cek = false
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.hasChild("data${findViewById<EditText>(R.id.namamasuk).text}")){
                            Log.d(ContentValues.TAG,"kontol2");
                            Toast.makeText(baseContext,"nama sudah terpakai", Toast.LENGTH_LONG).show()
                        }
                        else{
                            masuk(database)
                            Toast.makeText(baseContext,"berhasil", Toast.LENGTH_LONG).show()
                            findViewById<EditText>(R.id.pinmasuk).setText("")
                            findViewById<EditText>(R.id.namamasuk).setText("")
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                    }
                })

            }
        }
        findViewById<Button>(R.id.loginn).setOnClickListener {
            if ((findViewById<EditText>(R.id.namamasuk).text.toString().equals("")) or (findViewById<EditText>(R.id.pinmasuk).text.toString().equals(""))){
                Toast.makeText(baseContext,"Lengkapi data",Toast.LENGTH_LONG).show()
            }
            else{
                database.child("data").addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        var ceknama = false
                        for (child :DataSnapshot in dataSnapshot.children){
                            Log.d(TAG,child.key.toString());
                            if (child.key.toString().equals("data${findViewById<EditText>(R.id.namamasuk).text}")){
                                ceknama = true
                                break
                            }
                        }
                        if (ceknama == false){
                            Toast.makeText(baseContext,"tidak ditemukan nama pengguna",Toast.LENGTH_LONG).show()
                        }
                        else{
                            database.child("data").child("data${findViewById<EditText>(R.id.namamasuk).text}").child("pin").addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    var pin = dataSnapshot.getValue().toString()
                                    if (pin.equals(findViewById<EditText>(R.id.pinmasuk).text.toString())){
                                        val ambil = Intent(this@login,profile::class.java)
                                        ambil.putExtra("nama",findViewById<EditText>(R.id.namamasuk).text.toString())
                                        startActivity(ambil)
                                        finish()
                                    }
                                    else{
                                        Toast.makeText(baseContext,"pin salah",Toast.LENGTH_LONG).show()
                                    }
                                }
                                override fun onCancelled(error: DatabaseError) {
                                    // Failed to read value
                                }
                            })
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                    }
                })
            }
        }
    }
    fun masuk(database : DatabaseReference){
        database.child("data")
                .child("data${findViewById<EditText>(R.id.namamasuk).text}")
                .setValue(request(findViewById<EditText>(R.id.namamasuk).text.toString(),
                        findViewById<EditText>(R.id.pinmasuk).text.toString()))

        database.child("data")
                .child("data${findViewById<EditText>(R.id.namamasuk).text}")
                .child("dataworkout")
                .setValue(Progress())
                .addOnSuccessListener {
                    findViewById<EditText>(R.id.namamasuk).setText("")
                    findViewById<EditText>(R.id.pinmasuk).setText("")
                }
    }

}