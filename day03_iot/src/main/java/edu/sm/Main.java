package edu.sm;

import edu.sm.util.HttpSendData;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String url = "http://localhost:80/iot/power";

        Random r = new Random();
        HttpSendData httpSendData = new HttpSendData();

        for(int i=0; i<100; i++) {
            float num = r.nextFloat() * 100;
            httpSendData.send(url, num+"");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}