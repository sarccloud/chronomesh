package sarc.cloud.chronomesh;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.web.client.RestTemplate;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProxyController.class)
public class ProxyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testForwardRequest() throws Exception {
        // Mock the RestTemplate response
        String expectedResponseBody = "Mocked response from target system";
        when(restTemplate.getForEntity(anyString(), Mockito.eq(String.class)))
            .thenReturn(new ResponseEntity<>(expectedResponseBody, HttpStatus.OK));

        // Perform GET request to /api/forward/{id}
        mockMvc.perform(get("/api/v1/forward/123"))
            .andExpect(status().isOk())
            .andExpect(content().string(expectedResponseBody));
    }

    @Test
    public void testForwardRequestNotFound() throws Exception {
        // Mock a 404 response from the target system
        when(restTemplate.getForEntity(anyString(), Mockito.eq(String.class)))
            .thenReturn(new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND));

        // Perform GET request to /api/forward/{id}
        mockMvc.perform(get("/api/v1/forward/999"))
            .andExpect(status().isNotFound())
            .andExpect(content().string("Not Found"));
    }



}
