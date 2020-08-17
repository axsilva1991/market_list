package br.com.axsilva.market_list.event.producer.impl

import br.com.axsilva.market_list.`imput-boundary`.Product
import br.com.axsilva.market_list.event.producer.Producer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProducerImpl(
        @Value("\${kafka.topic.update-products}")
        private val topic: String? = null
):Producer {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
    private final val msgSend = "sending products='{}'"

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    override fun sendMessage(products: List<Product>?) {
        LOGGER.info(String.format("$msgSend${products.toString()} -> to topic:$topic", products))
        kafkaTemplate!!.send(topic.toString(), UUID.randomUUID().toString(), products.toString())
    }
}