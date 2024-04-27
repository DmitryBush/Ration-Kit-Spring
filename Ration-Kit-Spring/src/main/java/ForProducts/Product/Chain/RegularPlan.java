package ForProducts.Product.Chain;

import ForProducts.Meal.Breakfast;
import ForProducts.Meal.Dinner;
import ForProducts.Meal.Lunch;
import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeOfDiet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RegularPlan extends PlanHandler
{

    public RegularPlan() {
        super(TypeOfDiet.diet_regular);
    }

    @Override
    protected void CreatePlan(List<One_Meal> dayMeals,  AnnotationConfigApplicationContext context)
    {
        Breakfast breakfast = context.getBean(Breakfast.class);
        Lunch lunch = context.getBean(Lunch.class);
        Dinner dinner = context.getBean(Dinner.class);
        dayMeals.add(breakfast);
        dayMeals.add(lunch);
        dayMeals.add(dinner);

    }

    @Override
    protected void Describe() {
        System.out.println("Это стандартный тип питания, " +
                "при котором вы можете есть в удобное для вас время, но не позже двух часов до сна!");
    }


}
