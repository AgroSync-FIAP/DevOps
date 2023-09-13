package br.com.agrosync.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrosync.models.Company;
import br.com.agrosync.repository.CompanyRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agrosync/empresa")
public class CompanyController {

    @Autowired
    private CompanyRepository empresaRepository;

    @GetMapping
    public ResponseEntity<Page<Company>> listarEmpresas(Pageable pageable) {
        Page<Company> empresas = empresaRepository.findAll(pageable);
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> buscarEmpresaPorId(@PathVariable Long id) {
        return empresaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Company> criarEmpresa(@Valid @RequestBody Company empresa) {
        Company novaEmpresa = empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> atualizarEmpresaPorId(@PathVariable Long id,
            @Valid @RequestBody Company empresaAtualizada) {
        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresa.setName(empresaAtualizada.getName());
                    empresa.setNameFantasia(empresaAtualizada.getNameFantasia());
                    empresa.setCnpj(empresaAtualizada.getCnpj());
                    empresa.setEmail(empresaAtualizada.getEmail());
                    empresa.setDescricao(empresaAtualizada.getDescricao());
                    empresa.setStatus(empresaAtualizada.getStatus());
                    Company empresaSalva = empresaRepository.save(empresa);
                    return ResponseEntity.ok(empresaSalva);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
