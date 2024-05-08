package ForProducts.Meal.Visitor;

import ForProducts.Meal.One_Meal;
import Human.Human;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface MealVisitor
{
    void CalculateBreakfast(One_Meal meal, Human person);
    void CalculateLunch(One_Meal meal, Human person);
    void CalculateDinner(One_Meal meal, Human person);
}
