package br.com.agrosync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agrosync.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
