package dev.phan.pos.invoice.repository;

import com.google.gson.Gson;
import dev.phan.pos.invoice.model.Invoice;
import dev.phan.pos.invoice.model.InvoiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcInvoiceRepository implements InvoiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Invoice> findByCustomerId(long customerId) {
        String query = "SELECT * FROM invoice WHERE customer_id=?";

        return jdbcTemplate.query(query, new InvoiceRowMapper(), customerId);
    }

    // Parse JSON string to Java object using GSON
    class InvoiceRowMapper implements RowMapper<Invoice> {

        @Override
        public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
            Invoice invoice = new Invoice();
            invoice.setInvoiceId(rs.getLong(1));
            invoice.setCustomerId(rs.getLong(2));

            Gson gson = new Gson();
            InvoiceData invoiceData = gson.fromJson(rs.getString(3), InvoiceData.class);
            invoice.setInvoiceData(invoiceData);

            return invoice;
        }
    }
}
