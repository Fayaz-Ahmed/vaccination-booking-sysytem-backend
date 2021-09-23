package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gs extends User {
    @Id
    @GeneratedValue
    private int gsid;
    @NotBlank
    private String location;
    @NotBlank
    private String gsdivision;
}
