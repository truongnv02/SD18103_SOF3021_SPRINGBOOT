package com.poly.truongnvph29176.repositories;

import com.poly.truongnvph29176.entities.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSPRepository extends JpaRepository<DongSP, UUID> {
}
