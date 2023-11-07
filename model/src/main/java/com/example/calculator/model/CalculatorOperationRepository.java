package com.example.calculator.model;

import com.example.calculator.model.CalculatorOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorOperationRepository extends JpaRepository<CalculatorOperation, Long> {
}

