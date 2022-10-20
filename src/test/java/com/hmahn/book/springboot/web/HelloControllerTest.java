package com.hmahn.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // springboot 와 jUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) // 해당 클래스를 컨트롤러로 설정
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 웹api를 테스트할 때 사용. 스프링MVC 테스트 시작점

    @Test
    public void hello_is_return() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 날린다.
        // andExpect(status().isOk()) == mvc.perform의 결과 검증, http 상태값이 200인지 검증한다.
        // andExpect(content().string(hello)) == mvc.perform의 결과 검증, 리턴값이 hello인지 검증한다.
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto_is_return() throws Exception {
        String name = "name";
        int amount = 1000;

        // MockMvc를 통해 /hello/dto 주소로 HTTP GET 요청을 날린다.
        // param (name, value)로 요청 파라미터를 설정한다. 이때 데이터는 오직 String으로만 받는다.
        // andExpect(status().isOk()) == mvc.perform의 결과 검증, http 상태값이 200인지 검증한다.
        // andExpect(jsonPath("$.name", is(name))) / jsonPath를 통해 json 응답값을 필드별로 검증할 수 있게 한다.
        mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
