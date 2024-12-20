package rationKit.ForProducts.Meal;

import rationKit.ForProducts.Meal.Visitor.MealVisitor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Breakfast extends One_Meal
{
    public Breakfast(AnnotationConfigApplicationContext context)
    {
        this.context = context;
    }
    @Override
    public One_Meal Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor)
    {
        mealVisitor.CalculateBreakfast(this, person);
        CreatePlan(meals_in_day);
        return this;
    }
}
