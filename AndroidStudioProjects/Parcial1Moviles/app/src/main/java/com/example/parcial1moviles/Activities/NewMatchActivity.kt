package com.example.parcial1moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.parcial1moviles.Entities.Matches
import com.example.parcial1moviles.R
import com.example.parcial1moviles.Viewmodel.MatchesViewmodel
import com.example.parcial1moviles.Viewmodel.ScoreViewModel
import kotlinx.android.synthetic.main.activity_new_match.*

class NewMatchActivity : AppCompatActivity() {

    private lateinit var matchesViewmodel: MatchesViewmodel
    private lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_match)
        matchesViewmodel = ViewModelProviders.of(this).get(MatchesViewmodel::class.java)
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        pointsa.text = scoreViewModel.scoreA.toString()
        pointsb.text = scoreViewModel.scoreB.toString()
        this.apply {
            pointsa1.setOnClickListener {
                scoreViewModel.scoreA++
                pointsa.text = scoreViewModel.scoreA.toString()
            }
            pointsa2.setOnClickListener {
                scoreViewModel.scoreA+=2
                pointsa.text = scoreViewModel.scoreA.toString()
            }
            pointsa3.setOnClickListener {
                scoreViewModel.scoreA+=3
                pointsa.text = scoreViewModel.scoreA.toString()
            }
            pointsb1.setOnClickListener {
                scoreViewModel.scoreB++
                pointsb.text = scoreViewModel.scoreB.toString()
            }
            pointsb2.setOnClickListener {
                scoreViewModel.scoreB+=2
                pointsb.text = scoreViewModel.scoreB.toString()
            }
            pointsb3.setOnClickListener {
                scoreViewModel.scoreB+=3
                pointsb.text = scoreViewModel.scoreB.toString()
            }
            enviar.setOnClickListener {
                val win = if(scoreViewModel.scoreA > scoreViewModel.scoreB ) namea.text.toString() else if (scoreViewModel.scoreA == scoreViewModel.scoreB) "Empate" else nameb.text.toString()
                var dato = Matches(namea.text.toString(),nameb.text.toString(),scoreViewModel.scoreA,
                    scoreViewModel.scoreB, win, date.dayOfMonth.toString()+"/"+date.month.toString()+"/"+date.year.toString(), hour.text.toString()+":"+minute.text.toString())
                var flag = true
                if(TextUtils.isEmpty(namea.text) || TextUtils.isEmpty(nameb.text) || TextUtils.isEmpty(hour.text) || TextUtils.isEmpty(minute.text) || hour.text.toString().toInt()>=24 || minute.text.toString().toInt()>=60 ||hour.text.toString().toInt()<0 || minute.text.toString().toInt()<0) {
                    flag = false
                }
                matchesViewmodel.allData.observe(this, Observer { datos ->
                    datos?.let {
                        for(i in 0 .. it.size-1){
                            if((it[i].date == date.dayOfMonth.toString()+"/"+date.month.toString()+"/"+date.year.toString() && it[i].time == hour.text.toString()+":"+minute.text.toString()) ){
                                flag = false
                            }
                        }
                    }
                })
                if(flag) {
                    matchesViewmodel.insert(dato)
                    finish()
                }

                else {
                    Toast.makeText(this, "No se pudo insertar el partido", Toast.LENGTH_SHORT).show()}

            }
        }

    }
}
