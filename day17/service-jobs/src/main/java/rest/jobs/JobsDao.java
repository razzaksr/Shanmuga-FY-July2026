package rest.jobs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobsDao {
    public Jobs readByBike(String bike){
        String qry = "select * from jobs where vehicle=?";
        try(
            Connection con = DbConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(qry);
        ){
            ps.setString(1, bike);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Jobs job = new Jobs();
                job.setVehicle(rs.getString("vehicle"));
                job.setJobcard(rs.getInt("jobcard"));
                job.setCustomerName(rs.getString("customer_name"));
                job.setContact(rs.getLong("contact"));
                job.setActualBill(rs.getDouble("actual_bill"));
                job.setComplaints(rs.getString("complaints"));
                job.setDate(rs.getDate("date").toLocalDate());
                job.setEngineer(rs.getString("engineer"));
                job.setStatus(rs.getString("status"));
                job.setTentativeBill(rs.getDouble("tentative_bill"));
                return job;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public boolean deletion(int id){
        String qry  ="delete from jobs where jobcard=?";
        try(
            Connection con=DbConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(qry);
        ){
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean updating(int id, Jobs jobs){
        String qry = "update jobs set complaints=?, actual_bill=?, status=?, date=? where jobcard=?";
        try(
            Connection con = DbConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(qry);
        ){
            System.out.println(jobs);
            ps.setString(1, jobs.getComplaints());
            ps.setDouble(2, jobs.getActualBill());
            ps.setString(3, jobs.getStatus());
            ps.setDate(4, Date.valueOf(jobs.getDate()));
            ps.setInt(5, id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Jobs> readAll(){
        String qry = "select * from jobs";
        List<Jobs> fetched = new ArrayList<>();
        try(
            Connection con=DbConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(qry)
        ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Jobs job = new Jobs();
                job.setVehicle(rs.getString("vehicle"));
                job.setJobcard(rs.getInt("jobcard"));
                job.setCustomerName(rs.getString("customer_name"));
                job.setContact(rs.getLong("contact"));
                job.setActualBill(rs.getDouble("actual_bill"));
                job.setComplaints(rs.getString("complaints"));
                job.setDate(rs.getDate("date").toLocalDate());
                job.setEngineer(rs.getString("engineer"));
                job.setStatus(rs.getString("status"));
                job.setTentativeBill(rs.getDouble("tentative_bill"));
                fetched.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fetched;
    }
    public boolean insertion(Jobs jobs){
        String qry = "insert into jobs(customer_name,contact,vehicle,engineer, date,complaints,tentative_bill, status) values(?,?,?,?,?,?,?,?)";
        try(
            Connection con=DbConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(qry)
        ){
           ps.setString(1, jobs.getCustomerName());
           ps.setLong(2, jobs.getContact());
           ps.setString(3, jobs.getVehicle());
           ps.setString(4, jobs.getEngineer());
           ps.setDate(5, Date.valueOf(jobs.getDate()));
           ps.setString(6, jobs.getComplaints());
           ps.setDouble(7, jobs.getTentativeBill());
           ps.setString(8, jobs.getStatus());
           return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
