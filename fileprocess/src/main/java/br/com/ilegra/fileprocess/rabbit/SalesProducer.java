package br.com.ilegra.fileprocess.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import br.com.ilegra.fileprocess.dto.SaleDto;


@Component
public class SalesProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queueSales")
    @Autowired
    private Queue queue;

    public void send(SaleDto saleDto){
        rabbitTemplate.convertAndSend(this.queue.getName(), saleDto);
    }
}
