package Human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("singleton")

public class SingletoneHuman {

    @Bean(name = "MainHuman")
    public Human singletonHuman(){
        System.out.println("Rabota");
        return new Human();
    }
}
