package com.example.Project_3.entities.role;

import com.example.Project_3.entities.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id ", nullable = false , unique = true)
    private Long id ;
     @Column(name = "code")
    private String code;
     @Column(name = "name")
    private String name;
     @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>() ;

}
