package com.wellsfargo.counselor.entity;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @Column(nullable = false, unique = true, length = 10)
    private String ticker;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;   // Equity, Bond, ETF…

    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Holding> holdings = new HashSet<>();

    protected Security() {}

    public Security(String ticker, String name, String category) {
        this.ticker   = ticker;
        this.name     = name;
        this.category = category;
    }

    public Long getSecurityId()      { return securityId; }
    public String getTicker()        { return ticker; }
    public String getName()          { return name; }
    public String getCategory()      { return category; }
    public Set<Holding> getHoldings(){ return holdings; }

    public void setTicker(String ticker)     { this.ticker   = ticker; }
    public void setName(String name)         { this.name     = name; }
    public void setCategory(String category) { this.category = category; }
}
