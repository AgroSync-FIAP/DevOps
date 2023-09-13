package br.com.agrosync.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agrosync.models.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    Page<Assessment> findAll(Pageable pageable);
}
