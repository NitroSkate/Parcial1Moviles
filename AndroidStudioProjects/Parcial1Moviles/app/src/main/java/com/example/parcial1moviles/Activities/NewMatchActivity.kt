package com.example.parcial1moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.isEmpty
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.parcial1moviles.Entities.Matches
import com.example.parcial1moviles.R
import com.example.parcial1moviles.Viewmodel.MatchesViewmodel
import kotlinx.android.synthetic.main.activity_new_match.*

class NewMatchActivity : AppCompatActivity() {

    private lateinit var matchesViewmodel: MatchesViewmodel
    private var points1 = 0
    private var points2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_match)
        matchesViewmodel = ViewModelProviders.of(this).get(MatchesViewmodel::class.java)

        this.apply {
            pointsa1.setOnClickListener {
                points1++
                pointsa.text = points1.toString()
            }
            pointsa2.setOnClickListener {
                points1+=2
                pointsa.text = points1.toString()
            }
            pointsa3.setOnClickListener {
                points1+=3
                pointsa.text = points1.toString()
            }
            pointsb1.setOnClickListener {
                points2++
                pointsb.text = points2.toString()
            }
            pointsb2.setOnClickListener {
                points2+=2
                pointsb.text = points2.toString()
            }
            pointsb3.setOnClickListener {
                points2+=3
                pointsb.text = points2.toString()
            }
            enviar.setOnClickListener {
                val win = if(points1 > points2 ) namea.text.toString() else if (points1 == points2) "Empate" else nameb.text.toString()
                var dato = Matches(namea.text.toString(),nameb.text.toString(),points1,
                    points2, win, date.dayOfMonth.toString()+"/"+date.month.toString()+"/"+date.year.toString(), time.text.toString())
                var flag = true
                if(TextUtils.isEmpty(namea.text) || TextUtils.isEmpty(nameb.text) || TextUtils.isEmpty(time.text)) {
                    flag = false
                }
                matchesViewmodel.allData.observe(this, Observer { datos ->
                    datos?.let {
                        for(i in 0 .. it.size-1){
                            if((it[i].date == date.dayOfMonth.toString()+"/"+date.month.toString()+"/"+date.year.toString() && it[i].time == time.text.toString()) ){
                                flag = false
                            }
                        }
                    }
                })
                if(flag) matchesViewmodel.insert(dato) else Toast.makeText(this, "No se pudo insertar el partido", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
