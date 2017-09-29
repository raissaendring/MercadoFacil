package br.com.endring.mercadofacil

import java.io.Serializable

/**
 * Created by primelan on 9/28/17.
 */
class Lista (val codigo : String, val nome : String, var produtos: List<Produto>) : Serializable {
}