package com.gabrielyoshi.randomcontextmemories.entry;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@DataJpaTest // loads only JPA-related app components
@AutoConfigureTestDatabase(
    // Spring to use PostgreSQL datasource vs looking for embedded test db
    replace = AutoConfigureTestDatabase.Replace.NONE)
class EntryRepositoryTest {

  @Autowired
  private EntryRepository entryRepository;

  @Autowired
  private EntityManager entityManager;

  @Test
  void savesAndFindsEntryById() {
    Entry entry = new Entry(
        "First memory",
        "Today I added persistent entries.",
        "https://example.com");
    // sends INSERT to PostgreSQL immediately
    Entry savedEntry = entryRepository.saveAndFlush(entry);
    Long savedId = savedEntry.getId();

    // Removes saved object from Hibernate's memory
    entityManager.clear();

    // Retrieve row from PostgreSQL instead of returning cached Java object
    Entry foundEntry = entryRepository.findById(savedId).orElseThrow();

    // verifies generated ID, stored value, timestamps
    assertThat(savedId).isNotNull();
    assertThat(foundEntry.getTitle()).isEqualTo("First memory");
    assertThat(foundEntry.getContent())
        .isEqualTo("Today I added persistent entries.");
    assertThat(foundEntry.getSourceUrl())
        .isEqualTo("https://example.com");
    assertThat(foundEntry.getCreatedAt()).isNotNull();
    assertThat(foundEntry.getUpdatedAt()).isNotNull();
  }
}