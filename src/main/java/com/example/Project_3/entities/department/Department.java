package com.example.Project_3.entities.department;

import com.example.Project_3.entities.requestReceipt.RequestReceipt;
import com.example.Project_3.entities.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id" , nullable = false , unique = true)
     @NotNull
     private Long id ;
     @Column(name = "name" , nullable = false)
     @NotNull
     private String name ;
     @Column(name = "phone_number")
     private String phoneNumber;
     @Column(name = "code" ,nullable = false , unique = true)
     @NotNull
     private String code;
     @Column(name = "address")
     private String address;
     @Column(name = "email")
     private String email;
     @OneToMany(fetch = FetchType.EAGER,mappedBy = "department")
     private Set<User> users = new HashSet<>();
}
