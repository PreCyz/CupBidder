package configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/** Created by gawa on 03.05.17. */
@Configuration
@Import(bidder.config.MainConfig.class)
public class MainConfig {

}
