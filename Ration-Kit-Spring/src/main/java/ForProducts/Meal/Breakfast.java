package ForProducts.Meal;

import Database.Directory;
import Database.DirectoryConfig;
import ForProducts.Meal.Visitor.MealVisitor;
import Human.Human;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Breakfast extends One_Meal
{
    public Breakfast()
    {
        var dbConfig = new AnnotationConfigApplicationContext(DirectoryConfig.class);
        directory = dbConfig.getBean(Directory.class);
    }
    @Override
    public void Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor,
                            AnnotationConfigApplicationContext context)
    {
        person = context.getBean(Human.class);
        mealVisitor.CalculateBreakfast(this, context);
        CreatePlan(meals_in_day);
    }
}
