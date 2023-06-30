package dev.phan.pos.invoice.model;

public class Invoice {

    private long invoiceId;
    private long customerId;
    private InvoiceData invoiceData;

    public Invoice(long customerId, InvoiceData invoiceData) {
        this.customerId = customerId;
        this.invoiceData = invoiceData;
    }

    public Invoice() {
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", customerId=" + customerId +
                ", invoiceData='" + invoiceData + '\'' +
                '}';
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }
}
