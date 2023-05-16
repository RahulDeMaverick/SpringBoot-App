package com.example.demo.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Component
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int patientId;

    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}
