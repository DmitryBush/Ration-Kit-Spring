package ForProducts.Product.Chain;

import ForProducts.Meal.Breakfast;
import ForProducts.Meal.Dinner;
import ForProducts.Meal.Lunch;
import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeOfDiet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Plan8 extends PlanHandler
{

    public Plan8() {
        super(TypeOfDiet.diet_16_8);
    }
    @Override
    protected void CreatePlan(List<One_Meal> dayMeals,  AnnotationConfigApplicationContext context) {
        Breakfast breakfast = context.getBean(Breakfast.class);
        Lunch lunch = context.getBean(Lunch.class);
        Dinner dinner = context.getBean(Dinner.class);
        dayMeals.add(breakfast);
        dayMeals.add(lunch);
        dayMeals.add(dinner);

    }

    @Override
    protected void Describe() {
        System.out.println("Интервальное голодание, вы должны есть только на протяжении 8 часов, " +
                "остальные 16 часов вы не должны есть. \n" +
                "Уменьшите время между приёмами пищи" + "Вы должны пить как можно больше воды! \n" +
                "Это поможет продержаться во время голодания. Вода помогает унять чувство голода.");
    }


}
