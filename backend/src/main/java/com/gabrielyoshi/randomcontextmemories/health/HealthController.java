package com.gabrielyoshi.randomcontextmemories.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Provides endpoint for checking operation of backend
 */
@RestController //registers class as a REST controller
@RequestMapping("/api/health") //establishes controller's base URL
public class HealthController {
  
  @GetMapping //Maps HTTP GET request to getHealth()
  public HealthResponse getHealth() {
    return new HealthResponse(
      "UP", "Random Context Memories");
  }
}
