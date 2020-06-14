package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Client;
import com.pucmm.edu.inventory.Entities.Receipt;
import com.pucmm.edu.inventory.Repositories.ReceiptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReceiptsServices {
    @Autowired
    ReceiptsRepository receiptsRepository;

    @Transactional
    public void createReceipt(Receipt receipt) {
        receiptsRepository.save(receipt);
    }

    @Transactional
    public void updateStatus(Receipt receipt, Boolean status) {
        receipt.setPending(status);
        receiptsRepository.save(receipt);
    }

    @Transactional
    public void updateDate(Receipt receipt, String date) {
        receipt.setReturnDate(date);
        receiptsRepository.save(receipt);
    }

    public List<Receipt> receiptList(Boolean x) {
        return receiptsRepository.findAllByPendingOrderByReturnDateDesc(x);
    }

    public List<Receipt> receiptListAll() {
        return receiptsRepository.findAll();
    }

    @Transactional
    public void setCost(Receipt receipt, float cost) {
        receipt.setCost(cost);
        receiptsRepository.save(receipt);
    }

    public List<Receipt> receiptsByClient(Client client) {
        return receiptsRepository.findAllByClient(client);
    }

    public Receipt findReceipt(int id) {
        return receiptsRepository.findById(id).get();
    }
}
