package com.sahil.dahe.hospitalManegment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true,nullable=false,length=100)
    private String name;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(
            name = "my_dpt-doctors",
            joinColumns = @JoinColumn(name = "dpt_id")//for cahnging that join jolumn name
            , inverseJoinColumns = @JoinColumn(name = "doctor_id")  //for changing other column which is not join
    )
    private Set<Doctor> doctors = new HashSet<>();// = new HashSet<>() means for not null for hibernate

}
