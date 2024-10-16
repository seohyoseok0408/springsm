package edu.sm.app;

import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.Scanner;

// http 요청을 어떤 주소로 할 것인가
// charts/chart4 로 보내
// 데이터를 넣어야해 : post
// while 문에서 time 걸고 예를 들어 4초에 한번씩 랜덤한 수를 보냄
// postForObject() : POST 요청을 보내고 객체로 결과를 반환받음
public class GasMeter {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:80/gas";

        Random r = new Random();
        while (true) {
            try {
                int data = r.nextInt(10) + 1;
                Thread.sleep(1000);
                Integer dataToSend = data; // 보낼 데이터
                String response = restTemplate.postForObject(url, dataToSend, String.class);
                System.out.println("POST Response: " + response);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}