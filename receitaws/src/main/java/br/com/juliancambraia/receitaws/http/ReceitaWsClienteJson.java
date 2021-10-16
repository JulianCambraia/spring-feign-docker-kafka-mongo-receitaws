package br.com.juliancambraia.receitaws.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceitaWsClienteJson {

    private String cnpj;
    private String complemento;
    private LocalDate dataSituacaoEspecial;
    private String fantasia;
}
