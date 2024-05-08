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

@Component("regular")
public class RegularPlan extends PlanHandler
{
    @Autowired
    private Breakfast breakfast;
    @Autowired
    private Lunch lunch;
    @Autowired
    private Dinner dinner;

    public RegularPlan() {
        super(TypeOfDiet.diet_regular);
    }

    @Override
    protected List<One_Meal> CreatePlan()
    {
        var beanList = new ArrayList<One_Meal>();
        beanList.add(breakfast);
        beanList.add(lunch);
        beanList.add(dinner);
        return beanList;
    }

    @Override
    protected void Describe() {
        System.out.println("Это стандартный тип питания, " +
                "при котором вы можете есть в удобное для вас время, но не позже двух часов до сна!");
    }


}
