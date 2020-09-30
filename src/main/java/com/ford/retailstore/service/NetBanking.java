package com.ford.retailstore.service;

import java.util.concurrent.ThreadLocalRandom;

public class NetBanking implements PaymentChannel {

    @Override
    public String pay() {
        String stringStart = "NET";
        int min = 10;
        int max = 99;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return stringStart + randomNum;
    }
}
