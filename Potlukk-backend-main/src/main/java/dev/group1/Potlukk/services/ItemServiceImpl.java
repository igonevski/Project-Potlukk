package dev.group1.Potlukk.services;

import dev.group1.Potlukk.entities.Item;
import dev.group1.Potlukk.exceptions.ItemNotFoundException;
import dev.group1.Potlukk.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item addItem(Item item) {
        return this.itemRepo.save(item);
    }

    @Override
    public Item getItemById(int id) {
        Optional<Item> possibleItem = this.itemRepo.findById(id);

        if(possibleItem.isPresent()){
            return possibleItem.get();
        }
        else{
            throw new ItemNotFoundException(id);
        }
    }

    @Override
    public List<Item> getItemsByPotlukk(int id) {
        return this.itemRepo.findItemsByPotlukkID(id);
    }

    @Override
    public Item updateItem(Item item) {
        Item old = this.getItemById(item.getId());
        // The Item passed to update may be incomplete
        // If no info is provided the old info is fetched and used
        if(item.getName() == "")
            item.setName(old.getName());
        if(item.getStatus() == null)
            item.setStatus(old.getStatus());
        if(item.getPotlukkID() == 0){
            item.setPotlukkID(old.getPotlukkID());
        }
        return this.itemRepo.save(item);
    }

    @Override
    public boolean removeItem(int id) {
        Optional<Item> possibleItem = this.itemRepo.findById(id);
        if(possibleItem.isPresent()){
            this.itemRepo.delete(possibleItem.get());
            return true;
        }else {
            throw new ItemNotFoundException(id);
        }
    }
}
