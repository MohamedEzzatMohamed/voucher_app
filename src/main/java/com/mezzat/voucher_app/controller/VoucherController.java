package com.mezzat.voucher_app.controller;

import com.mezzat.voucher_app.model.Voucher;
import com.mezzat.voucher_app.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VoucherController {

    @Autowired
    VoucherRepository voucherRepository;

    @GetMapping("/showCreateVouchers")
    public String showCreateVouchers() {
        return "createVoucher";
    }

    @PostMapping("/saveVoucher")
    public String saveVoucher(Voucher voucher){
        voucherRepository.save(voucher);
        return "createResponse";
    }

    @GetMapping("/showGetVoucher")
    public String showGetVoucher() {
        return "getVoucher";
    }

    @PostMapping("/getVoucher")
    public ModelAndView getVoucher(String code){
        Voucher voucher = voucherRepository.findByCode(code);
        ModelAndView modelAndView = new ModelAndView("voucherDetails");
        modelAndView.addObject("voucher", voucher);
        return modelAndView;
    }

}
