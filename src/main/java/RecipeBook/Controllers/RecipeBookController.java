package RecipeBook.Controllers;

import RecipeBook.Models.RecipeBook;
import RecipeBook.Services.RecipeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipeBookController {

    @Autowired
    private RecipeBookService recipeBookService;

    @GetMapping("/recipes")
    public String getAllRecipes() {
        return "recipe";
    }

    @GetMapping("/recipes/add")
    public String showAddRecipeForm(Model model) {
        model.addAttribute("recipe", new RecipeBook());
        return "add_recipe";
    }

    @PostMapping("/recipes/add")
    public String addRecipe(@ModelAttribute RecipeBook recipe) {
        recipeBookService.addRecipe(recipe);
        return "redirect:/recipes";
    }
}
