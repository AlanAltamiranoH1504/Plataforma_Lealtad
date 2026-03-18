package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateAdminAccountDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateCustomerAccountDTO;
import com.example.plataforma_lealtad_spring_azure.exceptions.NotFoundEntityException;
import com.example.plataforma_lealtad_spring_azure.exceptions.rol.IncorrectRolException;
import com.example.plataforma_lealtad_spring_azure.exceptions.user.EmailInUseException;
import com.example.plataforma_lealtad_spring_azure.models.*;
import com.example.plataforma_lealtad_spring_azure.repositories.*;
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
    private IAdminRepository iAdminRepository;
    @Autowired
    private IProgramRepository iProgramRepository;
    @Autowired
    private IRolRespitory iRolRespitory;

    @Override
    public void createAccountCustomer(CreateCustomerAccountDTO createCustomerAccountDTO) {
        // * Create tbl_user
        this.isEmailInUse(createCustomerAccountDTO.getEmail());
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

    @Override
    public void createAccountAdmin(CreateAdminAccountDTO createAdminAccountDTO) {
        // * Create tbl_uses
        this.isEmailInUse(createAdminAccountDTO.getEmail());
        this.isCorrectRol(createAdminAccountDTO.getRol());
        this.isProgramValid(createAdminAccountDTO.getProgram());
        User userToSave = new User(
                createAdminAccountDTO.getEmail(),
                createAdminAccountDTO.getUsername(),
                createAdminAccountDTO.getPassword(),
                1,
                iProgramRepository.getReferenceById(createAdminAccountDTO.getProgram()),
                List.of(iRolRespitory.findById(createAdminAccountDTO.getRol()).get())
        );
        iUserRepository.save(userToSave);

        // * Create tbl_admin
        Random rand = new Random();
        int numero = rand.nextInt(90000) + 10000;
        Administrator adminToSave = new Administrator(
                createAdminAccountDTO.getName_admin(),
                createAdminAccountDTO.getLastname_admin(),
                UUID.randomUUID().toString(),
                String.valueOf(numero),
                1,
                userToSave
        );
        iAdminRepository.save(adminToSave);
    }

    @Override
    public boolean isEmailInUse(String email) {
        User emailInUse = iUserRepository.getUserByEmail(email);
        if (emailInUse != null) {
            throw new EmailInUseException("Email " + email + " ya se encuentra en uso por otro usuario");
        }
        return true;
    }

    @Override
    public boolean isCorrectRol(Long idRol) {
        Optional<Rol> rolToAdd = iRolRespitory.findById(idRol);
        if (rolToAdd.isEmpty()) {
            throw new NotFoundEntityException("El rol con el id "  + idRol + " no existe");
        }
        if (!rolToAdd.get().getName_rol().equals("ADMIN")) {
            throw new IncorrectRolException("El rol por asignar no es valido");
        }
        return true;
    }

    @Override
    public boolean isProgramValid(Long idProgram) {
        Optional<Program> programExists = iProgramRepository.findById(idProgram);
        if (programExists.isEmpty()) {
            throw new NotFoundEntityException("El programa con el id " + idProgram + " no existe");
        }
        return true;
    }
}
