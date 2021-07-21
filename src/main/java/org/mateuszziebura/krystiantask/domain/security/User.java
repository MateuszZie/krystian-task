package org.mateuszziebura.krystiantask.domain.security;


import lombok.*;
import org.mateuszziebura.krystiantask.domain.History;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {

    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private boolean logged;
    private Timestamp loginIn;
    private Timestamp loginOut;
}
