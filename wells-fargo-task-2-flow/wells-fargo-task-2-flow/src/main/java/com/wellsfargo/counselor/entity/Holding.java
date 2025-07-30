package com.wellsfargo.counselor.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long holdingId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "security_id")
    private Security security;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false, precision = 12, scale = 2)
    private Double purchasePrice;

    @Column(nullable = false, precision = 18, scale = 6)
    private Double quantity;

    protected Holding() {}

    public Holding(Portfolio portfolio,
                   Security security,
                   LocalDate purchaseDate,
                   Double purchasePrice,
                   Double quantity) {
        this.portfolio     = portfolio;
        this.security      = security;
        this.purchaseDate  = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity      = quantity;
    }

    public Long getHoldingId()        { return holdingId; }
    public Portfolio getPortfolio()   { return portfolio; }
    public Security getSecurity()     { return security; }
    public LocalDate getPurchaseDate(){ return purchaseDate; }
    public Double getPurchasePrice()  { return purchasePrice; }
    public Double getQuantity()       { return quantity; }

    public void setPortfolio(Portfolio portfolio)   { this.portfolio    = portfolio; }
    public void setSecurity(Security security)      { this.security     = security; }
    public void setPurchaseDate(LocalDate date)     { this.purchaseDate = date; }
    public void setPurchasePrice(Double price)      { this.purchasePrice= price; }
    public void setQuantity(Double quantity)        { this.quantity     = quantity; }
}
