# Prova de Conceito API Pública Empresas Receita Federal com Spring boot, Feign Client, Kafka, Docker, MongoDB


## Objetivo

Esta Prova de conceito ir[a demonstrar como podemos consumir dados acessando uma API pública (no caso API da Receita Federal) usando as tecnologias Spring Boot, Feign Client, Kafka (Producer e Consumer) e Banco NoSQL MongoDB.

Seguindo o fluxo da arquitetura demonstrada na imagem abaixo teremos: 

Clientes diversos realizando requisições do tipo GET a uma API de consulta pública para obter dados de Empresas através do seu CNPJ. 
Essa requisição se dará via Postman. Essa comunicação entre a API externa se dará através do OpenFeign.
Uma vez termos consumido estes dados de Empresa iremos armazená-los em uma Fila Kafka (Producer). E, este Kafka estará instalado localmente em um container Docker.
Para que consigamos visualizar se as mensagens (Payloads) estão sendo enviadas para um Tópico Kafka usaremos o KafkaDrop, um client dependente do Kafka que também estará containirizado (Zookeeper, Kafka e KafkaDrop)

A próxima etapa será a construção de uma outra API Cliente que terá como objetivo consumir da fila do Kafka estas mensagens postadas e,em seguida persisti-las em um banco de dados. Que neste caso optei pelo banco noSQL MongoDB.


![alt text](https://github.com/JulianCambraia/spring-feign-docker-kafka-mongo-receitaws/blob/main/images/arquitetura-poc.png?raw=true)
