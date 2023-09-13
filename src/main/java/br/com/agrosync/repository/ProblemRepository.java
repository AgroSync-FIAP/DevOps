package br.com.agrosync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agrosync.models.Problema;

public interface ProblemRepository extends JpaRepository<Problema, Long> {
}
