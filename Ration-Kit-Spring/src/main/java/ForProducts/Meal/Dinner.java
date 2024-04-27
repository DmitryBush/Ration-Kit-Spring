package ForProducts.Meal;

import Database.Directory;
import ForProducts.Meal.Visitor.MealVisitor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dinner extends One_Meal
{
    @Override
    public void Create_Meal(Directory directory, List<One_Meal> meals_in_day, MealVisitor mealVisitor, AnnotationConfigApplicationContext context)
    {
        mealVisitor.CalculateDinner(this, context);
        CreatePlan(directory, meals_in_day);
    }
}
