package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;



@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String email;
    private String phone;

    @Column(nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Portfolio> portfolios = new HashSet<>();

    protected Client() {}

    public Client(Advisor advisor, String firstName, String lastName,
                  String email, String phone) {
        this.advisor    = advisor;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.phone      = phone;
    }

    public Long getClientId()           { return clientId; }
    public Advisor getAdvisor()         { return advisor; }
    public String getFirstName()        { return firstName; }
    public String getLastName()         { return lastName; }
    public String getEmail()            { return email; }
    public String getPhone()            { return phone; }
    public OffsetDateTime getCreatedAt(){ return createdAt; }
    public Set<Portfolio> getPortfolios(){ return portfolios; }

    public void setAdvisor(Advisor advisor)     { this.advisor   = advisor; }
    public void setFirstName(String firstName)  { this.firstName = firstName; }
    public void setLastName(String lastName)    { this.lastName  = lastName; }
    public void setEmail(String email)          { this.email     = email; }
    public void setPhone(String phone)          { this.phone     = phone; }

}
