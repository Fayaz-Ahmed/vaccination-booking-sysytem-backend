package com.example.demo.repository;

import com.example.demo.entity.Moh;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MohRepository extends JpaRepository<Moh, Long> {

}
