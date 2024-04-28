package Human;

import Database.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("singleton")
@ComponentScan("Database")
public class SingletoneHuman {

    @Bean(name = "MainHuman")
    public Human singletonHuman(){
        System.out.println("Rabota");
        return new Human();
    }
}

