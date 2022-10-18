package com.reto3.reto3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String department;
    @Column(name = "year1")
    private Integer year;
    private Integer department_id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "specialty")
    @JsonIgnoreProperties("doctor")
    private  Specialty specialty;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "messages"})
    private List<Reservation> reservations;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}



