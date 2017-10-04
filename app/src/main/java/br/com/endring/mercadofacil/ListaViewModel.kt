package br.com.endring.mercadofacil

import android.database.Observable
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList
import android.util.Log
import kotlin.properties.ObservableProperty

/**
 * Created by primelan on 9/28/17.
 */
class ListaViewModel {
    var listaModel : ListaModel = ListaModel()
    var loading : Boolean = false

    val listas = ObservableArrayList<Lista>()
    val lista = ObservableField<Lista>()
    val produtos = ObservableArrayList<Produto>()

    fun getListas(){
        listas.addAll(listaModel.getListas())
    }

    fun watchLista(codigo:String){
        Log.d("MercadoFacil","watch ${ codigo}")
        listaModel.whatchLista(codigo, object : ListaModel.OnListaReadyCallback {
            override fun onListaReady(newLista: Lista) {
                Log.d("MercadoFacil","listaReady ${newLista}")
                produtos.clear()
                produtos.addAll(newLista.produtos)
            }

        })
    }

    fun addProduto(nomeProduto: String, quantidade: String=""){
        listaModel.addProduto(nomeProduto, quantidade)
    }
}