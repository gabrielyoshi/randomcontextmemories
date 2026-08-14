package com.gabrielyoshi.randomcontextmemories.health;

/**
 * Response returned by application health endpoint.
 * Note: Java record is a class where a constructor, accessors, equals(), hashcode(), and toString() are auto generated.
 * 
 * @param status current application status
 * @param application application display name
 */
public record HealthResponse(String status, String application) {
  
}
