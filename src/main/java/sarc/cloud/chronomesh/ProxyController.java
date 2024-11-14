package sarc.cloud.chronomesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * ProxyController serves as a proxy to forward requests to a OpenSARC system.
 * 
 * This controller provides an API endpoint to forward requests and retrieve
 * data from a specified class timetable based on year, period, and ID
 * parameters.
 * 
 * These parameters are present on the original OpenSARC URL.
 * Parameters year and period represent the class period, mostly the current
 * semester.
 * For instance, 2024 and 2.
 * Parameter ID is generated by OpenSARC to represent the class using .Net GUID.
 * For instance, b82f27a8-2f79-438e-add2-da55a58d2c89.
 * 
 * An original OpenSARC timetable URL would be:
 * https://<sarc host>/Default/Export.aspx?id=<id>&ano=<year>&sem=<period>
 * 
 * Chronomesh uses the following format:
 * http://<chronomesh host>/api/v1/forward/<year>/<period>/<id>
 * 
 * For instance, for a given class, the SARC URL is:
 * https://<sarc
 * host>/Default/Export.aspx?id=b82f27a8-2f79-438e-add2-da55a58d2c89&ano=2024&sem=2
 * 
 * and the corresponding Chronomesh would be:
 * http://<chronomesh
 * host>/api/v1/forward/2024/2/b82f27a8-2f79-438e-add2-da55a58d2c89
 *
 * @author marco.mangan@gmail.com
 */
@RestController
@RequestMapping("/api/v1")
public class ProxyController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * The base OpenSARC class timetable URL where requests will be forwarded.
     * The URL uses format specifiers for year, period, and ID parameters.
     */
    private static final String TARGET_SYSTEM_URL = "https://sarc.pucrs.br/Default/Export.aspx?id=%s&ano=%s&sem=%s";

    /**
     * Forwards a GET request to OpenSARC based on the specified year,
     * period, and ID. Retrieves the response from the target system and returns
     * it to the original requester.
     *
     * @param year   the academic year parameter for the request
     * @param period the semester or period parameter for the request
     * @param id     the unique identifier for the specific class timetable
     * @return ResponseEntity containing the response from OpenSARC
     */
    @GetMapping("/forward/{year}/{period}/{id}")
    public ResponseEntity<?> forwardRequest(@PathVariable String year, @PathVariable String period,
            @PathVariable String id) {
        ResponseEntity<String> response = restTemplate.getForEntity(String.format(TARGET_SYSTEM_URL, id, year, period),
                String.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

}
