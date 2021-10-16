package br.com.juliancambraia.receitaws.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReceitaWsServiceProducer {

    @Value("${topic.receitaws-cliente}")
    private String topicReceitaWsCliente;

    @Autowired
    private KafkaTemplate<String, String> template;

    public void sendMessage(String message) {
        this.template.send(topicReceitaWsCliente, message);
        log.info("Mensagem enviada para o topic-receitaws-cliente: {}", message);
    }
}
