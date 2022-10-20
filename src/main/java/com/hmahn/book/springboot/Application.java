package com.hmahn.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // SpringBootApplication으로 인해 스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 자동처리
    // SpringBootApplication으로 설정된 현재 이 클래스는 항상 프로젝트 최상단에 위치해야 함

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행
    }
}
