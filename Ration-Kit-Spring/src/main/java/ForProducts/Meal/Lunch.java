package ForProducts.Meal;

import ForProducts.Meal.Visitor.MealVisitor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Lunch extends One_Meal
{
    public Lunch(AnnotationConfigApplicationContext context)
    {
        this.context = context;
    }
    @Override
    public void Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor)
    {
        mealVisitor.CalculateLunch(this, context);
        CreatePlan(meals_in_day);
    }
}
