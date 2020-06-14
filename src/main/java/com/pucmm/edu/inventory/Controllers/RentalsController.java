package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.Equipment;
import com.pucmm.edu.inventory.Entities.EquipmentRental;
import com.pucmm.edu.inventory.Entities.Rental;
import com.pucmm.edu.inventory.Services.ClientsServices;
import com.pucmm.edu.inventory.Services.EquipmentRentalsServices;
import com.pucmm.edu.inventory.Services.EquipmentsServices;
import com.pucmm.edu.inventory.Services.RentalsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class RentalsController {
    @Autowired
    private RentalsServices rentalsServices;

    @Autowired
    private EquipmentsServices equipmentsServices;

    @Autowired
    private EquipmentRentalsServices equipmentRentalsServices;

    @Autowired
    private ClientsServices clientsServices;

    @RequestMapping(value = "/rental", method = RequestMethod.GET)
    public ModelAndView indexRentals() {
        ModelAndView model = new ModelAndView();
        List<Rental> r = rentalsServices.receiptList(true);
        model.addObject("rentals", r);
        model.setViewName("rental/rental");
        return model;
    }

    @RequestMapping(value = "/receipt", method = RequestMethod.GET)
    public ModelAndView indexReceipts() {
        ModelAndView model = new ModelAndView();
        float c = 0;
        List<Rental> r = rentalsServices.receiptList(false);
        model.addObject("receipts", r);
        model.setViewName("rental/receipt");
        return model;
    }

    @RequestMapping(value = "/receipt/create", method = RequestMethod.GET)
    public ModelAndView createReceipt(@RequestParam("id") int id) throws ParseException {
        ModelAndView model = new ModelAndView();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        String today = sdf.format(new Date());
        Rental rental = rentalsServices.findRental(id);

        for (EquipmentRental e : rental.getEquipmentRental()) {
            Date firstDate = sdf.parse(today);
            Date secondDate = sdf.parse(rental.getDate());

            long diffInMill = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMill, TimeUnit.MILLISECONDS);
            if (diff != 0)
                equipmentRentalsServices.updateEquipmentRental(e, (int) diff * e.getEquipment().getRate() * e.getNumberRented(), (int) diff);
            else
                equipmentRentalsServices.updateEquipmentRental(e, 1 * e.getEquipment().getRate() * e.getNumberRented(), 1);
        }

        model.addObject("rental", rental);
        model.setViewName("rental/add_receipt");
        return model;
    }

    @RequestMapping(value = "/receipt/create", method = RequestMethod.POST)
    public ModelAndView createReceipt(@RequestParam("chk") List<Integer> equipmentIds, @RequestParam("idAlc") Integer id) {
        int check = 0;

        Rental rental = rentalsServices.findRental(id);

        float total = 0;

        for (Integer i : equipmentIds) {
            for (EquipmentRental e : rental.getEquipmentRental()) {
                if (e.getId() == i) {
                    equipmentRentalsServices.updateStatus(e, true);
                    total += e.getCost();
                }
            }
        }

        for (EquipmentRental ep : rental.getEquipmentRental()) {
            if (ep.isReturned())
                check++;
        }

        if (check == rental.getEquipmentRental().size()) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            rentalsServices.setCost(rental, total);
            rentalsServices.updateDate(rental, dateFormat.format(date));
            rentalsServices.updateStatus(rental, false);
        }

        return indexRentals();
    }

    @RequestMapping(value = "/rental/create", method = RequestMethod.GET)
    public ModelAndView createRental() {
        ModelAndView model = new ModelAndView();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Rental rental = new Rental();
        rental.setDate(dateFormat.format(date));
        model.addObject("rental", rental);
        model.addObject("clients", clientsServices.listClients());
        model.addObject("equipments", equipmentsServices.listEquipments(true, 0));
        model.setViewName("rental/add_rental");
        return model;
    }

    @RequestMapping(value = "/rental/create", method = RequestMethod.POST)
    public ModelAndView createRental(@RequestParam("index") List<Integer> index, @ModelAttribute("rental") Rental rental, @RequestParam("checkEquip") List<Integer> checks, @RequestParam("stockEquip") List<Integer> stocks) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = new Date();

        Set<EquipmentRental> rented = new HashSet<>();
        int ind = 0;

        for (Integer i : checks) {
            for (Equipment e : equipmentsServices.listEquipments(true, 0)) {
                if (e.getId() == i) {
                    EquipmentRental equipmentRental = new EquipmentRental();
                    equipmentRental.setEquipment(e);
                    equipmentRental.setReturned(false);
                    equipmentRental.setNumberRented(stocks.get(ind));
                    equipmentsServices.updateStock(e, e.getStock() - stocks.get(ind), stocks.get(ind));
                    ind++;
                    equipmentRentalsServices.createEquipmentRental(equipmentRental);
                    rented.add(equipmentRental);
                }
            }
        }

        rental.setDate(sdf.format(date));
        Date firstDate = sdf.parse(rental.getReturnDate());
        Date secondDate = sdf.parse(rental.getDate());

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        rental.setDays((int) diff);
        rental.setEquipmentRental(rented);
        rental.setPending(true);
        rentalsServices.createRental(rental);
        return indexRentals();
    }
}