package org.example.masterarbeit_github_action_test.controller;

import org.example.masterarbeit_github_action_test.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)  // 🔹 Lädt nur den Controller
@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean  // 🔥 Stellt sicher, dass Spring den Mock injiziert
    private CalculatorService calculatorService;

    @Test
    void testCalculatorPage() throws Exception {
        mockMvc.perform(get("/Calculator"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"));
    }


    @Test
    void testCalculateEndpoint() throws Exception {
        when(calculatorService.add(2, 3)).thenReturn(5);  // 🔹 Mock für Addition

        mockMvc.perform(get("/calculate").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", 5))
                .andExpect(view().name("calculator"));

        verify(calculatorService, times(1)).add(2, 3);
    }
}
