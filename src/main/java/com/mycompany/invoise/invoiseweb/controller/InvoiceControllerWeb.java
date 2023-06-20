package com.mycompany.invoise.invoiseweb.controller;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.invoiseweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/invoice") //prefix de l'entite cible.
public class InvoiceControllerWeb  {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

//    @PostMapping
//    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult result){
//        System.out.println("Client: "+invoiceForm.getCustomerName());
//        System.out.println(result);
////        String customerName = "kevin";
//        if(result.hasErrors()){
//            return "invoice-create-form";
//        }
//        Invoice invoice = new Invoice();
//        invoice.setCustomerName(invoiceForm.getCustomerName());
//        invoice.setOderNumber(invoiceForm.getOderNumber());
//
//        invoiceService.createInvoice(invoice);
//        return "invoice-created";
//    }

//    @GetMapping("/home")
//    public String  displayHome(Model model){
//        System.out.println("la methode display home a ete invoquee");
//        model.addAttribute("invoices", invoiceService.getInvoiceList());
//
////        List<Invoice> invoices = invoiceService.getInvoiceList();
//        return "invoice-home";
//    }

//    @GetMapping("/{id}")
//    public String  displayInvoice(@PathVariable("id") String number, Model model){
//        System.out.println("la  methode displayInvoice invoquee");
//        ModelAndView mv = new ModelAndView("invoice-details");
//        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
////        Invoice invoice = invoiceService.getInvoiceList();
//        return "invoice-details";
//    }
    @GetMapping("/create-form")
    public String displayCreateInvoiceForm(@ModelAttribute InvoiceForm invoice){
        return "invoice-create-form";
    }
}
