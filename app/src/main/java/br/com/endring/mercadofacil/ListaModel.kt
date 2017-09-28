package br.com.endring.mercadofacil

/**
 * Created by primelan on 9/28/17.
 */
class ListaModel {

    fun getListas(): List<Lista>{
        var listas : MutableList<Lista>
        listas = mutableListOf()
        listas.add(Lista("1","Lista do mercado"))
        listas.add(Lista("2", "Coisas de casa"))
        return listas
    }

    fun whatchLista(codigo:String, callback: OnListaReadyCallback){
        //todo buscar do firebase
    }

    interface OnListaReadyCallback{
        fun onListaReady(lista : Lista)
    }
}