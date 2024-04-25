package ForProducts.Meal.Visitor;

import ForProducts.Meal.One_Meal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface MealVisitor
{
    void CalculateBreakfast(One_Meal meal, AnnotationConfigApplicationContext context);
    void CalculateLunch(One_Meal meal,AnnotationConfigApplicationContext context);
    void CalculateDinner(One_Meal meal,AnnotationConfigApplicationContext context);
}
