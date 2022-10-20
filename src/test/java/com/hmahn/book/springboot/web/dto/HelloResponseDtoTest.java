package com.hmahn.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        //Given
        String name = "test";
        int amount  = 1000;

        //When
        HelloResponseDto dto = new HelloResponseDto(name, amount); // RequiredArgsConstructor에 의해 생성자 자동생성

        //Then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
