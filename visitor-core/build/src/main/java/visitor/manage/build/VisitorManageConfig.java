package visitor.manage.build;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@ImportResource("classpath:spring-config.xml")
@PropertySource({"classpath:application.properties"})
@ComponentScan("visitor.manage")
public class VisitorManageConfig {

        public void init(){
            new SpringApplicationBuilder().sources(VisitorManageConfig.class).web(WebApplicationType.SERVLET).run();
        }
}
