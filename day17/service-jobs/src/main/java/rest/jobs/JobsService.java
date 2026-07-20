package rest.jobs;

import java.util.List;

public class JobsService implements JobsRepo {
    private JobsDao dao =new JobsDao();
    @Override
    public Jobs openCard(Jobs jobs) {
        if(dao.insertion(jobs)) return jobs;
        else return null;
    }

    @Override
    public List<Jobs> findAll() {
        return dao.readAll();
    }

    @Override
    public Jobs findByVehicle(String vehicle) {
        return dao.readByBike(vehicle);
    }

    @Override
    public boolean discard(int jobcard) {
        return dao.deletion(jobcard);
    }

    @Override
    public Jobs update(int jobcard, Jobs jobs) {
        if(dao.updating(jobcard, jobs)) return jobs;
        else return null;
    }
    
}
