package com.caphinance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String email;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserProfile profile;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserCredential credential;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserAccountBalance> accountBalances;

    @OneToMany(mappedBy = "user1", fetch = FetchType.LAZY)
    private List<Friendship> friendships1;

    @OneToMany(mappedBy = "user2", fetch = FetchType.LAZY)
    private List<Friendship> friendships2;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Income> incomes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Expense> expenses;

    @OneToMany(mappedBy = "debtor", fetch = FetchType.LAZY)
    private List<Debt> debtsAsDebtor;

    @OneToMany(mappedBy = "creditor", fetch = FetchType.LAZY)
    private List<Debt> debtsAsCreditor;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Group> createdGroups;
}
