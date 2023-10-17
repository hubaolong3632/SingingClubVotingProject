package com.example.singingclubvotingproject.config;

import java.time.Instant;

public class maincc {
    public static void main(String[] args) {
        Instant current_timestamp = Instant.now();
        long seconds = current_timestamp.getEpochSecond();
        System.out.println(seconds);
//        double ldsum = 19;
//        ldsum = (ldsum / 2) * 0.6;
//        double pwsum = 56;
//        pwsum = ((pwsum - 10 - 8) / 6) * 0.3;
//
//        System.out.println(ldsum);
//        System.out.println(pwsum);
//
//        System.out.println(ldsum + pwsum + (8.64*0.1));
    }
}
