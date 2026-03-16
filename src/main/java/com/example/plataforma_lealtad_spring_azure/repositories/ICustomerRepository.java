package com.example.plataforma_lealtad_spring_azure.repositories;

import com.example.plataforma_lealtad_spring_azure.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
