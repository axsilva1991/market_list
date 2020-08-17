package br.com.axsilva.market_list.web.controller

import br.com.axsilva.market_list.event.producer.impl.ProducerImpl
import br.com.axsilva.market_list.web.product.dto.ProductWebDT
import br.com.axsilva.market_list.web.product.dto.toInput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class MarketListController @Autowired internal constructor(producerImpl: ProducerImpl) {
    private val producerImpl: ProducerImpl = producerImpl

    @PostMapping("/market-list")
    fun update(@RequestBody products: List<ProductWebDT>): ResponseEntity<HttpStatus> {
        producerImpl.sendMessage(products.toInput())
        return ResponseEntity(HttpStatus.CREATED)
    }
}