package com.sahil.dahe.hospitalManegment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
@Builder
@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String first_name;

    @Column
    private String gender;

    @Column(unique = true, nullable = false)
    private String email;

    private LocalDate birthDate;

    @Column
    private String bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL},optional = true)
    @JoinColumn(name ="patient_insurence_id")       //if you see join column then its owning side (parent)
    private Insurence insurence;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)

    private List<Appointment> appointments= new ArrayList<>();
}
