package br.com.axsilva.market_list.event.producer

import br.com.axsilva.market_list.`imput-boundary`.Product

interface Producer {
    fun sendMessage(products: List<Product>?)
}