package rationKit.Aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public void Create_Meal(..))")
    public void beforeCreateMealAdvice() {
        logger.debug("beforeCreateMeal: Подбор продуктов для приёма пищи.");
    }

    @Before("execution(public void CalculateBreakfast(..))")
    public void beforeCreateBreakfastMealAdvice() {
        logger.debug("beforeCreateBreakfastMeal: Подбор продуктов для завтрака.");
    }

    @Before("execution(public void CalculateLunch(..))")
    public void beforeCreateLunchMealAdvice() {
        logger.debug("beforeCreateLunchMeal: Подбор продуктов для обеда.");
    }

    @Before("execution(public void CalculateDinner(..))")
    public void beforeCreateDinnerMealAdvice() {
        logger.debug("beforeCreateDinnerMeal: Подбор продуктов для ужина.");
    }
}
