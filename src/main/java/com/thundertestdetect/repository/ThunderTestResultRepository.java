package com.thundertestdetect.repository;

import com.thundertestdetect.entity.ThunderTestResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThunderTestResultRepository extends JpaRepository<ThunderTestResultEntity, String> {
}
