package br.com.juliancambraia.receitacliente.service;

import br.com.juliancambraia.receitacliente.model.Empresa;
import br.com.juliancambraia.receitacliente.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(Empresa empresa) {
        empresaRepository.save(empresa);
        return empresa;
    }

    public List<Empresa> getListaEmpresas() {
        return empresaRepository.findAll();
    }


}
