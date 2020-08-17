package br.com.axsilva.market_list.domain.entitities

class Buy(
        val BuyID: Long,
        val list: List<Product>,
        val nextBuy: String,
        val lastBuy: String
) {

}
