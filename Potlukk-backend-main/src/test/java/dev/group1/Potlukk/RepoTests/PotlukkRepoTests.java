package dev.group1.Potlukk.RepoTests;

import dev.group1.Potlukk.entities.Potlukk;
import dev.group1.Potlukk.repos.PotlukkRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PotlukkRepoTests {

    static int id;

    @Autowired
    private PotlukkRepo potlukkRepo;

    @Test
    @Order(1)
    @DisplayName("Should create new potlukk")
    void shouldCreateNewPotlukk() {
        Potlukk potlukk = new Potlukk(0, "Bob's Party", 0, 0, "The Park");
        potlukkRepo.save(potlukk);
        id = potlukk.getId();
        Assertions.assertNotEquals(0, potlukk.getId());
    }

    @Test
    @Order(2)
    @DisplayName("Should read potlukk by Id")
    void shouldReadPotlukkById() {
        Optional<Potlukk> possiblePotlukk = potlukkRepo.findById(id);
        Assertions.assertTrue(possiblePotlukk.isPresent());
    }

    @Test
    @Order(3)
    @DisplayName("Should update potlukk")
    void shouldUpdatePotlukk() {
        Optional<Potlukk> possiblePotlukk = potlukkRepo.findById(id);
        Potlukk potlukk = possiblePotlukk.orElse(null);
        Assertions.assertNotNull(potlukk);
        potlukk.setLocation("Parking Lot");
        potlukkRepo.save(potlukk);
        Assertions.assertEquals("Parking Lot", possiblePotlukk.get().getLocation());
    }

    @Test
    @Order(4)
    @DisplayName("Should delete potlukk")
    void shouldDeletePotlukk() {
        Optional<Potlukk> possiblePotlukk = potlukkRepo.findById(id);
        Potlukk potlukk = possiblePotlukk.orElse(null);
        Assertions.assertNotNull(potlukk);
        potlukkRepo.delete(potlukk);
        Optional<Potlukk> deletedPotlukk = potlukkRepo.findById(id);
        Assertions.assertTrue(deletedPotlukk.isEmpty());
    }
}
