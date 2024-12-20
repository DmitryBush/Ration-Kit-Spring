package rationKit.ForProducts.Product.Chain;

import rationKit.ForProducts.Meal.One_Meal;
import rationKit.ForProducts.Product.TypeOfDiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DietChainHandler
{
    Handler handlerRegular;

    @Autowired
    public DietChainHandler(RegularPlan plan)
    {
        Handler handler1 = new Plan8();
        Handler handler2 = new Plan4();

        plan.setNext(handler1);
        handler1.setNext(handler2);

        this.handlerRegular = plan;
    }

    public List<One_Meal> handle(TypeOfDiet type)
    {
        return handlerRegular.handle(type);
    }
    public void Explain(TypeOfDiet type) {handlerRegular.Explain(type);}
}
