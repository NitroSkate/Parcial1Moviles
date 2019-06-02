package com.example.parcial1moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcial1moviles.Activities.NewMatchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.apply {
            partido_nuevo.setOnClickListener {
                val intent = Intent(this@MainActivity, NewMatchActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

