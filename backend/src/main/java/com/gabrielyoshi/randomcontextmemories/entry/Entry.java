package com.gabrielyoshi.randomcontextmemories.entry;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity // makes this class a JPA entity: mapped to a database table
@Table(name = "entries") // connects to the "entries" table in the database
public class Entry {
  @Id // marks this field as the primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generates the primary key value
  private Long id;

  @Column(length = 200)
  private String title;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String content;

  @Column(name = "source_url", length = 2048)
  private String sourceUrl;

  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  protected Entry() { // allows Hibernate to instantiate without constructor
    // Default constructor for JPA
  }

  // Constructor for creating a new Entry with title, content, and sourceUrl
  public Entry(String title, String content, String sourceUrl) {
    this.title = title;
    this.content = Objects.requireNonNull(content, "Content cannot be null");
    this.sourceUrl = sourceUrl;
  }

  @PrePersist // runs before first database insert
  void initializeTimestamps() {
    Instant now = Instant.now();
    this.createdAt = now;
    this.updatedAt = now;
  }

  @PreUpdate // runs before each database update
  void updateTimestamp() {
    updatedAt = Instant.now();
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getSourceUrl() {
    return sourceUrl;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  // Method to update the title, content, and sourceUrl of the Entry
  public void update(String title, String content, String sourceUrl) {
    this.title = title;
    this.content = Objects.requireNonNull(content, "Content cannot be null");
    this.sourceUrl = sourceUrl;
  }
}