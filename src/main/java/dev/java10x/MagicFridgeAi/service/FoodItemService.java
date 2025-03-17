package dev.java10x.MagicFridgeAi.service;

import dev.java10x.MagicFridgeAi.model.FoodItem;
import dev.java10x.MagicFridgeAi.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public FoodItem salvar(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    public List<FoodItem> listar() { return repository.findAll(); }

    public Optional<FoodItem> listarPorId(Long id) { return repository.findById(id); }


    public FoodItem atualizar(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    public void excluir(Long id) { repository.deleteById(id); }
}
