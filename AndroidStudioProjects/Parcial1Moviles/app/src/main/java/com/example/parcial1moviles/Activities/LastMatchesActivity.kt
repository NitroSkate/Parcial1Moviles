package com.example.parcial1moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.parcial1moviles.Entities.Matches
import com.example.parcial1moviles.Fragments.ListMatches
import com.example.parcial1moviles.R
import com.example.parcial1moviles.Viewmodel.MatchesViewmodel
import kotlinx.android.synthetic.main.activity_last_matches.*

class LastMatchesActivity : AppCompatActivity(), ListMatches.OnFragmentInteractionListener {


    private lateinit var matchesViewmodel: MatchesViewmodel
    private lateinit var match: Matches
    private lateinit var listfragment: ListMatches

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_matches)
        match = Matches("","",0,0,"","","")
        initFragment()
    }

    fun initFragment(){
        if(match.winner == ""){
            Title.text = "Partidos Jugados "
            listfragment = ListMatches.newInstance()
            changefragment(R.id.fragment, listfragment)
        }
        else{
            Toast.makeText(this, "olv", Toast.LENGTH_SHORT).show()
        }
    }

    fun changefragment(id: Int, frag: Fragment){
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }
    override fun onClickListElement(match: Matches) {
        Toast.makeText(this, match.date, Toast.LENGTH_SHORT).show()
    }
}