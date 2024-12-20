package rationKit.ForProducts.Product.Chain;

import rationKit.ForProducts.Meal.One_Meal;
import rationKit.ForProducts.Product.TypeOfDiet;

import java.util.List;

public interface Handler
{
    void setNext(Handler handler);
    List<One_Meal> handle(TypeOfDiet type);
    void Explain(TypeOfDiet type);


}
