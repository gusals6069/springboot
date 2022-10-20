package com.hmahn.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    // Lombok 어노테이션

    // @getter : 접근자 메소드 자동 생성 (getName)
    // @setter : 설정자 메소드 자동 생성 (setName)

    // @NoArgsConstructor : 파라미터가 '없는' 기본 생성자 생성
    // @AllArgsConstructor : '모든' 필드값을 파라미터로 받는 생성자 생성
    // @RequiredArgsConstructor : final 혹은 @NonNull이 붙은 필드의 생성자 자동생성 [특정 필드만으로 생성자를 생성할 때 사용]

    // @toString : toString 메소드를 자동 생성 제외 필드가 있을 경우 (exclude = '제외필드명') 을 붙인다.
    // @EqualsAndHashCode : equal 메소드 (값비교) / hashcode 메소드 (객체비교) 를 상속없이 자동 생성

    // @Data : 위의 어노테이션 일괄 적용

    private final String name;
    private final int  amount;
}
