package br.com.agrosync.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrosync.models.Login;
import br.com.agrosync.repository.LoginRepository;

@RestController
@RequestMapping("/agrosync/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;


    @PostMapping
    public ResponseEntity<Login> criarLogin(@RequestBody Login login) {
        boolean loginExistente = loginRepository.existsByEmail(login.getEmail());
        if (loginExistente) {
            return ResponseEntity.badRequest().body(null);
        }

        Login novoLogin = loginRepository.save(login);
        return ResponseEntity.ok(novoLogin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> obterLoginPorId(@PathVariable Long id) {
        Optional<Login> loginOptional = loginRepository.findById(id);
        if (loginOptional.isPresent()) {
            Login login = loginOptional.get();
            return ResponseEntity.ok(login);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Login> atualizarLogin(@PathVariable Long id, @RequestBody Login loginAtualizado) {
        Optional<Login> loginOptional = loginRepository.findById(id);
        if (loginOptional.isPresent()) {
            Login login = loginOptional.get();
            login.setUser(loginAtualizado.getUser());
            login.setSenha(loginAtualizado.getSenha());

            Login loginAtual = loginRepository.save(login);
            return ResponseEntity.ok(loginAtual);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLogin(@PathVariable Long id) {
        Optional<Login> loginOptional = loginRepository.findById(id);
        if (loginOptional.isPresent()) {
            Login login = loginOptional.get();
            loginRepository.delete(login);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
