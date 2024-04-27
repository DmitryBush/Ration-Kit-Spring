package ForProducts.Product.Chain;

import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeofDiet;

import java.util.List;

public interface Handler
{
    void setNext(Handler handler);
    void handle(TypeofDiet type, List<One_Meal> dayMeals);
    void Explain(TypeofDiet type);
}
