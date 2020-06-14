package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.EquipmentRental;
import com.pucmm.edu.inventory.Entities.Rental;
import com.pucmm.edu.inventory.Services.ClientsServices;
import com.pucmm.edu.inventory.Services.EquipmentRentalsServices;
import com.pucmm.edu.inventory.Services.EquipmentsServices;
import com.pucmm.edu.inventory.Services.RentalsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
}
