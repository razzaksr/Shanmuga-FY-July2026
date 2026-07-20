package rest.jobs;

import java.time.LocalDate;

import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Controller api = new Controller();
        Javalin app = Javalin.create(config->{
            config.showJavalinBanner=true;
        }).start(1234);
        app.post("/service", api::callInsertion);
        app.get("/service", api::callReadAll);
        app.patch("/service/{id}", api::callUpdate);
        app.delete("/service/{id}", api::callDelete);
        app.get("/service/filter/{reg}", api::readReadOne);
    }
}
