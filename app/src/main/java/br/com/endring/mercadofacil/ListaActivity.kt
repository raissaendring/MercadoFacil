package br.com.endring.mercadofacil

import android.databinding.DataBindingUtil
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

    }


    fun addProduto(v: View){

    }
}
