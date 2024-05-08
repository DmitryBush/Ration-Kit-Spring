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
@ComponentScan("Aspects")
@ComponentScan("ForProducts.Meal.Visitor")
@ComponentScan("Database")
@ComponentScan("ForProducts.Product.Chain")
@ComponentScan("ForProducts.Meal")
@ComponentScan("ForProducts.Product")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
    @Scope("singleton")
    @Bean(name = "MainHuman")
    public Human singletonHuman(){
        return new Human();
    }
}

