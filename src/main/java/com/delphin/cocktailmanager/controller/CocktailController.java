package com.delphin.cocktailmanager.controller;


import com.delphin.cocktailmanager.dto.Cocktail;
import com.delphin.cocktailmanager.repository.CocktailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController()
@RequestMapping("/cocktails")
public class CocktailController {

    private CocktailRepository cocktailRepository ;

    public CocktailController(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCocktail(@RequestBody Cocktail cocktail){
        cocktailRepository.save(cocktail).subscribe();
    }



    @GetMapping
    public Flux<Cocktail> getAllCocktails(){
        return cocktailRepository.findAll();
    }


    @GetMapping("/{name}")
    public Flux<Cocktail> getCocktailsByName(@PathVariable String name){
        return cocktailRepository.findByName(name);
    }

    @DeleteMapping
    public String deleteAllCocktails() {
        cocktailRepository.deleteAll().subscribe();
        return "OK";
    }



}
