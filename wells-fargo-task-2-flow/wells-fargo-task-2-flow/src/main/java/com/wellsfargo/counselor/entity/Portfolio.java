package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Holding> holdings = new HashSet<>();

    protected Portfolio() {}

    public Portfolio(Client client, String name) {
        this.client = client;
        this.name   = name;
    }

    public Long getPortfolioId()            { return portfolioId; }
    public Client getClient()               { return client; }
    public String getName()                 { return name; }
    public OffsetDateTime getCreatedAt()    { return createdAt; }
    public Set<Holding> getHoldings()       { return holdings; }

    /* ---------- Setters ---------- */
    public void setClient(Client client) { this.client = client; }
    public void setName(String name)     { this.name   = name; }

}
