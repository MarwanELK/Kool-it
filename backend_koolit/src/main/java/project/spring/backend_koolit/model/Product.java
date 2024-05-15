package project.spring.backend_koolit.model;

import java.util.Map;

public class Product {
    private String productName;
    private String brand;
    private String ingredientsText;
    private String allergens;
    private Map<String, Object> nutriments;

    public String getProductName() {
        return productName;
    }
    // Ajoutez d'autres champs au besoin

    // Getters and setters
}

