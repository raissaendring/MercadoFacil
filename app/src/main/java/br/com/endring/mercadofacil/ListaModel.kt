package br.com.endring.mercadofacil

import android.util.Log
import com.google.firebase.database.*


/**
 * Created by primelan on 9/28/17.
 */
class ListaModel {

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
        val myRef = database.getReference("listas").child(codigo)
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                Log.d("MercadoFacil","ondatachange")
                if(dataSnapshot?.getValue(Lista::class.java)!=null) {
                    Log.d("MercadoFacil","ondatachange lista!=null")
                    lista = dataSnapshot.getValue(Lista::class.java)
                    callback.onListaReady(lista)
                }
            }

            override fun onCancelled(error: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        Log.d("MercadoFacil","ondatachange 1")
        myRef.setValue(lista)
    }

    fun stopWatchingLista(codigo: String){

    }

    interface OnListaReadyCallback{
        fun onListaReady(lista : Lista)
    }
}