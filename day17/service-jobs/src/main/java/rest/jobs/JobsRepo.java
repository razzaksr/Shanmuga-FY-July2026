package rest.jobs;

import java.util.List;

public interface JobsRepo {
    Jobs openCard(Jobs jobs);// insert
    List<Jobs> findAll();// read
    Jobs findByVehicle(String vehicle);// read
    boolean discard(int jobcard);// delete
    Jobs update(int jobcard, Jobs jobs);
}
