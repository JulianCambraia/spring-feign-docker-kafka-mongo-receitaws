package br.com.juliancambraia.receitacliente.listener;

import br.com.juliancambraia.receitacliente.model.Empresa;
import br.com.juliancambraia.receitacliente.service.EmpresaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReceitaWsCliente {

    @Autowired
    private EmpresaService empresaService;

    @KafkaListener(topics = "${topic.receitaws-cliente}", groupId = "${spring.kafka.consumer.group-id}")
    public void obterEmpresaCliente(String empresaJson) throws JsonProcessingException {

        log.info("Mensagem empresa {}", empresaJson);

        ObjectMapper objectMapper = new ObjectMapper();
        Empresa empresa = objectMapper.readValue(empresaJson, Empresa.class);

        empresaService.save(empresa);

        log.info("Empresa salva na Base do MongoDB com sucesso {}", empresa);

    }
}
