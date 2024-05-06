package org.getarrayz.understandingjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.getarrayz.understandingjpa.dto.enumeration.Gender;

import java.util.List;
import java.util.Set;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "user-id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_interests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<InterestEntity> interests;

}
