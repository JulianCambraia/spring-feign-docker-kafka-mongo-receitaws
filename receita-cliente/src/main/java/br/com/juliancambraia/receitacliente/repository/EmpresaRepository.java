package br.com.juliancambraia.receitacliente.repository;

import br.com.juliancambraia.receitacliente.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, String> {

    Empresa save(Empresa empresa);

}
