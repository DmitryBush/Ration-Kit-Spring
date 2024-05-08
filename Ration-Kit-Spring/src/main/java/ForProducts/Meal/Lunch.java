package ForProducts.Meal;

import ForProducts.Meal.Visitor.MealVisitor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Lunch extends One_Meal
{
    public Lunch(AnnotationConfigApplicationContext context)
    {
        this.context = context;
    }
    @Override
    public One_Meal Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor)
    {
        mealVisitor.CalculateLunch(this, person);
        CreatePlan(meals_in_day);
        return this;
    }
}
