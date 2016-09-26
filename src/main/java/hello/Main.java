package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.Arguments;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.messageresolver.MessageResolution;
import org.thymeleaf.messageresolver.StandardMessageResolver;
import org.thymeleaf.spring4.messageresolver.SpringMessageResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import util.DataManager;

/**
 * Created by техносила on 15.08.2016.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

    }

}
