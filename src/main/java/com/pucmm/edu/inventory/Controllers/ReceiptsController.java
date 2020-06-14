package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.Receipt;
import com.pucmm.edu.inventory.Services.ClientsServices;
import com.pucmm.edu.inventory.Services.EquipmentRentalsServices;
import com.pucmm.edu.inventory.Services.EquipmentsServices;
import com.pucmm.edu.inventory.Services.ReceiptsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReceiptsController {
    @Autowired
    private ReceiptsServices receiptsServices;

    @Autowired
    private EquipmentsServices equipmentsServices;

    @Autowired
    private EquipmentRentalsServices equipmentRentalsServices;

    @Autowired
    private ClientsServices clientsServices;

    @RequestMapping(value = "/receipt", method = RequestMethod.GET)
    public ModelAndView indexReceipts() {
        ModelAndView model = new ModelAndView();
        List<Receipt> r = receiptsServices.receiptList(true);
        model.addObject("receipts", r);
        model.setViewName("receipt/receipt");
        return model;
    }
}
