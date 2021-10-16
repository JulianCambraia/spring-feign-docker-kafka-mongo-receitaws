package br.com.juliancambraia.receitaws.service;

import br.com.juliancambraia.receitaws.response.ReceitaCnpjResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*https://www.receitaws.com.br/v1/cnpj/30318097000146*/

@FeignClient(name = "receitaws", url = "https://www.receitaws.com.br/v1/cnpj")
public interface ReceitaWsService {

    @GetMapping(value = "/{cnpj}")
    ReceitaCnpjResponse recuperarDadosEmpresaPorCnpj(@PathVariable("cnpj") String cnpj);
}
