package project.spring.backend_koolit.service;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.spring.backend_koolit.model.OpenFoodFactsResponse;
import project.spring.backend_koolit.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OpenFoodFactsService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "https://world.openfoodfacts.org/api/v0/product/";


    public OpenFoodFactsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getProductData(String barcode) {
        String apiUrl = "https://world.openfoodfacts.org/api/v0/product/" + barcode + ".json";
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public String getProductDataByName(String productName) {
        String apiUrl = "https://world.openfoodfacts.org/cgi/search.pl?search_terms=" + productName + "&search_simple=1&action=process&json=1";
        System.out.println("retour opf"+restTemplate.getForObject(apiUrl, String.class));
        return restTemplate.getForObject(apiUrl, String.class);
    }


}