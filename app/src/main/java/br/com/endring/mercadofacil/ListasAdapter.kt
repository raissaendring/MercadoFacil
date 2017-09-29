package br.com.endring.mercadofacil

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.endring.mercadofacil.databinding.ItemListaBinding

/**
 * Created by raissa on 28/09/17.
 */
class ListasAdapter(var listas : List<Lista>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<ListasAdapter.ListasViewHolder>() {
    override fun getItemCount(): Int = listas.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListasViewHolder {
        return ListasViewHolder(ItemListaBinding.inflate(LayoutInflater.from(parent?.context),parent,false))
    }

    override fun onBindViewHolder(holder: ListasViewHolder?, position: Int) {
        holder?.bind(listas.get(position), itemClickListener)
    }

    class ListasViewHolder(var binding: ItemListaBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(list: Lista, itemClickListener: OnItemClickListener){
            binding.lista = list
            binding.root.setOnClickListener { itemClickListener.onItemClick(list) }
//            binding.setVariable(BR.lista,list)
            binding.executePendingBindings()
        }

    }

    interface OnItemClickListener {
        fun onItemClick(listaClicked: Lista)
    }
}