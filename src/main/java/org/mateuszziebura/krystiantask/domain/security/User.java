package org.mateuszziebura.krystiantask.domain.security;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean logged;
    private Timestamp loginIn;
    private Timestamp loginOut;

    @Singular
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "User_Authority", joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID",referencedColumnName = "ID")})
    private  Set<Authority> authorities;

    @Builder.Default
    private  boolean accountNonExpired =true;
    @Builder.Default
    private  boolean accountNonLocked =true;
    @Builder.Default
    private  boolean credentialsNonExpired =true;
    @Builder.Default
    private  boolean enabled =true;


}
