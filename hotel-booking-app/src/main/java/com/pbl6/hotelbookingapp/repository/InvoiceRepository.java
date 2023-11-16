package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Invoice;
import com.pbl6.hotelbookingapp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
