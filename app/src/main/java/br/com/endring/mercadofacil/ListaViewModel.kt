package br.com.endring.mercadofacil

import android.database.Observable
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList
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
        listaModel.whatchLista(codigo, object : ListaModel.OnListaReadyCallback {
            override fun onListaReady(newLista: Lista) {
                lista.set(newLista)
                produtos.addAll(newLista.produtos)
            }

        })
    }
}