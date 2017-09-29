package br.com.endring.mercadofacil

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.endring.mercadofacil.databinding.ActivityListasBinding
import br.com.endring.mercadofacil.databinding.ActivityMainBinding

class ListasActivity : AppCompatActivity() {

    lateinit var binding : ActivityListasBinding

    var listasViewModel = ListaViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_listas)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_listas)

        binding.recyclerListas.layoutManager= LinearLayoutManager(this)
        binding.recyclerListas.adapter = ListasAdapter(listasViewModel.listas, object: ListasAdapter.OnItemClickListener{
            override fun onItemClick(listaClicked : Lista) {
                var it = Intent(baseContext, ListaActivity::class.java)
                it.putExtra("lista",listaClicked)
                startActivity(it)
            }

        })

        listasViewModel.getListas()
    }
}
