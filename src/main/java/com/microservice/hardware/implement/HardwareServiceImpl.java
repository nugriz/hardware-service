package com.microservice.hardware.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hardware.model.Hardware;
import com.microservice.hardware.repository.HardwareRepository;
import com.microservice.hardware.service.HardwareService;

@Service
public class HardwareServiceImpl implements HardwareService {

    @Autowired
    HardwareRepository hardwareRepository;

    @Override
    public List<Hardware> findAll() {
        return hardwareRepository.findAll();
    }

    @Override
    public Hardware findById(Long id) {
        return hardwareRepository.getOne(id);
    }

    @Override
    public Hardware update(Long id, Hardware hardware) {
    	hardwareRepository.findById(id);

		hardware.setId(id);
        return hardwareRepository.save(hardware);
    }

    @Override
    public Hardware create(Hardware hardware) {
        return hardwareRepository.save(hardware);
    }
    
    @Override
    public void delete(Long id) {
        hardwareRepository.deleteById(id);
    }


}