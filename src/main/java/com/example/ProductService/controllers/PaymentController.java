package com.example.ProductService.controllers;

import com.example.ProductService.dtos.GeneratePaymentLinkRequestDTO;
import com.example.ProductService.services.RazorPayGateWayService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private RazorPayGateWayService razorPayGateWayService;
    public  PaymentController(RazorPayGateWayService razorPayGateWayService){
        this.razorPayGateWayService = razorPayGateWayService;
    }
    @PostMapping("/payments")
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDTO generatePaymentLinkRequestDTO) throws RazorpayException {
        return razorPayGateWayService.generatePaymentLink(generatePaymentLinkRequestDTO.getOrderId());
    }
}
