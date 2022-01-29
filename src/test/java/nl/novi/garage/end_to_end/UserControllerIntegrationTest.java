package nl.novi.garage.end_to_end;

import nl.novi.garage.GarageApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = GarageApplication.class)
@AutoConfigureMockMvc
@EnableConfigurationProperties
//@WithMockUser(username = "admin", roles = {"ADMIN"})
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturn200ForEndpointUsersAdmin() throws Exception {
        mockMvc.perform(get("/users").with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200ForEndpointUsersUsers() throws Exception {
        mockMvc.perform(get("/users").with(user("users").roles("ADMIN")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnJson() throws Exception {

        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON).with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


}
