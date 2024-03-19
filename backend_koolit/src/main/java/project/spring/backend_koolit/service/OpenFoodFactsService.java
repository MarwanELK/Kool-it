package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.spring.backend_koolit.model.Product;

@Service
public class OpenFoodFactsService {

    private final RestTemplate restTemplate;

    public OpenFoodFactsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getProductData(String barcode) {
        String apiUrl = "https://world.openfoodfacts.org/api/v0/product/" + barcode + ".json";
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public Product[] getAllProducts() {
        String url = "https://world.openfoodfacts.org/api/v0/product/products.json";
        return restTemplate.getForObject(url, Product[].class);
    }
}
