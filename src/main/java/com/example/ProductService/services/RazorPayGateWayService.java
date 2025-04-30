package com.example.ProductService.services;


import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;

import org.springframework.stereotype.Service;

@Service
public class RazorPayGateWayService implements PaymentService{
    private RazorpayClient razorPayClient;
    public RazorPayGateWayService(RazorpayClient razorPayClient){
        this.razorPayClient = razorPayClient;
    }
    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject(); //request body / payload to be sent to razorpay
        paymentLinkRequest.put("amount",1000); //10 rupees. PG supports amounts upto 2 decimal places. 10.50 => 1050
        paymentLinkRequest.put("currency","INR");
        //paymentLinkRequest.put("accept_partial",true);
        //paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis() + 10*60*1000); //epoch, 10 minutes = 6*10^5 ms
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Test payment for Integration of Payment gateway session on 11th Jan 25");

        JSONObject customer = new JSONObject();
        customer.put("name","Samir Sardhara");
        customer.put("contact","+91 9328032151");
        customer.put("email","samirsardhara99@gmail.com");
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable",true);

        //JSONObject notes = new JSONObject();
        //notes.put("policy_name","Jeevan Bima");
        //paymentLinkRequest.put("notes",notes);

        paymentLinkRequest.put("callback_url","https://www.scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorPayClient.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }
}
