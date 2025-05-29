package com.diegomuu.gateway.Controllers;

import com.diegomuu.gateway.DTO.TarifaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;

@RestController
@RequestMapping("/tarifas")
public class TarifaGatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/read")
    public ResponseEntity<List<TarifaDTO>> obtenerTarifas() {
        String url = "http://tarifas/tarifas/read"; // Eureka resolverá la URL del microservicio
        ResponseEntity<List<TarifaDTO>> response = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<TarifaDTO>>() {});
        return response;
    }
}

