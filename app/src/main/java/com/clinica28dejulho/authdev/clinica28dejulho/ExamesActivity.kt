package com.clinica28dejulho.authdev.clinica28dejulho

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.clinica28dejulho.authdev.clinica28dejulho.Adapters.ExamesAdapter
import kotlinx.android.synthetic.main.activity_exames.*

class ExamesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exames)

        var examesList  = arrayOf("Colposcopia","Ecocardiograma","Endoscopia","Eletrocardiograma","Espirometria","Holter","Mamografia","Tomografia","Ultrassonografia")

        recycleExames.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = ExamesAdapter(examesList,applicationContext)
        }
    }
}
