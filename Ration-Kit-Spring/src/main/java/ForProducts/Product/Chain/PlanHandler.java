package ForProducts.Product.Chain;

import ForProducts.Meal.One_Meal;
import ForProducts.Product.TypeOfDiet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
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
    public List<One_Meal> handle(TypeOfDiet type)
    {
        if (this.type.ordinal() == type.ordinal())
            return CreatePlan();

        if (Objects.nonNull(nextChain))
            return nextChain.handle(type);
        return new ArrayList<>();
    }
    @Override
    public void Explain(TypeOfDiet type)
    {
        if (this.type.ordinal() == type.ordinal())
            Describe();

        if (Objects.nonNull(nextChain))
            nextChain.Explain(type);
    }
    protected abstract List<One_Meal> CreatePlan();
    protected abstract void Describe();


}
