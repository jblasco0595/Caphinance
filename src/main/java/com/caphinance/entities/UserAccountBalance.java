package com.caphinance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_account_balances")
@Getter
@Setter
public class UserAccountBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_id")
    private Long balanceId;

    private String currency;

    @Column(name = "account_type")
    private String accountType;

    private String account;

    @Column(name = "available_balance")
    private Double availableBalance;

    @Column(name = "pending_balance")
    private Double pendingBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
