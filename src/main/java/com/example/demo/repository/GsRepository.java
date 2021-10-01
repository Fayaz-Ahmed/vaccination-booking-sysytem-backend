package com.example.demo.repository;

import com.example.demo.entity.Gs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface GsRepository extends JpaRepository<Gs, Long> {
}
