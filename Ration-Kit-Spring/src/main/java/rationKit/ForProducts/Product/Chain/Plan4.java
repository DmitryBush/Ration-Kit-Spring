package rationKit.ForProducts.Product.Chain;

import rationKit.ForProducts.Meal.Dinner;
import rationKit.ForProducts.Meal.Lunch;
import rationKit.ForProducts.Meal.One_Meal;
import rationKit.ForProducts.Product.TypeOfDiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("plan4")
public class Plan4 extends PlanHandler
{
    @Autowired
    private Lunch lunch;
    @Autowired
    private Dinner dinner;
    public Plan4() {
        super(TypeOfDiet.diet_20_4);
    }
    @Override
    protected List<One_Meal> CreatePlan() {
        var beanList = new ArrayList<One_Meal>();
        beanList.add(lunch);
        beanList.add(dinner);
        return beanList;
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
