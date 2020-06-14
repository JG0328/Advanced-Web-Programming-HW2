package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Client;
import com.pucmm.edu.inventory.Entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalsRepository extends JpaRepository<Rental, Integer> {
    List<Rental> findAllByClient(Client client);

    List<Rental> findAllByPendingOrderByReturnDateDesc(Boolean x);
}
