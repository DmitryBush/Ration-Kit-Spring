package rationKit.ForProducts.Meal.Visitor;

import rationKit.ForProducts.Meal.One_Meal;
import rationKit.Human.Human;

public interface MealVisitor
{
    void CalculateBreakfast(One_Meal meal, Human person);
    void CalculateLunch(One_Meal meal, Human person);
    void CalculateDinner(One_Meal meal, Human person);
}
