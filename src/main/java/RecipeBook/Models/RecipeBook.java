package RecipeBook.Models;

import lombok.Data;

import java.util.List;

@Data
public class RecipeBook {

    private String title;
    private List<String> ingredients;
    private String description;
    private String preparationSteps;
    private int cookingTime;
}
