package lt.codeacademy.lastproject.controllers;

import lt.codeacademy.lastproject.dto.FitnessGoalDTO;
import lt.codeacademy.lastproject.services.FitnessGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/fitness-goals")
public class FitnessGoalController {

    private final FitnessGoalService fitnessGoalService;

    @Autowired
    public FitnessGoalController(FitnessGoalService fitnessGoalService) {
        this.fitnessGoalService = fitnessGoalService;
    }

    @PostMapping
    public ResponseEntity<FitnessGoalDTO> createFitnessGoal(@PathVariable Long userId, @RequestBody FitnessGoalDTO fitnessGoalDTO) {
        FitnessGoalDTO createdFitnessGoal = fitnessGoalService.createFitnessGoal(userId, fitnessGoalDTO);
        return new ResponseEntity<>(createdFitnessGoal, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FitnessGoalDTO>> getAllFitnessGoals() {
        List<FitnessGoalDTO> fitnessGoalList = fitnessGoalService.getAllFitnessGoals();
        return new ResponseEntity<>(fitnessGoalList, HttpStatus.OK);
    }

    @GetMapping("/{fitnessGoalId}")
    public ResponseEntity<FitnessGoalDTO> getFitnessGoalById(@PathVariable Long userId, @PathVariable Long fitnessGoalId) {
        try {
            FitnessGoalDTO fitnessGoalDTO = fitnessGoalService.getFitnessGoalById(fitnessGoalId);
            return new ResponseEntity<>(fitnessGoalDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FitnessGoalDTO>> getFitnessGoalsByUserId(@PathVariable Long userId) {
        try {
            List<FitnessGoalDTO> fitnessGoalList = fitnessGoalService.getFitnessGoalsByUserId(userId);
            if (!fitnessGoalList.isEmpty()) {
                return new ResponseEntity<>(fitnessGoalList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{fitnessGoalId}")
    public ResponseEntity<FitnessGoalDTO> updateFitnessGoalById(@PathVariable Long fitnessGoalId,
                                                                @RequestBody FitnessGoalDTO fitnessGoalDTO) {
        try {
            FitnessGoalDTO updatedFitnessGoal = fitnessGoalService.updateFitnessGoalById(fitnessGoalId, fitnessGoalDTO);
            return new ResponseEntity<>(updatedFitnessGoal, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{fitnessGoalId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteFitnessGoalById(@PathVariable Long fitnessGoalId) {
        try {
            fitnessGoalService.deleteFitnessGoalById(fitnessGoalId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteFitnessGoalsByUserId(@PathVariable Long userId) {
        fitnessGoalService.deleteFitnessGoalsByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}