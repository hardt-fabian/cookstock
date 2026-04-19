package com.fabianhardt.cookstock.config;

import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.entity.ShoppingList;
import com.fabianhardt.cookstock.repository.CategoryRepository;
import com.fabianhardt.cookstock.repository.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Class to initialize the default data.
 *
 * @author Fabian Hardt
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    /**
     * Interface to the category repository
     */
    private final CategoryRepository categoryRepository;

    /**
     * Interface to the shopping list repository
     */
    private final ShoppingListRepository shoppingListRepository;

    @Override
    public void run(String... args) {
        this.initializeCategories();
        this.createDefaultShoppingListIfNotExists();
    }

    /**
     * Initializes the default categories
     */
    private void initializeCategories() {
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

    /**
     * Creates and saves the category if it does not exist
     *
     * @param name name of the category
     * @param icon icon og the category
     */
    private void createCategoryIfNotExists(String name, String icon) {
        if (!this.categoryRepository.existsByName(name)) {
            Category category = new Category();
            category.setName(name);
            category.setIcon(icon);
            this.categoryRepository.save(category);
        }
    }

    /**
     * Creates and saves the default shopping list if it does not exist
     */
    private void createDefaultShoppingListIfNotExists() {
        if (!this.shoppingListRepository.existsByDefaultListTrue()) {
            ShoppingList defaultShoppingList = new ShoppingList();
            defaultShoppingList.setName("Standard Einkaufsliste");
            defaultShoppingList.setDefaultList(true);
            this.shoppingListRepository.save(defaultShoppingList);
        }
    }
}
