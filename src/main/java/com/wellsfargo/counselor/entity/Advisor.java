package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Advisor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    private String phone;
    
    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;
    
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;
    
    protected Advisor() {}
    
    public Advisor(String firstName, String lastName, String email, 
                   String phone, String employeeId, Date hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }
    
    // Getters and Setters
    public Long getAdvisorId() { return advisorId; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    
    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    
    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}