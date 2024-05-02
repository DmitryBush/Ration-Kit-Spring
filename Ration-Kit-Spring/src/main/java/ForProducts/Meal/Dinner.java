package ForProducts.Meal;

import ForProducts.Meal.Visitor.MealVisitor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Dinner extends One_Meal
{
    public Dinner(AnnotationConfigApplicationContext context)
    {
        this.context = context;
    }
    @Override
    public void Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor)
    {
        mealVisitor.CalculateDinner(this, context);
        CreatePlan(meals_in_day);
    }
}
