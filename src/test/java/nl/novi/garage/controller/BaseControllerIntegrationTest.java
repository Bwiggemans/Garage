package nl.novi.garage.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableConfigurationProperties
class BaseControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void welcomGarage(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to the Garage webservice"));
    }

    @Test
    void goodbyeGarage(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/goodbye"))
                .andExpect(status().isOk())
                .andExpect(content().string("Goodbye, you are leaving the Garage webservice. Have a nice day!"));
    }


}