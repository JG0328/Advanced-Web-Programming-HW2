package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Client;
import com.pucmm.edu.inventory.Entities.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptsRepository extends JpaRepository<Receipt, Integer> {
    List<Receipt> findAllByClient(Client client);

    List<Receipt> findAllByPendingOrderByReturnDateDesc(Boolean x);
}
