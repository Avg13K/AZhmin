package ru.Artem.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.Artem.telegrambot.model.Category;
import ru.Artem.telegrambot.model.Product;
import ru.Artem.telegrambot.repository.CategoryRepository;
import ru.Artem.telegrambot.service.CategoryService;
import ru.Artem.telegrambot.service.ProductService;

import java.util.List;

@SpringBootTest
public class CategoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    void createCategory(){
        //Создаем категории продуктов
        Category pizzas = categoryService.createCategory("Пицца", 0L);
        Long pizzaId = pizzas.getId();

        Category rolls = categoryService.createCategory("Роллы", 0L);
        Long rollsId = rolls.getId();

        Category burgers = categoryService.createCategory("Бургеры", 0L);
        Long burgersId = burgers.getId();

        Category drinks = categoryService.createCategory("Напитки", 0L);
        Long drinksId = drinks.getId();

        //Создаем подкатегории
        Category classicRolls = categoryService.createCategory("Классические роллы", rollsId);
        Category bakedRolls = categoryService.createCategory("Запеченные роллы", rollsId);
        Category sweetRolls = categoryService.createCategory("Сладкие роллы", rollsId);
        Category rollSets = categoryService.createCategory("Сеты Ролл", rollsId);

        Category classicBurgers = categoryService.createCategory("Классические бургеры", burgersId);
        Category spicyBurgers = categoryService.createCategory("Острые бургеры", burgersId);

        Category carbonatedDrinks = categoryService.createCategory("Газированные напитки", drinksId);
        Category energyDrinks = categoryService.createCategory("Энергетические напитки", drinksId);
        Category juicesDrinks = categoryService.createCategory("Соки", drinksId);
        Category otherDrinks = categoryService.createCategory("Другие напитки", drinksId);
    }

    @Test
    void createProducts(){
        createCategory();

        //создаем товары для подкатегорий ролл
        Category classicRolls = categoryService.findByName("Классические роллы");
        Product classicRoll1 = productService.createProduct("Калифорния", "Ролл с мясом краба", 360.0, classicRolls);
        Product classicRoll2 = productService.createProduct("Филадельфия", "Ролл с красной рыбой", 400.0, classicRolls);
        Product classicRoll3 = productService.createProduct("Креветка Тартар", "Ролл с креветкой и соусом тар", 375.0, classicRolls);

        Category bakedRolls = categoryService.findByName("Запеченные роллы");
        Product bakedRoll1 = productService.createProduct("Запеченный бекон", "Запеченный ролл с беконом", 340.0, bakedRolls);
        Product bakedRoll2 = productService.createProduct("Горячий краб" ,"Запеченный ролл с крабом", 350.0, bakedRolls);
        Product bakedRoll3 = productService.createProduct("Лосось в шапке", "Запеченный ролл с Лососем и мясом краба", 380.0, bakedRolls);

        Category sweetRolls = categoryService.findByName("Сладкие роллы");
        Product sweetRoll1 = productService.createProduct("Банан сладкий ролл", "Сладкий ролл с бананом", 280.0 , sweetRolls);
        Product sweetRoll2 = productService.createProduct("Каприз сладкий ролл", "Сладкий ролл со сливочным сыром и шоколадом", 300.0 , sweetRolls);
        Product sweetRoll3 = productService.createProduct("Восторг сладкий ролл", "Сладкий росс с различными фруктами", 270.0 , sweetRolls);

        //создаем товары для подкатегорий бургеров
        Category classicBurgers = categoryService.findByName("Классические бургеры");
        Product classicBurger1 = productService.createProduct("Чизбургер","Классический чизбургер", 200.0, classicBurgers);
        Product classicBurger2 = productService.createProduct( "Бургер Бронсон", "Бургер с двойной свинной котлетой",300.0, classicBurgers);
        Product classicBurger3 = productService.createProduct( "Дабл Чикен", "Бургер с двойной куриной котлетой",280.0, classicBurgers);

        Category spicyBurgers = categoryService.findByName("Острые бургеры");
        Product spicyBurger1 = productService.createProduct("Бургер Капрезо", "", 300.0, spicyBurgers);
        Product spicyBurger2 = productService.createProduct("Чилли бургер", "Бургер с перцом чилли", 280.0, spicyBurgers);
        Product spicyBurger3 = productService.createProduct("Бургер черная пантера", "Бургер с холлапенье", 320.0, spicyBurgers);

        //создаем товары для подкатегорий напитков
        Category carbonatedDrinks = categoryService.findByName("Газированные напитки");
        Product carbonatedDrink1 = productService.createProduct("Кока-колла", "Охлажденный", 120.0, carbonatedDrinks);
        Product carbonatedDrink2 = productService.createProduct("Спрайт", "Охлажденный", 100.0, carbonatedDrinks);
        Product carbonatedDrink3 = productService.createProduct("Фанта", "Охлажденный", 95.0 ,carbonatedDrinks);

        Category energyDrinks = categoryService.findByName("Энергетические напитки");
        Product energyDrink1 = productService.createProduct("Торнадо", "Охлажденный", 120.0, energyDrinks);
        Product energyDrink2 = productService.createProduct("Флеш", "Охлажденный", 1300.0, energyDrinks);
        Product energyDrink3 = productService.createProduct("E-on", "Охлажденный", 150.0 , energyDrinks);

        Category juices = categoryService.findByName("Соки");
        Product juice1 = productService.createProduct("Ананасовый сок", "Охлажденный", 70.0 ,juices);
        Product juice2 = productService.createProduct("Вишневый сок", "Охлажденный", 70.0 ,juices);
        Product juice3 = productService.createProduct("Апельсиновый сок", "Охлажденный", 70.0 ,juices);

        Category otherDrinks = categoryService.findByName("Другие");
        Product otherDrink1 = productService.createProduct("Морс", "Охлажденный", 85.0 ,otherDrinks);
        Product otherDrink2 = productService.createProduct("Мохито", "Охлажденный", 100.0 ,otherDrinks);
        Product otherDrink3 = productService.createProduct("ыва", "Охлажденный", 120.0 ,otherDrinks);

        //создаем товары для категории пицца
        Category pizzas = categoryService.findByName("Пицца");
        Product pizza1 = productService.createProduct("Маргарита", "", 420.0 ,pizzas);
        Product pizza2 = productService.createProduct("С ананасами", "", 400.0 ,pizzas);
        Product pizza3 = productService.createProduct("Пицца карбонара", "", 435.0 ,pizzas);

        productService.saveAll(List.of(pizza1, pizza2, pizza3, classicRoll1, classicRoll2, classicRoll3, classicBurger3, bakedRoll1, bakedRoll2, bakedRoll3,
                sweetRoll1,sweetRoll2,sweetRoll3, classicBurger1, classicBurger2, classicBurger3, spicyBurger1, spicyBurger2, spicyBurger3,
                carbonatedDrink1, carbonatedDrink2, carbonatedDrink3, energyDrink1, energyDrink2, energyDrink3, juice1, juice2, juice3,
                otherDrink1, otherDrink2, otherDrink3));
    }
}
