package com.ibrahim.myrecipes.domain.initial

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.model.Recipe

val englishRecipes = listOf(
    Recipe(
        recipeId = 1L,
        recipeTitle = "Margherita Pizza",
        recipeDescription = "A classic Italian pizza with a simple yet delicious combination of fresh mozzarella, tomatoes, fresh basil, salt, and olive oil on a crispy crust.",
        recipeInstructions = listOf(
            "Preheat your oven to its highest temperature with the pizza stone inside.",
            "Roll out your pizza dough on a floured surface to a 12-inch circle.",
            "Spread a thin layer of tomato sauce over the dough, leaving a small border around the edges.",
            "Tear the mozzarella into small pieces and distribute it evenly over the sauce.",
            "Place the pizza on the preheated stone and bake until the crust is golden and cheese is bubbling, about 10-12 minutes.",
            "Once out of the oven, garnish with fresh basil leaves and drizzle with extra virgin olive oil.",
            "Slice and serve hot."
        ),
        recipeTime = 22,
        recipeServings = 4,
        foodCategory = FoodCategory.PIZZA,
        recipePhotoUri = "file:///android_asset/images/en/margherita_pizza.jpeg"
    ),
    Recipe(
        recipeId = 2L,
        recipeTitle = "Strawberry Banana Smoothie",
        recipeDescription = "A creamy and refreshing smoothie made with fresh strawberries, ripe banana, and yogurt, perfect for a nutritious start to your day or a mid-afternoon snack.",
        recipeInstructions = listOf(
            "Add the sliced banana, strawberries, yogurt, and milk into a blender.",
            "Blend on high speed until smooth and creamy.",
            "Taste and adjust the sweetness by adding honey, if desired.",
            "Pour into a glass and serve immediately, optionally garnished with a strawberry or banana slice."
        ),
        recipeTime = 5,
        recipeServings = 2,
        foodCategory = FoodCategory.BEVERAGE,
        recipePhotoUri = "file:///android_asset/images/en/strawberry_banana_smoothie.jpeg"
    ),
    Recipe(
        recipeId = 3L,
        recipeTitle = "Eclair",
        recipeDescription = "Elegant French pastry made with light choux dough, filled with a creamy custard, and topped with a smooth chocolate glaze.",
        recipeInstructions = listOf(
            "Preheat the oven and prepare the choux pastry dough. Pipe the dough into long, thin shapes on a baking sheet.",
            "Bake until golden and puffed, then let cool.",
            "Prepare the custard filling by heating milk, sugar, and vanilla, then thickening with eggs and flour.",
            "Once the pastry is cool, fill it with the custard using a piping bag inserted into the ends.",
            "Prepare the chocolate glaze by melting chocolate with a bit of cream and butter, then spread over the top of each filled éclair.",
            "Refrigerate the éclairs until the chocolate sets and the custard is chilled."
        ),
        recipeTime = 90, // Including preparation, baking, and assembly
        recipeServings = 6,
        foodCategory = FoodCategory.DESSERT,
        recipePhotoUri = "file:///android_asset/images/en/eclair.jpeg"
    ),
    Recipe(
        recipeId = 4L,
        recipeTitle = "Cheeseburger",
        recipeDescription = "Classic American cheeseburger with a juicy beef patty, melted cheese, and a variety of toppings, served on a toasted bun.",
        recipeInstructions = listOf(
            "Form the ground beef into patties, slightly larger than your buns since they will shrink during cooking.",
            "Season both sides of the patties with salt and pepper.",
            "Preheat a grill or skillet over medium-high heat. Cook the patties for 3-4 minutes on one side.",
            "Flip the patties, place a slice of cheese on each, and cook for another 3-4 minutes for medium doneness.",
            "Toast the buns on the grill or skillet until lightly golden.",
            "Assemble the burgers by placing a patty on the bottom bun, followed by your choice of toppings and sauces.",
            "Cover with the top bun and serve immediately."
        ),
        recipeTime = 20,
        recipeServings = 4,
        foodCategory = FoodCategory.BURGER,
        recipePhotoUri = "file:///android_asset/images/en/cheeseburger.jpeg"
    ),
    Recipe(
        recipeId = 5L,
        recipeTitle = "Fettuccine Alfredo",
        recipeDescription = "A classic creamy pasta dish made with fettuccine noodles enveloped in a rich sauce of butter and Parmesan cheese, garnished with parsley for a touch of freshness.",
        recipeInstructions = listOf(
            "Cook the fettuccine according to package instructions in salted boiling water until al dente. Reserve some pasta water.",
            "In a large pan, melt the butter over medium heat. Add the cooked fettuccine and toss to coat.",
            "Gradually add grated Parmesan cheese to the pasta, tossing constantly and adding a little pasta water to create a smooth, creamy sauce that coats the noodles.",
            "Season with salt and freshly ground black pepper to taste.",
            "Serve immediately, garnished with additional Parmesan and chopped fresh parsley."
        ),
        recipeTime = 20,
        recipeServings = 4,
        foodCategory = FoodCategory.PASTA,
        recipePhotoUri = "file:///android_asset/images/en/fettuccine_alfredo.jpeg"
    ),
    Recipe(
        recipeId = 6L,
        recipeTitle = "California Roll",
        recipeDescription = "An iconic sushi roll that combines the creamy texture of avocado, the sweetness of crab meat, and the crisp freshness of cucumber, rolled with sushi rice and nori, then sprinkled with sesame seeds.",
        recipeInstructions = listOf(
            "Prepare the sushi rice according to package instructions and season with sushi vinegar. Allow it to cool to room temperature.",
            "Place a sheet of nori on a bamboo sushi mat. Cover the nori with an even layer of sushi rice, then sprinkle sesame seeds over the rice.",
            "Flip the nori sheet over so the rice is facing down on the mat.",
            "On the nori, place strips of cucumber, avocado, and crab meat along one edge.",
            "Using the bamboo mat, tightly roll the sushi, starting from the edge with the fillings.",
            "With a sharp knife, cut the roll into 6-8 pieces, cleaning the knife between cuts to ensure clean slices.",
            "Serve with soy sauce, wasabi, and pickled ginger."
        ),
        recipeTime = 30,
        recipeServings = 2,
        foodCategory = FoodCategory.SUSHI,
        recipePhotoUri = "file:///android_asset/images/en/california_roll.jpeg"
    ),
    Recipe(
        recipeId = 7L,
        recipeTitle = "Ratatouille",
        recipeDescription = "A classic Provençal vegetable stew, ratatouille combines eggplant, zucchini, bell peppers, and tomatoes with aromatic herbs for a hearty and healthy dish.",
        recipeInstructions = listOf(
            "Heat olive oil in a large pot over medium heat. Add chopped onions and garlic, sautéing until soft.",
            "Add diced eggplant and zucchini, cook for a few minutes until they start to soften.",
            "Incorporate the bell peppers and tomatoes, season with salt, pepper, thyme, and basil. If using, add a splash of balsamic vinegar for depth of flavor.",
            "Cover and simmer on low heat for about 20 minutes, or until the vegetables are tender but not mushy.",
            "Adjust seasoning to taste and finish with a sprinkle of fresh basil before serving."
        ),
        recipeTime = 45,
        recipeServings = 4,
        foodCategory = FoodCategory.VEGETABLE,
        recipePhotoUri = "file:///android_asset/images/en/ratatouille.jpeg"
    ),
    Recipe(
        recipeId = 8L,
        recipeTitle = "Grilled Cheese Sandwich",
        recipeDescription = "A timeless comfort food classic, featuring crispy, buttery bread grilled to perfection with a melty cheese filling.",
        recipeInstructions = listOf(
            "Butter one side of each bread slice. Place a slice of cheese between two slices of bread, with the buttered sides facing out.",
            "Heat a skillet over medium heat. Once hot, place the sandwich in the skillet.",
            "Grill the sandwich for 2-3 minutes on one side, until golden brown, then flip and grill the other side until the cheese is melted and the bread is crispy.",
            "Serve hot, optionally with tomato soup or your favorite side."
        ),
        recipeTime = 10,
        recipeServings = 1,
        foodCategory = FoodCategory.SANDWICH,
        recipePhotoUri = "file:///android_asset/images/en/grilled_cheese.jpeg"
    ),
    Recipe(
        recipeId = 9L,
        recipeTitle = "Caesar Salad",
        recipeDescription = "A classic Caesar Salad featuring crisp romaine lettuce, creamy Caesar dressing, crunchy croutons, and shaved Parmesan cheese, perfect as a starter or a light meal.",
        recipeInstructions = listOf(
            "Wash and dry the romaine lettuce, then tear it into bite-sized pieces and place in a large salad bowl.",
            "Prepare the Caesar dressing by mixing together mayonnaise, grated Parmesan cheese, lemon juice, minced garlic, Worcestershire sauce, Dijon mustard, and anchovy paste (optional) until smooth.",
            "Toss the lettuce with the Caesar dressing until evenly coated.",
            "Add the croutons and shaved Parmesan cheese to the salad and toss lightly.",
            "Serve immediately, optionally topped with grilled chicken strips for a complete meal."
        ),
        recipeTime = 20,
        recipeServings = 4,
        foodCategory = FoodCategory.SALAD,
        recipePhotoUri = "file:///android_asset/images/en/caesar_salad.jpeg"
    ),
    Recipe(
        recipeId = 10L,
        recipeTitle = "Mushroom Soup",
        recipeDescription = "A rich and creamy mushroom soup, combining a variety of mushrooms with garlic, onions, and thyme, simmered in broth and finished with a touch of cream for a luxurious texture.",
        recipeInstructions = listOf(
            "Clean and slice the mushrooms. In a large pot, heat butter over medium heat and sauté the onions and garlic until translucent.",
            "Add the mushrooms and thyme, cooking until the mushrooms are soft and browned.",
            "Sprinkle flour over the mushrooms and cook for a minute to remove the raw flour taste.",
            "Gradually add the chicken or vegetable broth, stirring continuously to prevent lumps.",
            "Bring to a simmer and cook for 15 minutes. Stir in the cream and season with salt and pepper to taste.",
            "For a smoother soup, use an immersion blender to puree the soup to your desired consistency.",
            "Serve hot, garnished with fresh thyme or chopped parsley."
        ),
        recipeTime = 45,
        recipeServings = 4,
        foodCategory = FoodCategory.SOUP,
        recipePhotoUri = "file:///android_asset/images/en/mushroom_soup.jpeg"
    ),
    Recipe(
        recipeId = 11L,
        recipeTitle = "Tomahawk Ribeye",
        recipeDescription = "A luxurious BBQ centerpiece, the Tomahawk Ribeye is grilled to perfection with simple seasonings to enhance its natural flavors, served with a side of roasted vegetables or a fresh salad.",
        recipeInstructions = listOf(
            "Take the Tomahawk Ribeye out of the refrigerator and let it come to room temperature, about an hour before grilling.",
            "Preheat your grill to high heat. Season the steak generously with salt and freshly ground black pepper.",
            "Sear the steak on the hot grill for about 5 minutes on each side to develop a crust.",
            "Move the steak to a cooler part of the grill or reduce the heat and continue cooking to your desired doneness, using a meat thermometer to check the internal temperature (135°F for medium-rare).",
            "Let the steak rest for 10 minutes before slicing to allow the juices to redistribute.",
            "Slice against the grain and serve with your choice of sides."
        ),
        recipeTime = 60, // Including resting time
        recipeServings = 2,
        foodCategory = FoodCategory.BBQ,
        recipePhotoUri = "file:///android_asset/images/en/tomahawk_ribeye.jpeg"
    ),
    Recipe(
        recipeId = 12L,
        recipeTitle = "Flamiche",
        recipeDescription = "A savory French leek pie, Flamiche is a delightful combination of tender leeks and creamy filling wrapped in a flaky pastry crust, perfect for a vegetarian meal or appetizer.",
        recipeInstructions = listOf(
            "Preheat the oven to 375°F (190°C).",
            "Roll out the pastry dough and line a tart pan, trimming any excess. Prick the bottom with a fork.",
            "Clean the leeks and slice them thinly. Sauté in butter until softened but not browned.",
            "In a bowl, mix the cooked leeks with cream, eggs, nutmeg, salt, and pepper.",
            "Pour the leek mixture into the prepared pastry shell.",
            "Bake in the preheated oven for 35-40 minutes, or until the filling is set and the pastry is golden brown.",
            "Let cool slightly before serving. Can be enjoyed warm or at room temperature."
        ),
        recipeTime = 60,
        recipeServings = 6,
        foodCategory = FoodCategory.VEGETABLE,
        recipePhotoUri = "file:///android_asset/images/en/flamiche.jpeg"
    ),
    Recipe(
        recipeId = 13L,
        recipeTitle = "Quinoa Breakfast Bowl",
        recipeDescription = "A warm and comforting quinoa bowl, served with mixed fresh fruits, nuts, and a drizzle of honey or maple syrup, perfect for a nutritious start to the day.",
        recipeInstructions = listOf(
            "Rinse the quinoa under cold water until the water runs clear.",
            "In a medium saucepan, combine quinoa with water. Bring to a boil, then reduce heat to low, cover, and simmer for 15 minutes or until the quinoa is cooked and water is absorbed.",
            "Fluff the quinoa with a fork and mix in a dash of cinnamon and a splash of milk for creaminess.",
            "Serve the quinoa in bowls, topped with sliced bananas, berries, chopped nuts, and a drizzle of honey or maple syrup.",
            "Optionally, add a dollop of yogurt or a sprinkle of chia seeds for extra protein and texture."
        ),
        recipeTime = 25,
        recipeServings = 2,
        foodCategory = FoodCategory.BREAKFAST,
        recipePhotoUri = "file:///android_asset/images/en/quinoa_breakfast_bowl.jpeg"
    )
)

