package com.pucmm.edu.inventory.Repositories;

import java.util.List;

import com.pucmm.edu.inventory.Entities.Client;
import com.pucmm.edu.inventory.Entities.Receipt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptsRepository extends JpaRepository<Receipt, String> {
    Receipt findByUuid(String uuid);

    List<Receipt> findAllByClient(Client client);

    List<Receipt> findAllByPendingOrderByDeliveryDateDesc();
}