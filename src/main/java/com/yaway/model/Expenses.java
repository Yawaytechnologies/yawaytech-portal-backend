package com.yaway.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data                       // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor          // Generates no-args constructor
@AllArgsConstructor         // Generates all-args constructor
@Entity
@Table(name = "expenses_list")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double price;

    private LocalDate date;

    private String description;

    @Column(name = "added_by")
    private String addedBy;

    private String category;
}

