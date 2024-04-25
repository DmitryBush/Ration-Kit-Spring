package ForProducts.Product.Chain;

import ForProducts.Meal.Dinner;
import ForProducts.Meal.Lunch;
import ForProducts.Meal.One_Meal;
import ForProducts.Product.Type_of_Diet;

import java.util.List;

public class Plan4 extends PlanHandler
{
    public Plan4() {
        super(Type_of_Diet.diet_20_4);
    }
    @Override
    protected void CreatePlan(List<One_Meal> dayMeals) {
        dayMeals.add(new Lunch());
        dayMeals.add(new Dinner());
    }

    @Override
    protected void Describe() {
        System.out.println("Только для опытных! " +
                "В этом виде голодания вы принимаете пищу на протяжении 4 часов,\n" +
                " а на протяжении 20 часов вы не едите." +
                "Вы должны пить как можно больше воды! " +
                "Это поможет продержаться во время голодания.\n Вода помогает унять чувство голода.");
    }
}