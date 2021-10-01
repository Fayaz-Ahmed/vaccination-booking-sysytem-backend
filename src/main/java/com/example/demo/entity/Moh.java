package com.example.demo.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "mohdivision") })
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Moh extends User {

    @NotBlank
    private String mohdivision;

    @NotBlank
    private String gsdivision;

    @NotBlank
    private String location;
}
