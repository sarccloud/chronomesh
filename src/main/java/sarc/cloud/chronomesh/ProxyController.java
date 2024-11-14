package sarc.cloud.chronomesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class ProxyController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String TARGET_SYSTEM_URL = "https://sarc.pucrs.br/Default/Export.aspx?id=%s&ano=%s&sem=%s";

    @GetMapping("/forward/{id}")
    public ResponseEntity<?> forwardRequest(@PathVariable String id) {
        // Forward the GET request to the target system
        String year = "2024"; // FIXME: get current year?
        String period = "2";
        ResponseEntity<String> response = restTemplate.getForEntity(String.format(TARGET_SYSTEM_URL, id, year, period),
                String.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
    
}
