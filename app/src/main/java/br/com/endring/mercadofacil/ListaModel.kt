package br.com.endring.mercadofacil

import android.util.Log
import com.google.firebase.database.*


/**
 * Created by primelan on 9/28/17.
 */
class ListaModel() {

    var refLista : DatabaseReference? = null
    var eventListener : ValueEventListener? = null


    fun getListas(): List<Lista>{
        var listas : MutableList<Lista>
        listas = mutableListOf()
        var prods = mutableListOf<Produto>()

        listas.add(Lista("1","Lista do mercado",prods))
        prods = mutableListOf()

        listas.add(Lista("2", "Coisas de casa", prods))
        return listas
    }

    fun whatchLista(codigo:String, callback: OnListaReadyCallback){
        //todo buscar do firebase
        var prods = mutableListOf<Produto>()
        var lista : Lista
        if(codigo=="1"){
            prods.add(Produto("açucar"))
            prods.add(Produto("toddy"))
            prods.add(Produto("carne"))
            prods.add(Produto("detergente"))
            lista=Lista("1","Lista do mercado",prods)
        }else{
            prods.add(Produto("cabides"))
            prods.add(Produto("rodinho de pia"))
            prods.add(Produto("pano de prato"))
            lista=Lista("2", "Coisas de casa", prods)
        }



        val database = FirebaseDatabase.getInstance()
        refLista = database.getReference("listas").child(codigo)
        eventListener = object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                Log.d("MercadoFacil","ondatachange")
                if(dataSnapshot?.getValue(Lista::class.java)!=null) {
                    Log.d("MercadoFacil","ondatachange lista!=null")
                    lista = dataSnapshot.getValue(Lista::class.java)
                    callback.onListaReady(lista)
                }
            }

            override fun onCancelled(error: DatabaseError?) {
            }
        }
        refLista?.addValueEventListener(eventListener)

        Log.d("MercadoFacil","ondatachange 1")
        refLista?.setValue(lista)
    }

    fun stopWatchingLista(codigo: String){
        refLista?.removeEventListener(eventListener)
    }

    fun addProduto(nomeProduto: String, quantProduto: String=""){
        refLista?.child("produtos")?.push()?.setValue(Produto(nomeProduto, quantProduto))
    }

    fun addLista(nomeLista: String) : String{
        val ref = FirebaseDatabase.getInstance().getReference("listas").push()
        ref.setValue(Lista(nome = nomeLista))
        return ref.key
    }

    interface OnListaReadyCallback{
        fun onListaReady(lista : Lista)
    }
}