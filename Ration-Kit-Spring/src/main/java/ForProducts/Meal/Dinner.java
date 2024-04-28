package ForProducts.Meal;

import Database.Directory;
import ForProducts.Meal.Visitor.MealVisitor;
import Human.SingletoneHuman;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Dinner extends One_Meal
{
    public Dinner()
    {
        var con = new AnnotationConfigApplicationContext(SingletoneHuman.class);
        directory = con.getBean(Directory.class);
    }
    @Override
    public void Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor, AnnotationConfigApplicationContext context)
    {
        mealVisitor.CalculateDinner(this, context);
        CreatePlan(meals_in_day);
    }
}
