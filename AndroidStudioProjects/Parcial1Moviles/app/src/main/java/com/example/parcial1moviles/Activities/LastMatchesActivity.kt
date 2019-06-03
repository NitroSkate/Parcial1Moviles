package com.example.parcial1moviles.Activities

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.parcial1moviles.Entities.Matches
import com.example.parcial1moviles.Fragments.ListMatches
import com.example.parcial1moviles.Fragments.MatchResult
import com.example.parcial1moviles.R
import com.example.parcial1moviles.Viewmodel.MatchesViewmodel
import kotlinx.android.synthetic.main.activity_last_matches.*

class LastMatchesActivity : AppCompatActivity(), ListMatches.OnFragmentInteractionListener, MatchResult.OnFragmentInteractionListener {



    private lateinit var matchesViewmodel: MatchesViewmodel
    private lateinit var match: Matches
    private lateinit var listfragment: ListMatches
    private lateinit var matchResult: com.example.parcial1moviles.Fragments.MatchResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_matches)
        match = Matches("","",0,0,"","","")
        initFragment(match)
    }

    fun initFragment(match: Matches){
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (match.winner == "") {
                Title.text = "Partidos Jugados "
                listfragment = ListMatches.newInstance()
                changefragment(R.id.fragment, listfragment)
            } else {
                Toast.makeText(this, "olv", Toast.LENGTH_SHORT).show()
                Title.text = "Resultados del partido"
                matchResult = com.example.parcial1moviles.Fragments.MatchResult.newInstance(match)
                changefragment(R.id.fragment, matchResult)
            }
        }
        if(resources.configuration.orientation === Configuration.ORIENTATION_LANDSCAPE){
            listfragment = ListMatches.newInstance()
            matchResult = MatchResult.newInstance(match)
            changefragment(R.id.landscape1, listfragment)
            changefragment(R.id.landscape2, matchResult)
        }
    }

    fun changefragment(id: Int, frag: Fragment){
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }
    override fun onClickListElement(match: Matches) {
        Toast.makeText(this, match.date, Toast.LENGTH_SHORT).show()
        initFragment(match)
    }
    override fun onClickListElementLand(match: Matches) {
        matchResult = MatchResult.newInstance(match)
        changefragment(R.id.landscape2, matchResult)

    }
    override fun onClickScores(match: Matches) {
        initFragment(match)
        var valueh = resources.configuration.screenHeightDp
        var valuew = resources.configuration.screenWidthDp
        Toast.makeText(this, valuew.toString()+"x"+valueh.toString(), Toast.LENGTH_SHORT).show()
    }
}
