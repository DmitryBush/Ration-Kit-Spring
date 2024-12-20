package rationKit.ForProducts.Meal.Visitor;

import rationKit.ForProducts.Meal.One_Meal;
import rationKit.Human.Human;
import org.springframework.stereotype.Component;

@Component
public class MealVisitorClass implements MealVisitor
{
    @Override
    public void CalculateBreakfast(One_Meal meal,Human person) {
        float max_protein, max_carbohydrates, max_fats;

        meal.setMax_protein(max_protein = person.getProtein() * 0.3f);
        meal.setMax_fats(max_fats = person.getFats() * 0.3f);
        meal.setMax_carbohydrates(max_carbohydrates = person.getCarbohydrates() * 0.3f);

        meal.setMax_kilocalories(max_protein * 4 + max_carbohydrates * 4 + max_fats * 9);
    }

    @Override
    public void CalculateLunch(One_Meal meal,Human person) {
        float max_protein, max_carbohydrates, max_fats;

        meal.setMax_protein(max_protein = person.getProtein() * 0.4f);
        meal.setMax_fats(max_fats = person.getFats() * 0.4f);
        meal.setMax_carbohydrates(max_carbohydrates = person.getCarbohydrates() * 0.4f);

        meal.setMax_kilocalories(max_protein * 4 + max_carbohydrates * 4 + max_fats * 9);
    }

    @Override
    public void CalculateDinner(One_Meal meal,Human person) {
        CalculateBreakfast(meal,person);
    }
}