val englishRecipesIngredients = listOf(
    Ingredient(
        ingredientId = 1L,
        ownerRecipeId = 1L,
        ingredientName = "Pizza Dough",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 2L,
        ownerRecipeId = 1L,
        ingredientName = "San Marzano Tomato Sauce",
        ingredientQuantity = 100.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 3L,
        ownerRecipeId = 1L,
        ingredientName = "Fresh Mozzarella Cheese",
        ingredientQuantity = 125.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 4L,
        ownerRecipeId = 1L,
        ingredientName = "Fresh Basil",
        ingredientQuantity = 10.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 5L,
        ownerRecipeId = 1L,
        ingredientName = "Extra Virgin Olive Oil",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 6L,
        ownerRecipeId = 1L,
        ingredientName = "Salt",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 7L,
        ownerRecipeId = 2L,
        ingredientName = "Banana",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 8L,
        ownerRecipeId = 2L,
        ingredientName = "Fresh Strawberries",
        ingredientQuantity = 150.toBigDecimal(), // Roughly 1 cup
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 9L,
        ownerRecipeId = 2L,
        ingredientName = "Plain Yogurt",
        ingredientQuantity = 120.toBigDecimal(), // Roughly 1/2 cup
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 10L,
        ownerRecipeId = 2L,
        ingredientName = "Milk",
        ingredientQuantity = 120.toBigDecimal(), // Roughly 1/2 cup, adjust for desired thickness
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 11L,
        ownerRecipeId = 2L,
        ingredientName = "Honey",
        ingredientQuantity = 1.toBigDecimal(), // Optional, to taste
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 12L,
        ownerRecipeId = 3L,
        ingredientName = "Water",
        ingredientQuantity = 125.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 13L,
        ownerRecipeId = 3L,
        ingredientName = "Butter",
        ingredientQuantity = 75.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 14L,
        ownerRecipeId = 3L,
        ingredientName = "All-Purpose Flour",
        ingredientQuantity = 150.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 15L,
        ownerRecipeId = 3L,
        ingredientName = "Eggs",
        ingredientQuantity = 4.toBigDecimal(), // Adjust as needed for the dough consistency
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    // Custard filling ingredients
    Ingredient(
        ingredientId = 16L,
        ownerRecipeId = 3L,
        ingredientName = "Milk",
        ingredientQuantity = 250.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 17L,
        ownerRecipeId = 3L,
        ingredientName = "Vanilla Extract",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 18L,
        ownerRecipeId = 3L,
        ingredientName = "Sugar",
        ingredientQuantity = 100.toBigDecimal(), // Adjust based on sweetness preference for the custard
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 19L,
        ownerRecipeId = 3L,
        ingredientName = "Egg Yolks",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    // Chocolate glaze ingredients
    Ingredient(
        ingredientId = 20L,
        ownerRecipeId = 3L,
        ingredientName = "Dark Chocolate",
        ingredientQuantity = 100.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 21L,
        ownerRecipeId = 3L,
        ingredientName = "Cream",
        ingredientQuantity = 50.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 22L,
        ownerRecipeId = 4L,
        ingredientName = "Ground Beef",
        ingredientQuantity = 500.toBigDecimal(), // Roughly 125g or 1/4 lb per patty
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 23L,
        ownerRecipeId = 4L,
        ingredientName = "Cheese Slices",
        ingredientQuantity = 4.toBigDecimal(), // One slice per burger
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 24L,
        ownerRecipeId = 4L,
        ingredientName = "Hamburger Buns",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 25L,
        ownerRecipeId = 4L,
        ingredientName = "Salt",
        ingredientQuantity = 1.toBigDecimal(), // To taste
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 26L,
        ownerRecipeId = 4L,
        ingredientName = "Black Pepper",
        ingredientQuantity = 1.toBigDecimal(), // To taste
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    // Optional toppings can include lettuce, tomato, onions, pickles, ketchup, and mustard
    Ingredient(
        ingredientId = 27L,
        ownerRecipeId = 4L,
        ingredientName = "Lettuce",
        ingredientQuantity = 4.toBigDecimal(), // Leaves
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 28L,
        ownerRecipeId = 4L,
        ingredientName = "Tomato",
        ingredientQuantity = 1.toBigDecimal(), // Sliced
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 29L,
        ownerRecipeId = 4L,
        ingredientName = "Onion",
        ingredientQuantity = 1.toBigDecimal(), // Sliced
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 30L,
        ownerRecipeId = 4L,
        ingredientName = "Pickles",
        ingredientQuantity = 4.toBigDecimal(), // Slices
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 31L,
        ownerRecipeId = 5L,
        ingredientName = "Fettuccine Pasta",
        ingredientQuantity = 400.toBigDecimal(), // Roughly 14 ounces
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 32L,
        ownerRecipeId = 5L,
        ingredientName = "Butter",
        ingredientQuantity = 100.toBigDecimal(), // Roughly 3.5 ounces or about 1/2 cup
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 33L,
        ownerRecipeId = 5L,
        ingredientName = "Parmesan Cheese",
        ingredientQuantity = 100.toBigDecimal(), // Roughly 3.5 ounces, freshly grated
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 34L,
        ownerRecipeId = 5L,
        ingredientName = "Salt",
        ingredientQuantity = 1.toBigDecimal(), // Adjust to taste, keeping in mind the Parmesan's saltiness
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 35L,
        ownerRecipeId = 5L,
        ingredientName = "Freshly Ground Black Pepper",
        ingredientQuantity = 1.toBigDecimal(), // To taste
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 36L,
        ownerRecipeId = 5L,
        ingredientName = "Fresh Parsley",
        ingredientQuantity = 10.toBigDecimal(), // Leaves, chopped for garnish
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 37L,
        ownerRecipeId = 6L,
        ingredientName = "Sushi Rice",
        ingredientQuantity = 200.toBigDecimal(), // Roughly 1 cup, cooked and seasoned
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 38L,
        ownerRecipeId = 6L,
        ingredientName = "Nori Sheets",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 39L,
        ownerRecipeId = 6L,
        ingredientName = "Crab Meat or Imitation Crab",
        ingredientQuantity = 100.toBigDecimal(), // Roughly 3.5 ounces
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 40L,
        ownerRecipeId = 6L,
        ingredientName = "Avocado",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 41L,
        ownerRecipeId = 6L,
        ingredientName = "Cucumber",
        ingredientQuantity = 1.toBigDecimal(), // Small cucumber, julienned
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 42L,
        ownerRecipeId = 6L,
        ingredientName = "Sesame Seeds",
        ingredientQuantity = 1.toBigDecimal(), // For sprinkling
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 43L,
        ownerRecipeId = 7L,
        ingredientName = "Olive Oil",
        ingredientQuantity = 3.toBigDecimal(), // Roughly 3 tablespoons
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 44L,
        ownerRecipeId = 7L,
        ingredientName = "Onion",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 45L,
        ownerRecipeId = 7L,
        ingredientName = "Garlic",
        ingredientQuantity = 2.toBigDecimal(), // Cloves, minced
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 46L,
        ownerRecipeId = 7L,
        ingredientName = "Eggplant",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 47L,
        ownerRecipeId = 7L,
        ingredientName = "Zucchini",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 48L,
        ownerRecipeId = 7L,
        ingredientName = "Bell Peppers",
        ingredientQuantity = 2.toBigDecimal(), // Mixed colors
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 49L,
        ownerRecipeId = 7L,
        ingredientName = "Tomatoes",
        ingredientQuantity = 4.toBigDecimal(), // Medium-sized, diced
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 50L,
        ownerRecipeId = 7L,
        ingredientName = "Salt",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 51L,
        ownerRecipeId = 7L,
        ingredientName = "Black Pepper",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 52L,
        ownerRecipeId = 7L,
        ingredientName = "Thyme",
        ingredientQuantity = 1.toBigDecimal(), // Fresh or dried
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 53L,
        ownerRecipeId = 7L,
        ingredientName = "Basil",
        ingredientQuantity = 10.toBigDecimal(), // Fresh leaves
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 54L,
        ownerRecipeId = 7L,
        ingredientName = "Balsamic Vinegar",
        ingredientQuantity = 1.toBigDecimal(), // Optional
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 55L,
        ownerRecipeId = 8L,
        ingredientName = "Bread Slices",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 56L,
        ownerRecipeId = 8L,
        ingredientName = "Cheese Slices",
        ingredientQuantity = 2.toBigDecimal(), // Adjust based on preference
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 57L,
        ownerRecipeId = 8L,
        ingredientName = "Butter",
        ingredientQuantity = 2.toBigDecimal(), // Enough to butter two slices of bread
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 58L,
        ownerRecipeId = 9L,
        ingredientName = "Romaine Lettuce",
        ingredientQuantity = 2.toBigDecimal(), // Heads, depending on size
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 59L,
        ownerRecipeId = 9L,
        ingredientName = "Mayonnaise",
        ingredientQuantity = 120.toBigDecimal(), // About 1/2 cup
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 60L,
        ownerRecipeId = 9L,
        ingredientName = "Grated Parmesan Cheese",
        ingredientQuantity = 50.toBigDecimal(), // For the dressing
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 61L,
        ownerRecipeId = 9L,
        ingredientName = "Lemon Juice",
        ingredientQuantity = 2.toBigDecimal(), // Tablespoons
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 62L,
        ownerRecipeId = 9L,
        ingredientName = "Minced Garlic",
        ingredientQuantity = 1.toBigDecimal(), // Clove
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 63L,
        ownerRecipeId = 9L,
        ingredientName = "Worcestershire Sauce",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 64L,
        ownerRecipeId = 9L,
        ingredientName = "Dijon Mustard",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 65L,
        ownerRecipeId = 9L,
        ingredientName = "Anchovy Paste",
        ingredientQuantity = 0.5.toBigDecimal(), // Optional, to taste
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 66L,
        ownerRecipeId = 9L,
        ingredientName = "Croutons",
        ingredientQuantity = 1.toBigDecimal(), // Cup
        ingredientQuantityUnit = IngredientQuantityUnit.CUP
    ),
    Ingredient(
        ingredientId = 67L,
        ownerRecipeId = 9L,
        ingredientName = "Shaved Parmesan Cheese",
        ingredientQuantity = 30.toBigDecimal(), // For garnish
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 68L,
        ownerRecipeId = 10L,
        ingredientName = "Mixed Mushrooms",
        ingredientQuantity = 500.toBigDecimal(), // e.g., button, cremini, portobello
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 69L,
        ownerRecipeId = 10L,
        ingredientName = "Butter",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 70L,
        ownerRecipeId = 10L,
        ingredientName = "Onion",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 71L,
        ownerRecipeId = 10L,
        ingredientName = "Garlic",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 72L,
        ownerRecipeId = 10L,
        ingredientName = "Fresh Thyme",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 73L,
        ownerRecipeId = 10L,
        ingredientName = "All-Purpose Flour",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 74L,
        ownerRecipeId = 10L,
        ingredientName = "Chicken or Vegetable Broth",
        ingredientQuantity = 1.toBigDecimal(), // Liter
        ingredientQuantityUnit = IngredientQuantityUnit.LITER
    ),
    Ingredient(
        ingredientId = 75L,
        ownerRecipeId = 10L,
        ingredientName = "Cream",
        ingredientQuantity = 120.toBigDecimal(), // About 1/2 cup
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 76L,
        ownerRecipeId = 10L,
        ingredientName = "Salt",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 77L,
        ownerRecipeId = 10L,
        ingredientName = "Black Pepper",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 78L,
        ownerRecipeId = 11L,
        ingredientName = "Tomahawk Ribeye Steak",
        ingredientQuantity = 1.toBigDecimal(), // Approximate weight in kg or lbs depending on size
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 79L,
        ownerRecipeId = 11L,
        ingredientName = "Salt",
        ingredientQuantity = 2.toBigDecimal(), // Enough to season generously
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 80L,
        ownerRecipeId = 11L,
        ingredientName = "Freshly Ground Black Pepper",
        ingredientQuantity = 1.toBigDecimal(), // To taste
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 81L,
        ownerRecipeId = 12L,
        ingredientName = "Pastry Dough",
        ingredientQuantity = 1.toBigDecimal(), // Enough to line a tart pan
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 82L,
        ownerRecipeId = 12L,
        ingredientName = "Leeks",
        ingredientQuantity = 4.toBigDecimal(), // Large leeks
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 83L,
        ownerRecipeId = 12L,
        ingredientName = "Butter",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 84L,
        ownerRecipeId = 12L,
        ingredientName = "Heavy Cream",
        ingredientQuantity = 240.toBigDecimal(), // About 1 cup
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 85L,
        ownerRecipeId = 12L,
        ingredientName = "Eggs",
        ingredientQuantity = 3.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 86L,
        ownerRecipeId = 12L,
        ingredientName = "Nutmeg",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 87L,
        ownerRecipeId = 12L,
        ingredientName = "Salt",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 88L,
        ownerRecipeId = 12L,
        ingredientName = "Black Pepper",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 89L,
        ownerRecipeId = 13L,
        ingredientName = "Quinoa",
        ingredientQuantity = 100.toBigDecimal(), // About 1/2 cup uncooked
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 90L,
        ownerRecipeId = 13L,
        ingredientName = "Water",
        ingredientQuantity = 250.toBigDecimal(), // About 1 cup, for cooking quinoa
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 91L,
        ownerRecipeId = 13L,
        ingredientName = "Cinnamon",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 92L,
        ownerRecipeId = 13L,
        ingredientName = "Milk",
        ingredientQuantity = 60.toBigDecimal(), // About 1/4 cup, can use dairy or non-dairy
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 93L,
        ownerRecipeId = 13L,
        ingredientName = "Banana",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 94L,
        ownerRecipeId = 13L,
        ingredientName = "Berries",
        ingredientQuantity = 100.toBigDecimal(), // Mixed berries, fresh or frozen
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 95L,
        ownerRecipeId = 13L,
        ingredientName = "Nuts",
        ingredientQuantity = 30.toBigDecimal(), // Almonds, walnuts, or pecans, chopped
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 96L,
        ownerRecipeId = 13L,
        ingredientName = "Honey or Maple Syrup",
        ingredientQuantity = 2.toBigDecimal(), // To taste
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    )
)
