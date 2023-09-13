package br.com.agrosync.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agrosync.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> findByNameContaining(String descricao, Pageable pageable);

    Optional<Company> findByEmail(String emailEmpresa);
}
