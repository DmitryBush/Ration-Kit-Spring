package ForProducts.Product.Chain;

import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeOfDiet;

import java.util.List;
import java.util.Objects;

public abstract class PlanHandler implements Handler
{
    private final TypeOfDiet type;
    private Handler nextChain;

    public PlanHandler(TypeOfDiet type)
    {
        this.type = type;
    }
    @Override
    public void setNext(Handler handler) {nextChain = handler;}
    @Override
    public void handle(TypeOfDiet type, List<One_Meal> dayMeals)
    {
        if (this.type.ordinal() == type.ordinal())
            CreatePlan(dayMeals);

        if (Objects.nonNull(nextChain))
            nextChain.handle(type, dayMeals);
    }
    @Override
    public void Explain(TypeOfDiet type)
    {
        if (this.type.ordinal() == type.ordinal())
            Describe();

        if (Objects.nonNull(nextChain))
            nextChain.Explain(type);
    }
    protected abstract void CreatePlan(List<One_Meal> dayMeals);
    protected abstract void Describe();
}
