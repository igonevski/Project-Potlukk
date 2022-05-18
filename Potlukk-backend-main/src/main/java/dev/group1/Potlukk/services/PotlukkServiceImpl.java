package dev.group1.Potlukk.services;

import dev.group1.Potlukk.entities.Item;
import dev.group1.Potlukk.entities.Potlukk;
import dev.group1.Potlukk.exceptions.PotlukkNotFoundException;
import dev.group1.Potlukk.repos.ItemRepo;
import dev.group1.Potlukk.repos.PotlukkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class PotlukkServiceImpl implements PotlukkService{

    @Autowired
    private PotlukkRepo potlukkRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Potlukk addPotlukk(Potlukk potlukk) {
        return potlukkRepo.save(potlukk);
    }

    @Override
    public Potlukk updatePotlukk(Potlukk potlukk) {
        Potlukk p = getPotlukkById(potlukk.getId());
        p.setName(potlukk.getName());
        p.setLocation(potlukk.getLocation());
        p.setEpochTime(potlukk.getEpochTime());
        p.setHostID(potlukk.getHostID());
        potlukkRepo.save(p);
        return p;
    }

    @Override
    public boolean deletePotlukkById(int id) throws PotlukkNotFoundException {
        Optional<Potlukk> possiblePotlukk = potlukkRepo.findById(id);
        if(possiblePotlukk.isPresent()){
            potlukkRepo.delete(possiblePotlukk.get());
            return true;
        }else {
            throw new PotlukkNotFoundException(id);
        }
    }

    @Override
    public Item addPotlukkItem(Item item) throws PotlukkNotFoundException {
        Optional<Potlukk> possiblePotlukk = potlukkRepo.findById(item.getPotlukkID());
        if(possiblePotlukk.isPresent()){
            return itemRepo.save(item);
        }else {
            throw new PotlukkNotFoundException(item.getPotlukkID());
        }
    }

    @Override
    public Potlukk getPotlukkById(int id) throws PotlukkNotFoundException {
        Optional<Potlukk> possiblePotlukk = potlukkRepo.findById(id);
        if(possiblePotlukk.isPresent()){
            return potlukkRepo.getById(id);
        }else {
            throw new PotlukkNotFoundException(id);
        }
    }

    @Override
    public List<Potlukk> getAllPotlukks() {
        return potlukkRepo.findAll();
    }

    @Override
    public List<Item> getPotlukkItems(int id) throws PotlukkNotFoundException {
        Optional<Potlukk> possiblePotlukk = potlukkRepo.findById(id);
        if(possiblePotlukk.isPresent()){
            return itemRepo.findItemsByPotlukkID(id);
        }else {
            throw new PotlukkNotFoundException(id);
        }
    }
}
