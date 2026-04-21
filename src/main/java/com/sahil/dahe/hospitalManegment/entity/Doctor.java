package com.sahil.dahe.hospitalManegment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;

    @Column(length = 100)
    private String spacialization;

    @Column(nullable = false,unique = true, length = 100)
    private String email;


    @ManyToMany(mappedBy="doctors")
    private Set<Department> departments = new HashSet<>();

    @OneToMany(mappedBy = "doctor")//when we use mapped by
    private List<Appointment> appointments= new ArrayList<>();//why we write it that new arry
}
