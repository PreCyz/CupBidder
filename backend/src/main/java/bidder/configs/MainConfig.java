package bidder.configs;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by gawa on 01.05.17.
 */
@Configuration
//@EnableWebMvc
@EnableScheduling
@EnableCaching
//@EnableMongoRepositories(basePackages = {"bidder.repositories"})
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"bidder"})
public class MainConfig {
}
