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

import br.com.agrosync.models.User;
import br.com.agrosync.repository.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agrosync/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> listarUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUserPorId(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> criarUser(@Valid @RequestBody User user) {
        User novoUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUserPorId(@PathVariable Long id,
            @Valid @RequestBody User userAtualizado) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userAtualizado.getName());
            user.setGender(userAtualizado.getGender());
            user.setEmail(userAtualizado.getEmail());
            user.setCpf(userAtualizado.getCpf());
            user.setBirthDate(userAtualizado.getBirthDate()); // Mantenha a data como string

            User userAtualizadoNoBanco = userRepository.save(user);
            return ResponseEntity.ok(userAtualizadoNoBanco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUserPorId(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
