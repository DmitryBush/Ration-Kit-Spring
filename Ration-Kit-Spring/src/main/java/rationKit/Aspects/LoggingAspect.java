package rationKit.Aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public void Create_Meal(..))")
    public void beforeCreateMealAdvice() {
        System.out.println("beforeCreateMeal: Подбор продуктов для приёма пищи.");
    }

    @Before("execution(public void CalculateBreakfast(..))")
    public void beforeCreateBreakfastMealAdvice() {
        System.out.println("beforeCreateBreakfastMeal: Подбор продуктов для завтрака.");

    }

    @Before("execution(public void CalculateLunch(..))")
    public void beforeCreateLunchMealAdvice() {
        System.out.println("beforeCreateLunchMeal: Подбор продуктов для обеда.");

    }

    @Before("execution(public void CalculateDinner(..))")
    public void beforeCreateDinnerMealAdvice() {
        System.out.println("beforeCreateDinnerMeal: Подбор продуктов для ужина.");
    }
}
