package rationKit.ForProducts.Product.Chain;

import rationKit.ForProducts.Meal.One_Meal;
import rationKit.ForProducts.Product.TypeOfDiet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("plan0")
public class Plan0 extends PlanHandler
{
    public Plan0() {
        super(TypeOfDiet.diet_24_0);
    }

    @Override
    protected List<One_Meal> CreatePlan()
    {
        return new ArrayList<>();
    }

    @Override
    protected void Describe() {
        System.out.println("Ультра-хардкор. Вы должны прожить без еды целые сутки. Можно пить только воду.\n" +
                "Употребить не менее 10 стаканов воды за день");
    }


}
