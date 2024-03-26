package project.spring.backend_koolit.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.spring.backend_koolit.model.Product;
import project.spring.backend_koolit.service.OpenFoodFactsService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final OpenFoodFactsService openFoodFactsService;

    public ProductController(OpenFoodFactsService openFoodFactsService) {
        this.openFoodFactsService = openFoodFactsService;
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<String> getProductData(@PathVariable String barcode) {
        String productData = openFoodFactsService.getProductData(barcode);
        return ResponseEntity.ok(productData);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<String> getProductDataByName(@PathVariable String productName) {
        String productDataByName = openFoodFactsService.getProductDataByName(productName);
        return ResponseEntity.ok(productDataByName);
    }
}

