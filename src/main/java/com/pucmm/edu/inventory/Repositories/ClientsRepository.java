package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByEnabled(Boolean enabled);
}
