package br.com.axsilva.market_list.event.consumer

import br.com.axsilva.market_list.`imput-boundary`.Product
import br.com.axsilva.market_list.event.producer.impl.ProducerImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class Consumer2() {
    private val logger: Logger = LoggerFactory.getLogger(ProducerImpl::class.java)

    @KafkaListener(topics = ["updateProducts"], groupId = "group_id")
    fun consume(product: List<Product>?) {
        logger.info(String.format("#### -> Consumed message _2 -> %s", product))
    }
}
