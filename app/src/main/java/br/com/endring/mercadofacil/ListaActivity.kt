package br.com.endring.mercadofacil

import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.databinding.ObservableList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import br.com.endring.mercadofacil.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaBinding

    var listasViewModel = ListaViewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lista)

        var lista: Lista = intent.getSerializableExtra("lista") as Lista
        binding.lista = lista
        binding.executePendingBindings()

        binding.recyclerLista.layoutManager=LinearLayoutManager(this)
        binding.recyclerLista.adapter=ProdutosAdapter(listasViewModel.produtos)

        listasViewModel.watchLista(lista.codigo)
        listasViewModel.produtos.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<Produto>>(){
            override fun onItemRangeMoved(p0: ObservableList<Produto>?, p1: Int, p2: Int, p3: Int) {
                binding.recyclerLista.adapter.notifyDataSetChanged()
            }

            override fun onItemRangeInserted(p0: ObservableList<Produto>?, start: Int, itemCount: Int) {
                binding.recyclerLista.adapter.notifyItemRangeInserted(start, itemCount)
            }

            override fun onChanged(p0: ObservableList<Produto>?) {
              binding.recyclerLista.adapter.notifyDataSetChanged()
            }

            override fun onItemRangeChanged(p0: ObservableList<Produto>?, start: Int, itemCount: Int) {
                binding.recyclerLista.adapter.notifyItemRangeChanged(start, itemCount)
            }

            override fun onItemRangeRemoved(p0: ObservableList<Produto>?, start: Int, itemCount: Int) {
                binding.recyclerLista.adapter.notifyItemRangeRemoved(start, itemCount)
            }

        })

    }


    fun addProduto(v: View){
        var dialogFragment = AddProdutoFragment()
        dialogFragment.listaViewModel = listasViewModel
        dialogFragment.show(fragmentManager,"dialog_add_prod")
    }
}
