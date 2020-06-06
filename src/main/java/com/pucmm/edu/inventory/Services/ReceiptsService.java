package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Client;
import com.pucmm.edu.inventory.Entities.Receipt;
import com.pucmm.edu.inventory.Repositories.ReceiptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReceiptsService {
    @Autowired
    ReceiptsRepository receiptsRepository;

    @Transactional
    public void createReceipt(Receipt receipt) {
        receiptsRepository.save(receipt);
    }

    @Transactional
    public void updateStatus(Receipt receipt, Boolean x) {

        receipt.setPending(x);
        receiptsRepository.save(receipt);
    }

    @Transactional
    public void updateDate(Receipt receipt, String returnDate) {

        receipt.setReturnDate(returnDate);
        receiptsRepository.save(receipt);
    }

    public List<Receipt> receiptsList(Boolean x) {
        return receiptsRepository.findAllByPendingOrderByReturnDateDesc(x);
    }

    public List<Receipt> receiptsListAll() {
        return receiptsRepository.findAll();
    }

    @Transactional
    public void setDays(Receipt receipt, int days) {
        receipt.setDays(days);
        receiptsRepository.save(receipt);
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
