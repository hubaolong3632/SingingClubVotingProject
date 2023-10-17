package com.example.singingclubvotingproject.config;

public class maincc {
    public static void main(String[] args) {
        double ldsum = 19;
        ldsum = (ldsum / 2) * 0.6;
        double pwsum = 56;
        pwsum = ((pwsum - 10 - 8) / 6) * 0.3;

        System.out.println(ldsum);
        System.out.println(pwsum);

        System.out.println(ldsum + pwsum + (8.64*0.1));
    }
}
