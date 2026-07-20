package rest.jobs;

import java.time.LocalDate;

import io.javalin.http.Context;

public class Controller {
    private JobsService service = new JobsService();
    public void callInsertion(Context ctx){
        Jobs jobs = ctx.bodyAsClass(Jobs.class);
        jobs.setStatus("to do");
        jobs.setDate(LocalDate.now());
        if(service.openCard(jobs)!=null)
            ctx.status(201).result("Jobcard generated");
        else ctx.status(400).result("Invalid information");
    }
    public void callReadAll(Context ctx){
        ctx.json(service.findAll());
    }
    public void readReadOne(Context ctx){
        Jobs returned = service.findByVehicle(ctx.pathParam("reg"));
        if(returned!=null)
            ctx.status(200).json(returned);
        else ctx.status(404).result("Invalid vehicle");            
    }
    public void callUpdate(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("id"));
        Jobs jobs = ctx.bodyAsClass(Jobs.class);
        jobs.setDate(LocalDate.now());
        if(service.update(id, jobs)!=null)
            ctx.status(200).result(id+" has updated");
        else ctx.status(404).result("Invalid jobcard");
    }
    public void callDelete(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("id"));
        if(service.discard(id)) 
            ctx.status(201).result(id+" jobcard cancelled");
        else ctx.status(404).result("Invalid jobcard");
    }
}
