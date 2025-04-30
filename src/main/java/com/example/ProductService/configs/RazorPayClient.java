package com.example.ProductService.configs;

import com.razorpay.RazorpayException;
import com.razorpay.RazorpayClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayClient {

    private String razorKeyId = "rzp_test_rNAehdRytDywnd";

    private String razerpayKeySecret = "0NE7R7VBpSIbU7uB6VCaAATz";




    @Bean
    public RazorpayClient createRazorPayClient() throws RazorpayException{
        return new RazorpayClient(razorKeyId,razerpayKeySecret);
    }
}
