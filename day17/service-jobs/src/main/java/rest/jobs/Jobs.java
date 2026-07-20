package rest.jobs;

import java.time.LocalDate;
/*
jobcard int not null primary key auto_increment, 
customer_name varchar(255) not null, 
contact bigint not null, 
vehicle varchar(255) not null unique key, 
engineer varchar(255) not null, 
date date not null, 
complaints text, 
tentative_bill double not null, 
actual_bill double, 
status varchar(255));
 */

public class Jobs {
    private int jobcard;
    private String customerName;
    private long contact;
    private String vehicle;
    private String engineer;
    private LocalDate date;
    private String complaints;
    private double tentativeBill;
    private double actualBill;
    private String status;
    public Jobs() {
    }
    public Jobs(int jobcard, String customerName, long contact, String vehicle, String engineer, LocalDate date,
            String complaints, double tentativeBill, double actualBill, String status) {
        this.jobcard = jobcard;
        this.customerName = customerName;
        this.contact = contact;
        this.vehicle = vehicle;
        this.engineer = engineer;
        this.date = date;
        this.complaints = complaints;
        this.tentativeBill = tentativeBill;
        this.actualBill = actualBill;
        this.status = status;
    }
    public int getJobcard() {
        return jobcard;
    }
    public void setJobcard(int jobcard) {
        this.jobcard = jobcard;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public long getContact() {
        return contact;
    }
    public void setContact(long contact) {
        this.contact = contact;
    }
    public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    public String getEngineer() {
        return engineer;
    }
    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getComplaints() {
        return complaints;
    }
    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }
    public double getTentativeBill() {
        return tentativeBill;
    }
    public void setTentativeBill(double tentativeBill) {
        this.tentativeBill = tentativeBill;
    }
    public double getActualBill() {
        return actualBill;
    }
    public void setActualBill(double actualBill) {
        this.actualBill = actualBill;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Jobs [jobcard=" + jobcard + ", customerName=" + customerName + ", contact=" + contact + ", vehicle="
                + vehicle + ", engineer=" + engineer + ", date=" + date + ", complaints=" + complaints
                + ", tentativeBill=" + tentativeBill + ", actualBill=" + actualBill + ", status=" + status + "]";
    }
}
