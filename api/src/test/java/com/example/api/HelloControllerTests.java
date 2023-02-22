package com.example.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class HelloControllerTests {
    @Autowired
    private HelloController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.controller = new HelloController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldGetHelloAvailable() throws Exception {
        this.mockMvc
                .perform(get("/api/hello"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnGetHello() throws Exception {
        this.mockMvc
                .perform(get("/api/hello"))
                .andExpect(jsonPath("$", equalTo("Hello World!!")));
    }
}