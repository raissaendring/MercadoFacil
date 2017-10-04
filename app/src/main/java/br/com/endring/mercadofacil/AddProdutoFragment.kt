package br.com.endring.mercadofacil

import android.app.DialogFragment
import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.endring.mercadofacil.databinding.FragmentAddProdutoBinding

/**
 * Created by raissa on 03/10/17.
 */
class AddProdutoFragment : DialogFragment() {
    lateinit var binding : FragmentAddProdutoBinding
    var listaViewModel: ListaViewModel?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_produto,container,false)

        binding.btnAdd.setOnClickListener({
            addProdutoClicked()
        })
        return binding.root
    }

    fun addProdutoClicked(){
        listaViewModel?.addProduto(binding.nomeProduto.text.toString())
        dismiss()
    }

}