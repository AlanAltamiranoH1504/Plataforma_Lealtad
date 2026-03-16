package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateCustomerAccountDTO;
import com.example.plataforma_lealtad_spring_azure.models.Customer;
import com.example.plataforma_lealtad_spring_azure.models.Rol;
import com.example.plataforma_lealtad_spring_azure.models.User;
import com.example.plataforma_lealtad_spring_azure.repositories.ICustomerRepository;
import com.example.plataforma_lealtad_spring_azure.repositories.IProgramRepository;
import com.example.plataforma_lealtad_spring_azure.repositories.IRolRespitory;
import com.example.plataforma_lealtad_spring_azure.repositories.IUserRepository;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private IProgramRepository iProgramRepository;
    @Autowired
    private IRolRespitory iRolRespitory;

    @Override
    public void createAccountCustomer(CreateCustomerAccountDTO createCustomerAccountDTO) {
        // * Create tbl_user
        List<Rol> rolsToAssign = new ArrayList<>();
        for (var rol: createCustomerAccountDTO.getRols()) {
            Optional<Rol> rolToAdd = iRolRespitory.findById(rol);
            if (rolToAdd.isPresent()) {
                rolsToAssign.add(rolToAdd.get());
            }
        }
        User userToSave = new User(
                createCustomerAccountDTO.getEmail(),
                createCustomerAccountDTO.getUsername(),
                createCustomerAccountDTO.getPassword(),
                1,
                iProgramRepository.getReferenceById(createCustomerAccountDTO.getProgram()),
                rolsToAssign
        );
        iUserRepository.save(userToSave);

        // * Create tbl_cutomers
        Random rand = new Random();
        int numero = rand.nextInt(90000) + 10000;
        Customer customerToSave = new Customer(
                createCustomerAccountDTO.getName_customer(),
                createCustomerAccountDTO.getLastname_customer(),
                0,
                0,
                null,
                null,
                UUID.randomUUID().toString(),
                null,
                String.valueOf(numero),
                1,
                userToSave
        );
        iCustomerRepository.save(customerToSave);
    }
}
