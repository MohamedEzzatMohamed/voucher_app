package com.mezzat.voucher_app.repository;

import com.mezzat.voucher_app.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    Voucher findByCode(String code);
}
