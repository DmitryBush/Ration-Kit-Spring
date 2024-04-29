package Human;

import Database.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingletoneHuman {

    @Bean(name = "MainHuman")
    @Scope("singleton")
    public Human singletonHuman(){
        return new Human();
    }
}

