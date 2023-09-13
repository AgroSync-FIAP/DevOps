package br.com.agrosync.controllers;

import br.com.agrosync.models.Farm;
import br.com.agrosync.repository.FarmRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agrosync/farm")
public class FarmController {

    @Autowired
    private FarmRepository farmRepository;


    @PostMapping
    public ResponseEntity<Farm> criarfarm(@Valid @RequestBody Farm farm) {
        Farm farmCriada = farmRepository.save(farm);
        return ResponseEntity.status(201).body(farmCriada);
    }

    @GetMapping
    public ResponseEntity<List<Farm>> listarfarms(Pageable pageable) {
        Page<Farm> page = farmRepository.findAll(pageable);
        List<Farm> farms = page.getContent();
        return ResponseEntity.ok(farms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> buscarfarmPorId(@PathVariable Long id) {
        Farm farm = farmRepository.findById(id).orElse(null);
        if (farm == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(farm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farm> atualizarfarmPorId(@PathVariable Long id, @Valid @RequestBody Farm farmAtualizada) {
        if (!farmRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        farmAtualizada.setId(id);
        Farm farmAtualizadaDB = farmRepository.save(farmAtualizada);
        return ResponseEntity.ok(farmAtualizadaDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarfarmPorId(@PathVariable Long id) {
        if (!farmRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        farmRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
