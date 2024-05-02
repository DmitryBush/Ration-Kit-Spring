package ForProducts.Product.Chain;

import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeOfDiet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public interface Handler
{
    void setNext(Handler handler);
    void handle(TypeOfDiet type, List<One_Meal> dayMeals);
    void Explain(TypeOfDiet type);


}
