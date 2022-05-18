package dev.group1.Potlukk.RepoTests;

import dev.group1.Potlukk.entities.Item;
import dev.group1.Potlukk.repos.ItemRepo;
import dev.group1.Potlukk.utilities.Status;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemRepoTests {

    static int id;

    @Autowired
    private ItemRepo itemRepo;

    @Test
    @Order(1)
    @DisplayName("Should create new item")
    void shouldCreateNewItem() {
        Item item = new Item(0, "Cookies", "Bob", Status.NEEDED, 0);
        itemRepo.save(item);
        id = item.getId();
        Assertions.assertNotEquals(0, item.getId());
    }

    @Test
    @Order(2)
    @DisplayName("Should read item by Id")
    void shouldReadItemById() {
        Optional<Item> possibleItem = itemRepo.findById(id);
        Assertions.assertTrue(possibleItem.isPresent());
    }

    @Test
    @Order(3)
    @DisplayName("Should read all items by Potlukk Id")
    void shouldReadAllItemsByPotlukkId() {
        Optional<Item> possibleItem = itemRepo.findById(id);
        Item item = possibleItem.orElse(null);
        Assertions.assertNotNull(item);
    }

    @Test
    @Order(4)
    @DisplayName("Should update item")
    void shouldUpdateItem() {
        Optional<Item> possibleItem = itemRepo.findById(id);
        Item item = possibleItem.orElse(null);
        Assertions.assertNotNull(item);
        item.setStatus(Status.FULFILLED);
        itemRepo.save(item);
        Assertions.assertEquals(Status.FULFILLED, possibleItem.get().getStatus());
    }
    
    @Test
    @Order(5)
    @DisplayName("Should delete item")
    void shouldDeleteItem() {
        Optional<Item> possibleItem = itemRepo.findById(id);
        Item item = possibleItem.orElse(null);
        Assertions.assertNotNull(item);
        itemRepo.delete(item);
        Optional<Item> deletedItem = itemRepo.findById(id);
        Assertions.assertTrue(deletedItem.isEmpty());
    }

}
