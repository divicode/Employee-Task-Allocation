package com.cts.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Employee {
    @Id
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private long salary;

    @Column(unique = true)
    private String email;


//
    @OneToMany(mappedBy="engagedEmployee" ,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<JobDetail> engagedInJobs;

}


