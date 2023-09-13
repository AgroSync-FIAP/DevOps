package br.com.agrosync.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrosync.models.Problema;
import br.com.agrosync.repository.ProblemRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agrosync/problemas")
public class ProblemController {

    @Autowired
    private ProblemRepository problemaRepository;

    @GetMapping
    public ResponseEntity<Page<Problema>> listarProblemas(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Problema> problemas = problemaRepository.findAll(pageable);
        return ResponseEntity.ok(problemas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Problema> buscarProblemaPorId(@PathVariable Long id) {
        Problema problema = problemaRepository.findById(id).orElse(null);
        if (problema != null) {
            return ResponseEntity.ok(problema);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Problema> criarProblema(@Valid @RequestBody Problema novoProblema) {
        Problema problemaCriado = problemaRepository.save(novoProblema);
        return ResponseEntity.ok(problemaCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Problema> atualizarProblemaPorId(@PathVariable Long id, @Valid @RequestBody Problema problemaAtualizado) {
        if (!problemaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        problemaAtualizado.setId(id);
        Problema problemaAtualizadoDB = problemaRepository.save(problemaAtualizado);
        return ResponseEntity.ok(problemaAtualizadoDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProblemaPorId(@PathVariable Long id) {
        if (!problemaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        problemaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
