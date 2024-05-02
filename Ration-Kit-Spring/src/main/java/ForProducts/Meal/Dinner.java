package ForProducts.Meal;

import Database.Directory;
import Database.DirectoryConfig;
import ForProducts.Meal.Visitor.MealVisitor;
import Human.Human;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dinner extends One_Meal
{
    public Dinner()
    {
        var dbConfig = new AnnotationConfigApplicationContext(DirectoryConfig.class);
        directory = dbConfig.getBean(Directory.class);
    }
    @Override
    public void Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor,
                            AnnotationConfigApplicationContext context)
    {
        person = context.getBean(Human.class);
        mealVisitor.CalculateDinner(this, context);
        CreatePlan(meals_in_day);
    }
}
