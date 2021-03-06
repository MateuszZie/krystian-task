package org.mateuszziebura.krystiantask.domain.security;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String role;

    @Singular
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;
}
