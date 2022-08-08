@SpringBootApplication
public class Startup {
    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Startup.class);
        String port = "8080";
        ApplicationArguments cliOpt = new DefaultApplicationArguments(args);
        if cliOpt.containsOption("port"){
            port = cliOpt.getOptionValues("port").get(0);
        }
        app.setDefaultProperties(Collections.singletonMap("server.port", port));
        app.run();
    }
    @Bean
    public CommonsRequestLoggingFilter log(){
        CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
        logger.setIncludeClientInfo(true);
        logger.setIncludeQueryString(true);
        return logger;
        // application.properties
        // logging.level.org.springframework.web.filter.CommonsRequestLoggingFilter=DEBUG
    }
}
