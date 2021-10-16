package br.com.juliancambraia.receitacliente.controller;

import br.com.juliancambraia.receitacliente.model.Empresa;
import br.com.juliancambraia.receitacliente.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/empresa")
public class EnderecoResource {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa) {
        empresaService.save(empresa);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getListaEmpresas() {
        List<Empresa> listaEmpresas = empresaService.getListaEmpresas();
        return ResponseEntity.ok(listaEmpresas);
    }

}
