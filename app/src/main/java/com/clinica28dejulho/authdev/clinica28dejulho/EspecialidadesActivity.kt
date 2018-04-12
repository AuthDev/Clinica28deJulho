package com.clinica28dejulho.authdev.clinica28dejulho

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Adapter
import com.clinica28dejulho.authdev.clinica28dejulho.Adapters.EspecialidadesAdapter
import kotlinx.android.synthetic.main.activity_especialidades.*

class EspecialidadesActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especialidades)

        val lista = arrayOf("ANGIOLOGIA","CARDIOLOGIA","CIRURGIA GERAL","CIRURGIA PEDIÁTRICA"," CIRURGIA PLÁSTICA","ClÍNICA MÉDICA",
                "DERMATOLOGIA","DIABETOLOGIA","ENDOCRINOLOGIA","FISIOTERAPIA","GASTROENTEROLOGIA","GINECOLOGIA","INFECTOLOGIA","ODONTOLOGIA",
                "MASTOLOGIA","NEFROLOGIA","NEUROLOGIA","NUTRIÇÃO","OBSTETRICIA","OFTALMOLOGIA","ORTOPEDIA","OTORRINOLARINGOLOGIA","PEDIATRIA",
                "PNEUMOLOGIA","PROCTOLOGIA","PSICOLOGIA","PSIQUIATRIA","PSQUIATRIA IFANTIL","REUMATOLOGIA","UROLOGIA")

        viewManager = LinearLayoutManager(this)
        viewAdapter = EspecialidadesAdapter(lista ,this)
        especialidades.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

}
