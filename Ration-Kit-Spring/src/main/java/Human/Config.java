package Human;

import Database.Directory;
import ForProducts.Meal.Breakfast;
import ForProducts.Meal.Dinner;
import ForProducts.Meal.Lunch;
import ForProducts.Meal.One_Meal;
import ForProducts.Meal.Visitor.MealVisitor;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
@Scope("singleton")
@ComponentScan("aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {

    @Bean(name = "MainHuman")
    public Human singletonHuman(){
        return new Human();
    }
    @Bean
    public Breakfast breakfast(){
        return new Breakfast();
    }
    @Bean
    public Lunch lunch(){
        return new Lunch();
    }
    @Bean
    public Dinner dinner(){
        return new Dinner();
    }

}

