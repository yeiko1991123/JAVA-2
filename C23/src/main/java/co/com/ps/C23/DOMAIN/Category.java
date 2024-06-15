package co.com.ps.C23.DOMAIN;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "category_id")
    private Long categoryId;

    @Column(columnDefinition = "category_name", nullable = false, unique = true, length = 100)
    private String categoryName;

    @Column(columnDefinition = "description", length = 250)
    private String description;
}

//CREATE TABLE categories (
//		category_id SERIAL PRIMARY KEY,
//		category_name VARCHAR(100) NOT NULL UNIQUE,
//description VARCHAR(255)
//);