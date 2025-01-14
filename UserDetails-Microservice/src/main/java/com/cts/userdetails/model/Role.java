package com.cts.userdetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Role{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    private String name;

}
