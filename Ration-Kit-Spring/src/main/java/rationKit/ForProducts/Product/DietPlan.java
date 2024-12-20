package rationKit.ForProducts.Product;
import rationKit.ForProducts.Meal.One_Meal;
import rationKit.ForProducts.Meal.Visitor.MealVisitor;
import rationKit.ForProducts.Product.Chain.DietChainHandler;
import rationKit.Human.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DietPlan {
    private final List<One_Meal> Meals_in_day = new ArrayList<>();
    float day_protein, day_fats, day_carbonohydrates , day_kilocalories;
    @Autowired
    private Human person;
    @Autowired
    private DietChainHandler handler;
    @Autowired
    private MealVisitor visitor;

    public void Create_Day_Diet(){    // создание вариантов питания на день в зависимости от типа диет
        var tmpBeans = CreatePlan();

        for (var i: tmpBeans)
        {
            Meals_in_day.add(i.Create_Meal(Meals_in_day, visitor));

            day_protein += i.getProtein();
            day_fats += i.getFats();
            day_carbonohydrates += i.getCarbohydrates();
        }

        day_kilocalories = day_protein*4 + day_carbonohydrates*4 + day_fats*9;
        Explanations_of_intermittent_fasting();
    }

    private List<One_Meal> CreatePlan()
    {
        return handler.handle(person.getTypeDiet());
    }

   public void Show_Ration_OnDay(){     // показ всех продуктов используемых в дневном рационе
       for (var meal : Meals_in_day) {
           System.out.println(meal.getClass().getSimpleName());

           for (var product: meal)
           {
               System.out.println(product);
           }
           System.out.println(meal);
       }

        System.out.println("Общее количество белка за день: " + day_protein);
        System.out.println("Общее количество жиров за день: " + day_fats);
        System.out.println("Общее количество углеводов за день: " + day_carbonohydrates);
        System.out.println("Общее количество ккал за приём день: " + day_kilocalories+ "\n\n\n");
    }

    void Explanations_of_intermittent_fasting() // небольшой список советов
    {
        handler.Explain(person.getTypeDiet());
    }
}
