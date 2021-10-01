package com.example.demo.repository;

import com.example.demo.entity.Moh;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MohRepository extends JpaRepository<Moh, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByNic(String nic);
}
