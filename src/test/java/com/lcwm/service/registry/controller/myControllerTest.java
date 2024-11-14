package com.lcwm.service.registry.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.lcwm.service.registry.component.MyComponent;
import com.lcwm.service.registry.service.MyService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(myController.class)
public class myControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyService myService;

    @MockBean
    private MyComponent myComponent;

    @Test
    public void testWelcome() throws Exception {
        // Mock the service layer behavior
        when(myService.getServiceMessage()).thenReturn("Service Layer Message!");

        

        // Perform the request and capture the result
        String response = mockMvc.perform(get("/api/greeting"))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        // Print the response
        System.out.println("Response: " + response);
        
        // Test the /greeting endpoint
        mockMvc.perform(get("/api/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Service Layer Message!"));
    }

    @Test
    public void testWelcome2() throws Exception {
        // Mock the component layer behavior
        when(myComponent.myComponent()).thenReturn("Component Layer Message!");

        // Test the /greeting2 endpoint
        mockMvc.perform(get("/api/greeting2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Component Layer Message!"));
    }
}