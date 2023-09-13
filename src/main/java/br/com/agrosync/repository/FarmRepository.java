package br.com.agrosync.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agrosync.models.Farm;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    Page<Farm> findByNameContaining(String name, Pageable pageable);
}
