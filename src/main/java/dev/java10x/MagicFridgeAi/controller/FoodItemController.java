package dev.java10x.MagicFridgeAi.controller;

import dev.java10x.MagicFridgeAi.model.FoodItem;
import dev.java10x.MagicFridgeAi.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    //POST
    @PostMapping
    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem) {
        FoodItem salvo = service.salvar(foodItem);

        return ResponseEntity.ok(salvo);

    }
    //GET
    @GetMapping
    public ResponseEntity<List<FoodItem>> listar() {
        List<FoodItem> lista = service.listar();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FoodItem>> listarPorId(Long id) {
        Optional<FoodItem> item = service.listarPorId(id);

        return ResponseEntity.ok(item);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> atualizar(@RequestBody FoodItem foodItem, @PathVariable Long id) {
        return service.listarPorId(id)
                .map(itemExistente -> {
                    foodItem.setId(itemExistente.getId());
                    FoodItem atualizado = service.atualizar(foodItem);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.excluir(id);
      return ResponseEntity.noContent().build();
    }
}


