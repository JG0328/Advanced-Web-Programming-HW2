package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.Client;
import com.pucmm.edu.inventory.Services.ClientsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientsController {
    @Autowired
    private ClientsServices clientsServices;

    @RequestMapping(value = "indexClients", method = RequestMethod.GET)
    public ModelAndView indexClients() {
        ModelAndView model = new ModelAndView();
        List<Client> clients = clientsServices.listClients();
        model.addObject("clients", clients);
        model.setViewName("Clients/index");
        return model;
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.GET)
    public ModelAndView newClient() {
        return new ModelAndView("Clients/new", "client", new Client());
    }
}
