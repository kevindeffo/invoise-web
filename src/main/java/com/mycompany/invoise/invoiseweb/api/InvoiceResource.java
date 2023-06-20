package com.mycompany.invoise.invoiseweb.api;

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

@RestController
@RequestMapping("/invoice") //prefix de l'entite cible.
public class InvoiceResource {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){

      return   invoiceService.createInvoice(invoice);
    }

    @GetMapping("/home")
    public Iterable<Invoice> List(){
        System.out.println("la methode display home a ete invoquee");
        return invoiceService.getInvoiceList();
    }

    @GetMapping("/{id}")
    public Invoice  get(@PathVariable("id") String number, Model model){
        System.out.println("la  methode displayInvoice invoquee");
        return invoiceService.getInvoiceByNumber(number);
    }
//    @GetMapping("/create-form")
//    public String displayCreateInvoiceForm(@ModelAttribute InvoiceForm invoice){
//        return "invoice-create-form";
//    }
}
