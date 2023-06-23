package com.microservice.hardware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.hardware.model.Hardware;

/**
 * @author fascal
 */
public interface HardwareRepository extends JpaRepository<Hardware, Long> {

}