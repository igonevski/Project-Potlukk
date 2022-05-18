package dev.group1.Potlukk.ServiceTests;

import dev.group1.Potlukk.entities.Item;
import dev.group1.Potlukk.entities.Potlukk;
import dev.group1.Potlukk.exceptions.PotlukkNotFoundException;
import dev.group1.Potlukk.repos.ItemRepo;
import dev.group1.Potlukk.services.PotlukkService;
import dev.group1.Potlukk.utilities.Status;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PotlukkServiceTests {

    static int id;

    @Autowired
    private PotlukkService potlukkService;
    @Autowired
    private ItemRepo itemRepo;

    @Test
    @Order(1)
    @DisplayName("Should create new potlukk")
    void shouldCreateNewPotlukk() {
        Potlukk potlukk = new Potlukk(0, "Bob's Party", 0, 0, "The Park");
        potlukkService.addPotlukk(potlukk);
        id = potlukk.getId();
        Assertions.assertNotEquals(0, potlukk.getId());
    }

    @Test
    @Disabled
    @Order(2)
    @DisplayName("Should update potlukk")
    void shouldUpdatePotlukk() {
        Potlukk updatedPotlukk = potlukkService.getPotlukkById(id);
        updatedPotlukk.setLocation("Walmart Parking Lot");
        updatedPotlukk = potlukkService.updatePotlukk(updatedPotlukk);
        Assertions.assertEquals("Walmart Parking Lot", updatedPotlukk.getLocation());
    }

    @Test
    @Order(3)
    @DisplayName("Should get a potlukk by id")
    void shouldGetAPotlukkById() {
        Assertions.assertNotNull(potlukkService.getPotlukkById(id));
    }

    @Test
    @Order(4)
    @DisplayName("Should add item to potlukk")
    void shouldAddItemToPotlukk() {
        Item item = new Item(0, "Moldy Bread", "Bob", Status.FULFILLED, 0);
        Assertions.assertNotEquals(0, potlukkService.addPotlukkItem(item).getId());
        itemRepo.delete(item);
    }

    @Test
    @Order(5)
    @DisplayName("Should get all potlukks")
    void shouldGetAllPotlukks() {
        Assertions.assertNotNull(potlukkService.getAllPotlukks());
    }

    @Test
    @Order(6)
    @DisplayName("Should get all items from a potlukk")
    void shouldGetAllItemsFromAPotlukk() {
        Assertions.assertNotNull(potlukkService.getPotlukkItems(id));
    }

    @Test
    @DisplayName("Delete: Should throw potlukk not found exception")
    void deleteShouldThrowPotlukkNotFoundException() {
        Assertions.assertThrows(PotlukkNotFoundException.class, ()->potlukkService.deletePotlukkById(-5));
    }


    @Test
    @Order(7)
    @DisplayName("Should delete potlukk")
    void shouldDeletePotlukk() {
        Assertions.assertTrue(potlukkService.deletePotlukkById(id));
    }
}
