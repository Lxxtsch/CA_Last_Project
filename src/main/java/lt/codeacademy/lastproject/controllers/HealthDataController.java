package lt.codeacademy.lastproject.controllers;


import lt.codeacademy.lastproject.dto.HealthDataDTO;
import lt.codeacademy.lastproject.services.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/health-data")
public class HealthDataController {

    private final HealthDataService healthDataService;

    @Autowired
    public HealthDataController(HealthDataService healthDataService) {
        this.healthDataService = healthDataService;
    }

    @PostMapping
    public ResponseEntity<HealthDataDTO> createHealthData(@PathVariable Long userId, @RequestBody HealthDataDTO healthDataDTO) {
        HealthDataDTO createdHealthData = healthDataService.createHealthData(userId, healthDataDTO);
        return new ResponseEntity<>(createdHealthData, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HealthDataDTO>> getAllHealthData() {
        List<HealthDataDTO> healthDataList = healthDataService.getAllHealthData();
        return new ResponseEntity<>(healthDataList, HttpStatus.OK);
    }

    @GetMapping("/{healthDataId}")
    public ResponseEntity<HealthDataDTO> getHealthDataById(@PathVariable Long healthDataId) {
        try {
            HealthDataDTO healthDataDTO = healthDataService.getHealthDataById(healthDataId);
            return new ResponseEntity<>(healthDataDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HealthDataDTO>> getHealthDataByUserId(@PathVariable Long userId) {
        try {
            List<HealthDataDTO> healthDataList = healthDataService.getHealthDataByUserId(userId);
            if (!healthDataList.isEmpty()) {
                return new ResponseEntity<>(healthDataList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{healthDataId}")
    public ResponseEntity<HealthDataDTO> updateHealthDataById(@PathVariable Long healthDataId,
                                                              @RequestBody HealthDataDTO healthDataDTO) {
        try {
            HealthDataDTO updatedHealthData = healthDataService.updateHealthDataById(healthDataId, healthDataDTO);
            return new ResponseEntity<>(updatedHealthData, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{healthDataId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteHealthDataById(@PathVariable Long healthDataId) {
        try {
            healthDataService.deleteHealthDataById(healthDataId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteHealthDataByUserId(@PathVariable Long userId) {
        healthDataService.deleteHealthDataByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}