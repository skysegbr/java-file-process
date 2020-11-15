package br.com.ilegra.fileprocess.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import br.com.ilegra.fileprocess.dto.CustomerDto;


@Component
public class ClientProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queueClient")
    @Autowired
    private Queue queue;

    public void send(CustomerDto customerDto){
        rabbitTemplate.convertAndSend(this.queue.getName(), customerDto);
    }
}
