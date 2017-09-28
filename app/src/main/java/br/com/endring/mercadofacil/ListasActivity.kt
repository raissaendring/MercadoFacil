package br.com.endring.mercadofacil

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.endring.mercadofacil.databinding.ActivityMainBinding

class ListasActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    var listasViewModel = ListaViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_listas)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_listas)


    }
}
