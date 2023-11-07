package com.example.calculator.model;

import com.example.calculator.model.CalculatorOperation;
import com.example.calculator.model.CalculatorOperationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private final CalculatorOperationRepository operationRepository;

    public CalculatorController(CalculatorOperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @GetMapping("/")
    public String showCalculatorForm(Model model) {
        model.addAttribute("operation", new CalculatorOperation());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("operand1") double operand1,
                            @RequestParam("operand2") double operand2,
                            @RequestParam("operator") String operator,
                            Model model) {
        double result;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                result = 0;
        }

        CalculatorOperation operation = new CalculatorOperation();
        operation.setOperand1(operand1);
        operation.setOperand2(operand2);
        operation.setOperator(operator);
        operation.setResult(result);

        operationRepository.save(operation);

        model.addAttribute("result", result);
        return "result";
    }
}

