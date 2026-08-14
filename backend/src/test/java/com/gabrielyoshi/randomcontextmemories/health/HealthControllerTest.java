package com.gabrielyoshi.randomcontextmemories.health;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(HealthController.class) //loads only components needed for testing HealthController
class HealthControllerTest {
  
  @Autowired
  private MockMvc mockMvc; //tests Spring MVC request without starting a server

  @Test
  void testHealthEndpoint() throws Exception {
    mockMvc.perform(get("/api/health"))
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.status").value("UP"))
      .andExpect(jsonPath("$.application").value("Random Context Memories"));
  }
}
