package com.cardapio.controller;

import com.cardapio.food.Food;
import com.cardapio.food.FoodRepository;
import com.cardapio.food.FoodResponseDTO;
import com.cardapio.food.FoodRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @PostMapping
    public ResponseEntity<Void> saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(FoodResponseDTO::new)
                .toList();
    }
}
