package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Client;
import com.pucmm.edu.inventory.Repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientsServices {
    @Autowired
    ClientsRepository clientsRepository;

    @Transactional
    public void createClient(Client client) {
        clientsRepository.save(client);
    }

    public Client findClientById(int id) {
        return clientsRepository.findById(id).get();
    }

    @Transactional
    public void deleteClient(Client client) {
        client.setEnabled(false);
        clientsRepository.save(client);
    }

    public List<Client> listClients() {
        return clientsRepository.findAllByEnabled(true);
    }
}
