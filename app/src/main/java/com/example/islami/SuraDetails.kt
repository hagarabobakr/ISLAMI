package com.example.islami

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import kotlin.streams.toList

class SuraDetails : AppCompatActivity() {
    lateinit var SuaraNameTextView:TextView
    lateinit var suraContentTextView:TextView
    lateinit var BackArrow: ImageView
    var suraContent=" "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val fileName=intent.getStringExtra(FILE_NAME)
        val suraName=intent.getStringExtra(SURA_NAME)
        SuaraNameTextView=findViewById(R.id.SuraName)
        SuaraNameTextView.text= suraName
        suraContentTextView=findViewById(R.id.suraContent)
        BackArrow=findViewById(R.id.back_arrow)
        BackArrow.setOnClickListener{
            finish()
        }
        //readSuraFile(fileName?:"")
        suraContentTextView.text=suraContent


    }
    fun readSuraFile(fileName :String){
        val reader =BufferedReader(
            InputStreamReader(assets.open(fileName))
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
           val lines= reader.lines().toList()
            for (i in 0.. lines.size){
                val line= lines.get(i)
                suraContent += line +"(${i+1})"
            }




        }
    }
}