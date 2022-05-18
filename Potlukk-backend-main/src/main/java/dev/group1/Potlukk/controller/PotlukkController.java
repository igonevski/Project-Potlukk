package dev.group1.Potlukk.controller;

import dev.group1.Potlukk.entities.Potlukk;
import dev.group1.Potlukk.services.PotlukkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin("*")
public class PotlukkController {

    @Autowired
    private PotlukkService potlukkService;

    // Add a new potlukk
    @PostMapping("/potlukks")
    @ResponseBody
    public Potlukk postPotlukk(@RequestBody Potlukk potlukk){
        return potlukkService.addPotlukk(potlukk);
    }

    // Look at all potlukks
    @GetMapping("/potlukks")
    public List<Potlukk> getPotlukks(){
        return potlukkService.getAllPotlukks();
    }

    // Look at a specific potlukks info
    @GetMapping("potlukks/{id}")
    public Potlukk getPotlukkByID(@PathVariable int id){
        return potlukkService.getPotlukkById(id);
    }

    // Update Potlukk
    @PutMapping("/potlukks/{id}")
    @ResponseBody
    public Potlukk putPotlukk(@PathVariable int id, @RequestBody Potlukk potlukk){
        potlukk.setId(id);
        return potlukkService.updatePotlukk(potlukk);
    }

    // Delete a potlukk
    @DeleteMapping("potlukks/{id}")
    @ResponseBody
    public boolean deletePotlukk(@PathVariable int id){
        return potlukkService.deletePotlukkById(id);
    }
}
