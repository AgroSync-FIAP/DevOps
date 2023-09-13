package br.com.agrosync.controllers;

import java.util.List;
import java.util.Optional;

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

import br.com.agrosync.models.Address;
import br.com.agrosync.repository.AddressRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agrosync/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<Address> criarAddress(@Valid @RequestBody Address address) {
        Address novoAddress = addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAddress);
    }

    @GetMapping
    public ResponseEntity<List<Address>> listarAddresss() {
        List<Address> addresss = addressRepository.findAll();
        return ResponseEntity.ok(addresss);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> buscarAddressPorId(@PathVariable Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> atualizarAddressPorId(@PathVariable Long id, @Valid @RequestBody Address addressAtualizado) {
        Optional<Address> addressExistente = addressRepository.findById(id);
        if (addressExistente.isPresent()) {
            Address address = addressExistente.get();
            address.setNumero(addressAtualizado.getNumero());
            address.setRua(addressAtualizado.getRua());
            address.setBairro(addressAtualizado.getBairro());
            address.setEstado(addressAtualizado.getEstado());
            address.setPais(addressAtualizado.getPais());
            address.setCep(addressAtualizado.getCep());
            address.setComplemento(addressAtualizado.getComplemento());
            Address addressAtualizadoBD = addressRepository.save(address);
            return ResponseEntity.ok(addressAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAddressPorId(@PathVariable Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
