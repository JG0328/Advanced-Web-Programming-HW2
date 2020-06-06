package com.pucmm.edu.inventory.Repositories;

import java.util.List;

import com.pucmm.edu.inventory.Entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Client, String> {
    List<Client> findAllByIsActive(Boolean isctive);

    Client findById(int id);
}