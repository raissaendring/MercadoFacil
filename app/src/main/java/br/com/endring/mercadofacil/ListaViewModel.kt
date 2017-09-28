package br.com.endring.mercadofacil

import android.databinding.ObservableField

/**
 * Created by primelan on 9/28/17.
 */
class ListaViewModel {
    var listaModel : ListaModel = ListaModel()
    var loading : Boolean = false

    val listas = ObservableField<List<Lista>>()
    val lista = ObservableField<Lista>()

    fun getListas(){
        listas.set(listaModel.getListas())
    }

    fun watchLista(codigo:String){
        listaModel.whatchLista(codigo, object : ListaModel.OnListaReadyCallback {
            override fun onListaReady(newLista: Lista) {
                lista.set(newLista)
            }

        })
    }
}