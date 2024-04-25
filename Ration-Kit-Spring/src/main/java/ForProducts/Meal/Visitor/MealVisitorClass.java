package ForProducts.Meal.Visitor;

import ForProducts.Meal.One_Meal;
import Human.Human;
import Human.SingletoneHuman;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MealVisitorClass implements MealVisitor
{
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingletoneHuman.class);
    @Override
    public void CalculateBreakfast(One_Meal meal) {
        var _Human = context.getBean(Human.class);
        float max_protein, max_carbohydrates, max_fats;

        meal.setMax_protein(max_protein = _Human.getProtein() * 0.3f);
        meal.setMax_fats(max_fats = _Human.getFats() * 0.3f);
        meal.setMax_carbohydrates(max_carbohydrates = _Human.getCarbohydrates() * 0.3f);

        meal.setMax_kilocalories(max_protein * 4 + max_carbohydrates * 4 + max_fats * 9);
    }

    @Override
    public void CalculateLunch(One_Meal meal) {
        var _Human = context.getBean(Human.class);
        float max_protein, max_carbohydrates, max_fats;

        meal.setMax_protein(max_protein = _Human.getProtein() * 0.4f);
        meal.setMax_fats(max_fats = _Human.getFats() * 0.4f);
        meal.setMax_carbohydrates(max_carbohydrates = _Human.getCarbohydrates() * 0.4f);

        meal.setMax_kilocalories(max_protein * 4 + max_carbohydrates * 4 + max_fats * 9);
    }

    @Override
    public void CalculateDinner(One_Meal meal) {
        CalculateBreakfast(meal);
    }
}
