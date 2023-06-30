package dev.phan.pos.invoice.service;

import java.util.Map;

public interface InvoiceService {
    Map<Long, String> getInvoiceAndTenderTypeByCustomerId(long customerId);
}
