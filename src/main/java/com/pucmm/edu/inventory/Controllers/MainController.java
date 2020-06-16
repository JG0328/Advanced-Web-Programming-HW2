package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.Rental;
import com.pucmm.edu.inventory.Services.ClientsServices;
import com.pucmm.edu.inventory.Services.RentalsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ClientsServices clientsServices;

    @Autowired
    private RentalsServices rentalsServices;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView history() {
        ModelAndView model = new ModelAndView();
        model.setViewName("history");
        model.addObject("clients", clientsServices.listClients());
        return model;
    }

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public ModelAndView history(@RequestParam("selectClient") int id) {
        ModelAndView model = new ModelAndView();

        List<Rental> rentalList = rentalsServices.rentalsByClient(clientsServices.findClientById(id));

        model.setViewName("history");
        model.addObject("clients", clientsServices.listClients());
        model.addObject("client", clientsServices.findClientById(id).getFullName());
        model.addObject("rentals", rentalList);
        return model;
    }
}
