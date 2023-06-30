package dev.phan.pos.invoice.repository;

import dev.phan.pos.invoice.model.Invoice;

import java.util.List;

public interface InvoiceRepository {
    List<Invoice> findByCustomerId(long customerId);
}
