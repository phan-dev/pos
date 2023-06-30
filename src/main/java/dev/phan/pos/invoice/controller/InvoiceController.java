package dev.phan.pos.invoice.controller;

import dev.phan.pos.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("invoices/customer/{id}")
    public ResponseEntity<Map<Long, String>> getInvoiceAndTenderTypeByCustomerId(@PathVariable("id") long id) {
        Map<Long, String> invoiceAndTenderTypeMap = invoiceService.getInvoiceAndTenderTypeByCustomerId(id);

        if (invoiceAndTenderTypeMap.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(invoiceAndTenderTypeMap, HttpStatus.OK);
    }
}
