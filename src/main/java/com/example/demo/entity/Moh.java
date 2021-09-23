package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Moh extends User {
    @Id
    @GeneratedValue
    private int mohid;
    @NotBlank
    private String mohdivision;

    @NotBlank
    private String gsdivision;

    @NotBlank
    private String location;

}
