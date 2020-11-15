package br.com.ilegra.fileprocess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;


@SpringBootApplication
public class FileprocessApplication {
	@Value("${queue.salesMan.name}")
    private String salesManQueue;

    @Value("${queue.sales.name}")
    private String salesQueue;

	@Value("${queue.client.name}")
    private String clientQueue;

	public static void main(String[] args) {
		SpringApplication.run(FileprocessApplication.class, args);
	}
	
	@Bean
    public Queue queueSalesMan(){
        return new Queue(salesManQueue, true);
    }

    @Bean
    public Queue queueSales(){
        return new Queue(salesQueue, true);
	}
	
	@Bean
    public Queue queueClient(){
        return new Queue(clientQueue, true);
    }
}
