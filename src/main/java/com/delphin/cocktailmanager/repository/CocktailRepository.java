package com.delphin.cocktailmanager.repository;

import com.delphin.cocktailmanager.dto.Cocktail;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CocktailRepository extends ReactiveCrudRepository<Cocktail, String> {

    Flux<Cocktail> findByName(String name);

}
