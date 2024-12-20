package rationKit;

import rationKit.Human.Human;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.property")
@ComponentScan(basePackages = "rationKit")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
    @Scope("singleton")
    @Bean(name = "MainHuman")
    public Human singletonHuman(){
        return new Human();
    }
}

