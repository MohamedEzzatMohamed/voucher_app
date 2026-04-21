package com.mezzat.voucher_app.controller;


import com.mezzat.voucher_app.model.Voucher;
import com.mezzat.voucher_app.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voucherapi")
public class VoucherRestController {
    @Autowired
    private VoucherRepository voucherRepository;

    @GetMapping("/vouchers")
    public List<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

//    @GetMapping("/vouchers/{id}")
//    public ResponseEntity<Voucher> getVoucherById(@PathVariable("id") Long id) {
//        Optional<Voucher> voucher = voucherRepository.findById(id);
//        return voucher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @GetMapping("/vouchers/{code}")
    public Voucher getVoucherByCode(@PathVariable("code") String code) {
        return voucherRepository.findByCode(code);
    }

    @PostMapping("/vouchers")
    public Voucher createVoucher(@RequestBody Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @PutMapping("/vouchers/{id}")
    public ResponseEntity<Voucher> updateVoucher(@PathVariable Long id, @RequestBody Voucher voucherDetails) {
        Optional<Voucher> voucher = voucherRepository.findById(id);
        if (voucher.isPresent()) {
            Voucher existingVoucher = voucher.get();
            existingVoucher.setCode(voucherDetails.getCode());
            existingVoucher.setDiscount(voucherDetails.getDiscount());
            existingVoucher.setExpireDate(voucherDetails.getExpireDate());
            return ResponseEntity.ok(voucherRepository.save(existingVoucher));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/vouchers/{id}")
    public ResponseEntity<Void> deleteVoucher(@PathVariable Long id) {
        if (voucherRepository.existsById(id)) {
            voucherRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
