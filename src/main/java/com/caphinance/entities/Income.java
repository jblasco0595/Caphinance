package com.caphinance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "incomes")
@Getter
@Setter
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_id")
    private Long incomeId;

    private BigDecimal amount;

    @Column(name = "income_type")
    private String incomeType;

    private String description;

    private boolean recurring;

    @Column(name = "recurring_frequency")
    private String recurringFrequency;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "payment_date_income")
    private Date paymentDateIncome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
