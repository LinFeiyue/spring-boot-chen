package com.pache.springboot.mysql;

import com.pache.springboot.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 编写spring boot 的单元测试，并模拟servlet的请求响应
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyTest01 {

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userRepository;

    @Test
    public void getSpringBootHello() throws Exception {
        /*mvc.perform(MockMvcRequestBuilders.get("/say-hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));*/
       String responseString =  mvc.perform(MockMvcRequestBuilders.get("/say-hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(print()).andReturn().getResponse().getContentAsString();

        System.out.println("--------返回的json = " + responseString);

    }

}
