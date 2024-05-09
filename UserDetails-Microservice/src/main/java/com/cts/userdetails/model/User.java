package com.cts.userdetails.model;

import com.cts.userdetails.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="user_data")
public class User {
    @Id
    private long id;

    @Column(name = "first_name")
    //@Pattern(regexp = "^[A-Za-z0-9._]{2,15}$",message = "Name should consists of (A-Z,a-z,0-9,._)")
    private String firstName;

    @Column(name = "last_name")
    //@Pattern(regexp = "^[A-Za-z0-9._]{2,15}$",message = "Name should consists of (A-Z,a-z,0-9,._)")
    private String lastName;

    //@NotBlank(message = "Email should not be empty")
    //@Email(regexp = "[A-Za-z0-9!#$%&'*+-/=?^_`{|]+@[A-Za-z0-9.-]+\\.[com,org,net]{3}")
    @Column(unique = true)
    private String email;

    //@NotBlank(message = "password should not be empty")
    //@Pattern(regexp = "^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)^[^/]*$.*$",message = "password should be well formed format")
    private String password;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Role> role;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="User_Role",joinColumns =
            {
                    @JoinColumn(name="user_id",referencedColumnName = "id")
            },
            inverseJoinColumns ={
                    @JoinColumn(name="role_id",referencedColumnName = "roleId")
            }
    )
    private List<Role> roles = new ArrayList<>();

}
