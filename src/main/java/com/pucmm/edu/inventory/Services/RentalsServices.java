package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Client;
import com.pucmm.edu.inventory.Entities.Rental;
import com.pucmm.edu.inventory.Repositories.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RentalsServices {
    @Autowired
    RentalsRepository rentalsRepository;

    @Transactional
    public void createRental(Rental rental) {
        rentalsRepository.save(rental);
    }

    @Transactional
    public void updateStatus(Rental rental, Boolean status) {
        rental.setPending(status);
        rentalsRepository.save(rental);
    }

    @Transactional
    public void updateDate(Rental rental, String date) {
        rental.setReturnDate(date);
        rentalsRepository.save(rental);
    }

    public List<Rental> receiptList(Boolean x) {
        return rentalsRepository.findAllByPendingOrderByReturnDateDesc(x);
    }

    public List<Rental> receiptListAll() {
        return rentalsRepository.findAll();
    }

    @Transactional
    public void setCost(Rental rental, float cost) {
        rental.setCost(cost);
        rentalsRepository.save(rental);
    }

    public List<Rental> receiptsByClient(Client client) {
        return rentalsRepository.findAllByClient(client);
    }

    public Rental findRental(int id) {
        return rentalsRepository.findById(id).get();
    }
}
