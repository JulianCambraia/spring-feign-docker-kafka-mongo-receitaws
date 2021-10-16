
package br.com.juliancambraia.receitaws.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class ReceitaCnpjResponse {

    private String abertura;

    @JsonProperty(value = "atividade_principal")
    private List<AtividadePrincipal> atividadePrincipal;

    @JsonProperty(value = "atividades_secundarias")
    private List<AtividadesSecundaria> atividadesSecundaria = new ArrayList<>();

    private String bairro;
    private Billing billing;
    private String capitalSocial;
    private String cep;
    private String cnpj;
    private String complemento;
    private String dataSituacao;
    private String dataSituacaoEspecial;
    private String efr;
    private String email;
    private Extra extra;
    private String fantasia;
    private String logradouro;
    private String motivoSituacao;
    private String municipio;
    private String naturezaJuridica;
    private String nome;
    private String numero;
    private String porte;
    private List<Object> qsa;
    private String situacao;
    private String situacaoEspecial;
    private String status;
    private String telefone;
    private String tipo;
    private String uf;
    private String ultimaAtualizacao;

}
