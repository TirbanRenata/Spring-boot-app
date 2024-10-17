package RecipeBook.Services;

import RecipeBook.Models.RecipeBook;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeBookService {
    private final List<RecipeBook> recipes = new ArrayList<>();

    public RecipeBookService() {
        RecipeBook rb = new RecipeBook();
        rb.setTitle("Papanasi");
        rb.setDescription("Papanașii – sunt nucleul tuturor deserturilor în România, un aluat prăjit, peste care se toarnă dulceață și smântână fermentată.");
        rb.setIngredients(List.of("500 g branza dulce de vaci", "300 g faina", "200 g smantana", "150 g dulceata", "30 g zahar vanilat", "2 oua", "1 lingurita esenta de portocala", "1 lingurita rasa bicarbonat de sodiu", "coaja de la o lamaie", "putina sare"));
        rb.setPreparationSteps("Pasul 1. Scurge bine brânza de vaci.\n" +
                "Pasul 2. Amestecă, folosind un mixer, brânza cu ouăle bătute, sarea, zahărul vanilat și coaja de lămâie.\n" +
                "Pasul 3. Cerne deasupra făina amestecată cu praful de copt și frământă ușor cu mâna aluatul, care va fi unul moale, ușor lipicios.\n" +
                "Pasul 4. Acoperă-l cu o folie alimentară și dă la frigider 30 de minute.\n" +
                "Pasul 5. Presară făină pe un blat de lucru, răstoarnă aluatul, pudrează-l cu puțină făină, apoi întinde o foaie de 2.5 cm grosime.\n" +
                "Pasul 6. Cu o formă rotundă de patiserie cu diametrul de 10 cm, decupeaza cercurile mari. Cu o formă mai mică, de 3 cm, decupează centrul cercurilor.\n" +
                "Pasul 7. La foc mediu, încinge 500 g de ulei într-o cratiță mai adâncă și prăjește pe rând papanașii.\n" +
                "Pasul 8. După 3 minute, întoarce-i pe partea cealaltă și mai prăjește 2 minute. Biluțele se vor întoarce singure.\n" +
                "Pasul 9. Când sunt rumeniți, scoate-i cu o spumieră, pe prosoape de hârtie.");
        rb.setCookingTime(30);

        recipes.add(rb);
    }

    @ModelAttribute(name = "recipes")
    public List<RecipeBook> getAllRecipes() {
        return recipes;
    }

    public void addRecipe(RecipeBook recipe) {
        recipes.add(recipe);
    }
}
