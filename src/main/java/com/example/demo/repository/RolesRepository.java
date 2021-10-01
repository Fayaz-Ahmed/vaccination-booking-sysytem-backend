package com.example.demo.repository;

import com.example.demo.entity.MRoles;
import com.example.demo.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles findByRoles(String roles);
}
