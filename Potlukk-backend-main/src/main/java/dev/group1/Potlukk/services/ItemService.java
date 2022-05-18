package dev.group1.Potlukk.services;


import dev.group1.Potlukk.entities.Item;
import java.util.List;

public interface ItemService {
    /**
     * @param item - An item to be added to the database
     * @return Item updated to reflect the item id
     */
    Item addItem(Item item);

    /**
     * @param id The id of an item to look up
     * @return Item with id
     */
    Item getItemById(int id);

    /**
     * @param id The id of a potlukk
     * @return A list of items associated with a potlukk, List may be empty
     */
    List<Item> getItemsByPotlukk(int id);

    /**
     * @param item An item to update
     * @return The updated item
     */
    Item updateItem(Item item);

    /**
     * @param id id of an item to remove
     * @return if the element was deleted
     */
    boolean removeItem(int id);
}
