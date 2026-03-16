package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.services.interfaces.IResponseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseService implements IResponseService {
    @Override
    public Map<String, Object> generateResponse(boolean status, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("message", message);

        return response;
    }
}
