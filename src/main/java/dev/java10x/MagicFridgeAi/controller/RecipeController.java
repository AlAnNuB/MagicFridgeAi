package dev.java10x.MagicFridgeAi.controller;


import dev.java10x.MagicFridgeAi.model.FoodItem;
import dev.java10x.MagicFridgeAi.service.ChatGptService;
import dev.java10x.MagicFridgeAi.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecipeController {

    private FoodItemService foodItemService;
    private final ChatGptService chatGptService;

    public RecipeController(FoodItemService foodItemService, ChatGptService chatGptService) {
        this.foodItemService = foodItemService;
        this.chatGptService = chatGptService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecipe() {

        List<FoodItem> foodItems = foodItemService.listar();

        return chatGptService.generateRecipe(foodItems)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());

    }

}
