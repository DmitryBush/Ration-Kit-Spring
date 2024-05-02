package ForProducts.Product.Chain;

import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeOfDiet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Plan0 extends PlanHandler
{
    public Plan0() {
        super(TypeOfDiet.diet_24_0);
    }

    @Override
    protected void CreatePlan(List<One_Meal> dayMeals, AnnotationConfigApplicationContext context) {}

    @Override
    protected void Describe() {
        System.out.println("Ультра-хардкор. Вы должны прожить без еды целые сутки. Можно пить только воду.\n" +
                "Употребить не менее 10 стаканов воды за день");
    }


}
