package ForProducts.Product.Chain;

import ForProducts.Meal.Breakfast;
import ForProducts.Meal.Dinner;
import ForProducts.Meal.Lunch;
import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeOfDiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("plan8")
public class Plan8 extends PlanHandler
{
    @Autowired
    private Breakfast breakfast;
    @Autowired
    private Lunch lunch;
    @Autowired
    private Dinner dinner;
    public Plan8() {
        super(TypeOfDiet.diet_16_8);
    }
    @Override
    protected List<One_Meal> CreatePlan() {
        var beanList = new ArrayList<One_Meal>();
        beanList.add(breakfast);
        beanList.add(lunch);
        beanList.add(dinner);
        return beanList;
    }

    @Override
    protected void Describe() {
        System.out.println("Интервальное голодание, вы должны есть только на протяжении 8 часов, " +
                "остальные 16 часов вы не должны есть. \n" +
                "Уменьшите время между приёмами пищи" + "Вы должны пить как можно больше воды! \n" +
                "Это поможет продержаться во время голодания. Вода помогает унять чувство голода.");
    }


}
