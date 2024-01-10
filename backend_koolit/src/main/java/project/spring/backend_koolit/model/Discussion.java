package project.spring.backend_koolit.model;

import jakarta.persistence.*;


@Entity
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;

    // Add other fields as needed

    // Getters and setters
}
