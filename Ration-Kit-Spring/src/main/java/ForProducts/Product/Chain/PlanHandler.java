package ForProducts.Product.Chain;

import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeofDiet;

import java.util.List;
import java.util.Objects;

public abstract class PlanHandler implements Handler
{
    private final TypeofDiet type;
    private Handler nextChain;

    public PlanHandler(TypeofDiet type)
    {
        this.type = type;
    }
    @Override
    public void setNext(Handler handler) {nextChain = handler;}
    @Override
    public void handle(TypeofDiet type, List<One_Meal> dayMeals)
    {
        if (this.type.ordinal() == type.ordinal())
            CreatePlan(dayMeals);

        if (Objects.nonNull(nextChain))
            nextChain.handle(type, dayMeals);
    }
    @Override
    public void Explain(TypeofDiet type)
    {
        if (this.type.ordinal() == type.ordinal())
            Describe();

        if (Objects.nonNull(nextChain))
            nextChain.Explain(type);
    }
    protected abstract void CreatePlan(List<One_Meal> dayMeals);
    protected abstract void Describe();
}
