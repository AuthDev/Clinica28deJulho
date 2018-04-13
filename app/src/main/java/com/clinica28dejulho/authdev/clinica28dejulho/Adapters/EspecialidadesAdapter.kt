package com.clinica28dejulho.authdev.clinica28dejulho.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clinica28dejulho.authdev.clinica28dejulho.R
import kotlinx.android.synthetic.main.item_procedimentos.view.*

class EspecialidadesAdapter(private val lista:Array<String>, private val context:Context) : Adapter<EspecialidadesAdapter.ViewHolder>()
{

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.textV?.text = lista[position]
    }

    override fun getItemCount(): Int {
        return  lista.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_procedimentos,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val textV = itemView.btn_procedimento
    }
}