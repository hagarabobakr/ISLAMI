package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami.homeFragments.hadethFragment
import com.example.islami.homeFragments.quranFragment
import com.example.islami.homeFragments.radioFragment
import com.example.islami.homeFragments.sebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav=findViewById(R.id.nav)
        showFragment(quranFragment())
        bottomNav.setOnItemSelectedListener  {
            if (it.itemId==R.id.hadeth){
                showFragment(hadethFragment())
            }else if (it.itemId==R.id.quran){
                showFragment(quranFragment())
            }else if (it.itemId==R.id.radio){
                showFragment(radioFragment())
            }else{
                showFragment(sebhaFragment())
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_contaner,fragment).commit()
    }
}