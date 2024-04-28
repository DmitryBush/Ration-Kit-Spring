package ForProducts.Meal;

import Database.Directory;
import ForProducts.Meal.Visitor.MealVisitor;
import Human.SingletoneHuman;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Breakfast extends One_Meal
{
    public Breakfast()
    {
        var con = new AnnotationConfigApplicationContext(SingletoneHuman.class);
        directory = con.getBean(Directory.class);
    }
    @Override
    public void Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor, AnnotationConfigApplicationContext context)
    {
        mealVisitor.CalculateBreakfast(this, context);
        CreatePlan(meals_in_day);
    }
}
