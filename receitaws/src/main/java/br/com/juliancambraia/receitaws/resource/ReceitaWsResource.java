package br.com.juliancambraia.receitaws.resource;

import br.com.juliancambraia.receitaws.http.ReceitaWsClienteJson;
import br.com.juliancambraia.receitaws.response.ReceitaCnpjResponse;
import br.com.juliancambraia.receitaws.service.ReceitaWsService;
import br.com.juliancambraia.receitaws.service.ReceitaWsServiceProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("receitaws")
@Log4j2
public class ReceitaWsResource {

    private final ReceitaWsService service;

    private final ReceitaWsServiceProducer producer;

    @GetMapping(value = "/{cnpj}")
    public ResponseEntity<ReceitaCnpjResponse> obterDadosEmpresaPorCnpj(@PathVariable("cnpj") String cnpj) {
        ReceitaCnpjResponse response = service.recuperarDadosEmpresaPorCnpj(cnpj);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ReceitaCnpjResponse> enviarDadosEmpresaParaKafka(@RequestBody ReceitaWsClienteJson receitaWsClienteJson) throws JsonProcessingException {
        log.info(" ** Dados enviados pelo cliente: {}", receitaWsClienteJson);
        ReceitaCnpjResponse receitaCnpjResponse = service.recuperarDadosEmpresaPorCnpj(receitaWsClienteJson.getCnpj());
        receitaCnpjResponse.setComplemento(receitaWsClienteJson.getComplemento());
        receitaCnpjResponse.setDataSituacaoEspecial(receitaWsClienteJson.getDataSituacaoEspecial().toString());
        receitaCnpjResponse.setFantasia(receitaWsClienteJson.getFantasia());

        ObjectMapper objectMapper = new ObjectMapper();
        String mensagem = objectMapper.writeValueAsString(receitaCnpjResponse);

        producer.sendMessage(mensagem);
        log.info(" **** Dados Empresa retornado pela API da Receita Federal pela consulta do CNPJ: {}", receitaCnpjResponse);

        return  ResponseEntity.ok(receitaCnpjResponse);
    }

}

