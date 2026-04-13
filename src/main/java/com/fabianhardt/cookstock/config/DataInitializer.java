package com.fabianhardt.cookstock.config;

import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.entity.ShoppingList;
import com.fabianhardt.cookstock.repository.CategoryRepository;
import com.fabianhardt.cookstock.repository.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final ShoppingListRepository shoppingListRepository;

    @Override
    public void run(String... args) {
        this.initCategories();
        this.createDefaultShoppingListIfNotExists();
    }

    private void initCategories() {
        this.createCategoryIfNotExists("Obst", "🍎");
        this.createCategoryIfNotExists("Gemüse", "🥦");
        this.createCategoryIfNotExists("Getränke", "🥤");
        this.createCategoryIfNotExists("Tiefkühl", "❄️");
        this.createCategoryIfNotExists("Gewürze", "🌶️");
        this.createCategoryIfNotExists("Backwaren", "🥖");
        this.createCategoryIfNotExists("Teigwaren", "🍝");
        this.createCategoryIfNotExists("Drogerie", "🧴");
        this.createCategoryIfNotExists("Fisch", "🐟");
        this.createCategoryIfNotExists("Fleisch", "🥩");
        this.createCategoryIfNotExists("Süßwaren & Snacks", "🍬");
        this.createCategoryIfNotExists("Milchprodukte", "🧀");
        this.createCategoryIfNotExists("Getreideprodukte", "🌾");
        this.createCategoryIfNotExists("Öle & Fette", "🫒");
        this.createCategoryIfNotExists("Haushalt", "🧽");
    }

    private void createCategoryIfNotExists(String categoryName, String icon) {
        if (!this.categoryRepository.existsByName(categoryName)) {
            Category category = new Category();
            category.setName(categoryName);
            category.setIcon(icon); // optional, falls du das Feld hast
            this.categoryRepository.save(category);
        }
    }

    private void createDefaultShoppingListIfNotExists() {
        if (!this.shoppingListRepository.existsByDefaultListTrue()) {
            ShoppingList defaultShoppingList = new ShoppingList();
            defaultShoppingList.setName("Standard Einkaufsliste");
            defaultShoppingList.setDefaultList(true);
            this.shoppingListRepository.save(defaultShoppingList);
        }
    }
}
