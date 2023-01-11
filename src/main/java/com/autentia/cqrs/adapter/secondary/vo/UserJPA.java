package com.autentia.cqrs.adapter.secondary.vo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "`user`")
@NoArgsConstructor
public class UserJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
    private Long id;
    private String nif;
    private String name;
    private String surname;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
    private Set<AddressJPA> addresses;

    public UserJPA(String nif, String name, String surname, String email, Set<AddressJPA> addresses) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.addresses = addresses;
    }
}
