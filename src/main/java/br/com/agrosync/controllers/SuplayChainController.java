package br.com.agrosync.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrosync.models.SuplyChain;
import br.com.agrosync.repository.SuplyChainRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agrosync/suplychain")
public class SuplayChainController {

    @Autowired
    private SuplyChainRepository suplychainRepository;


    @PostMapping
    public ResponseEntity<SuplyChain> criarSuplyChain(@RequestBody @Valid SuplyChain suplychain) {
        SuplyChain suplychainCriado = suplychainRepository.save(suplychain);
        return ResponseEntity.status(HttpStatus.CREATED).body(suplychainCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuplyChain> buscarSuplyChainPorId(@PathVariable Long id) {
        return suplychainRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuplyChain> atualizarSuplyChainPorId(@PathVariable Long id,
            @RequestBody @Valid SuplyChain suplychainAtualizado) {
        return suplychainRepository.findById(id)
                .map(suplychain -> {
                    suplychain.setId(id);
                    SuplyChain suplychainAtualizadoSalvo = suplychainRepository.save(suplychainAtualizado);
                    return ResponseEntity.ok(suplychainAtualizadoSalvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarSuplyChainPorId(@PathVariable Long id) {
        return suplychainRepository.findById(id)
                .map(suplychain -> {
                    suplychainRepository.delete(suplychain);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
