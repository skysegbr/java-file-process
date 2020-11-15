package br.com.ilegra.fileprocess.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import br.com.ilegra.fileprocess.dto.SailesManDto;

public class SalesManProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queueSalesMan")
    @Autowired
    private Queue queue;

    public void send(SailesManDto sailesManDto){
        rabbitTemplate.convertAndSend(this.queue.getName(), sailesManDto);
    }
}
