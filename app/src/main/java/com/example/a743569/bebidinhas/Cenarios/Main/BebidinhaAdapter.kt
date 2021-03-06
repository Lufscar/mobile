package com.example.a743569.bebidinhas.Cenarios.Main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.Glide.GlideApp
import com.example.a743569.bebidinhas.R
import kotlinx.android.synthetic.main.item_da_lista.view.*

class BebidinhaAdapter(val context: Context, val bebidinhas: List<Bebidinha>)
    : RecyclerView.Adapter<BebidinhaAdapter.ViewHolder>() {

    //var do click
    private var clickListener : ((id: Int) -> Unit)? = null
    //click
    fun setOnItenClickListener(click: ((id: Int) -> Unit)) {
        this.clickListener = click
    }


    //relaciona o layout do item ao holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_da_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bebidinhas.size
    }

    //chama a fun para relacionar os dados do item à view do item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, bebidinhas[position], position, clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //relaciona todos os dados do item à view do item
        fun bindView(context: Context, bebidinha: Bebidinha, position: Int, clickListener: ((id: Int) -> Unit)?) {
            itemView.tvNome.text = bebidinha.strDrink //recebe o nome do drink

            GlideApp.with(context)
                    .load(bebidinha.strDrinkThumb)//recebe a url da imagem
                    .centerCrop()//faz a imagem ocupar o espaço destinado
                    .into(itemView.ivImagem)//relaciona ao id na

            if (clickListener != null) {
                itemView.setOnClickListener {
                        clickListener.invoke(position)
                }
            }
        }

    }

}