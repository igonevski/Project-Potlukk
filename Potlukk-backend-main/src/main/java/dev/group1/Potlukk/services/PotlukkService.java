package dev.group1.Potlukk.services;

import dev.group1.Potlukk.entities.Item;
import dev.group1.Potlukk.entities.Potlukk;

import java.util.List;

public interface PotlukkService {

    Potlukk addPotlukk(Potlukk potlukk);

    Potlukk updatePotlukk(Potlukk potlukk);

    boolean deletePotlukkById(int id);

    Item addPotlukkItem(Item item);

    Potlukk getPotlukkById(int id);

    List<Potlukk> getAllPotlukks();

    List<Item> getPotlukkItems(int id);

}
