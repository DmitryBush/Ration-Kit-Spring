package ForProducts.Product.Chain;

import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeOfDiet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public interface Handler
{
    void setNext(Handler handler);
    List<One_Meal> handle(TypeOfDiet type);
    void Explain(TypeOfDiet type);


}
