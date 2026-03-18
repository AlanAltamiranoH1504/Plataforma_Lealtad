package com.example.plataforma_lealtad_spring_azure.controllers;

import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateAdminAccountDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateCustomerAccountDTO;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IAuthService;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IResponseService iResponseService;
    @Autowired
    private IAuthService iAuthService;

    @PostMapping("/create_account_customer")
    public ResponseEntity<?> createAccountCustomer(@Valid @RequestBody CreateCustomerAccountDTO createCustomerAccountDTO) {
        iAuthService.createAccountCustomer(createCustomerAccountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                iResponseService.generateResponse(true, "Confirma tu cuenta en tu correo")
        );
    }

    @PostMapping("/create_account_admin")
    public ResponseEntity<?> createAccountAdmin(@Valid @RequestBody CreateAdminAccountDTO createAdminAccountDTO) {
        iAuthService.createAccountAdmin(createAdminAccountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                iResponseService.generateResponse(true, "Confirma tu cuenta en tu correo")
        );
    }
}
