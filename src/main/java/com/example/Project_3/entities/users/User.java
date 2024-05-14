package com.example.Project_3.entities.users;

import com.example.Project_3.entities.department.Department;
import com.example.Project_3.entities.importReceipt.ImportReceipt;
import com.example.Project_3.entities.requestReceipt.RequestReceipt;
import com.example.Project_3.entities.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , unique = true , nullable = false)
    private Long id ;
    @Column(name = "code" , unique = true , nullable = false)
    private String code;
    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;
    @Column(name = "identity_type",nullable = false)
    private Integer identityType ;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String userName ;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private Integer status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id",insertable = true , updatable = true)
    private Department department;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users-roles",
    joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "role_id",referencedColumnName = "id")
    })
    private Set<Role> roles = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private Set<ImportReceipt> importReceipts = new HashSet<>() ;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private Set<RequestReceipt> requestReceipts = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        roles.forEach(i ->authorities.add(new SimpleGrantedAuthority(i.getCode())));
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
