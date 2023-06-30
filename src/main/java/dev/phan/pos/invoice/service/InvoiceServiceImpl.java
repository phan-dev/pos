package dev.phan.pos.invoice.service;

import dev.phan.pos.invoice.model.Invoice;
import dev.phan.pos.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public Map<Long, String> getInvoiceAndTenderTypeByCustomerId(long customerId) {
        Map<Long, String> invoiceAndTenderTypeMap = new HashMap<>();
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);

        for (Invoice invoice : invoices) {
            invoiceAndTenderTypeMap.put(invoice.getInvoiceId(), invoice.getInvoiceData().getTenderDetails().getType());
        }

        return invoiceAndTenderTypeMap;
    }
}