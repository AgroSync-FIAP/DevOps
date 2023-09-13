package br.com.agrosync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agrosync.models.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

    boolean existsByEmail(String email);

}
