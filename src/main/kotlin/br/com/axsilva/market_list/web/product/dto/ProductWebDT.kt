package br.com.axsilva.market_list.web.product.dto

import br.com.axsilva.market_list.`imput-boundary`.Product

data class ProductWebDT(
        val name: String,
        val quantity: Long,
        val dayDuration: Long
)

fun List<ProductWebDT>.toInput(): List<Product> {
    return this.map {
         Product(
                name = it.name,
                dayDuration = it.dayDuration,
                quantity = it.quantity
        )
    }
}