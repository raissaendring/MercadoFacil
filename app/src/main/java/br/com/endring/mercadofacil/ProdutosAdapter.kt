package br.com.endring.mercadofacil

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.endring.mercadofacil.databinding.ItemProdutoBinding

/**
 * Created by raissa on 28/09/17.
 */
class ProdutosAdapter(var produtos: List<Produto>) : RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProdutosViewHolder {
        return ProdutosViewHolder(ItemProdutoBinding.inflate(LayoutInflater.from(parent?.context),parent,false))
    }

//    override fun getItemCount(): Int = if(lista?.produtos?.size != null)lista?.produtos?.size as Int else 0
override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: ProdutosViewHolder?, position: Int) {
        holder?.bind(produtos.get(position))
    }


    class ProdutosViewHolder(var binding: ItemProdutoBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(produto: Produto?){
            binding.produto=produto
            binding.executePendingBindings()
        }

    }

}