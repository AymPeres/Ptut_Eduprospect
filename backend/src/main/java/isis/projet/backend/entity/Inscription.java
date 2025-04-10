package isis.projet.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String formation;

    @Column(nullable = false)
    private String ville;

    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String sexe;

    @Column(nullable = false)
    private String statut;

    @Column(nullable = false)
    private String interet;

    @Column(name = "origine_contact", nullable = false)
    private String origineContact;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    private Salon salon;

    public Inscription() {
    }

    public Inscription(String nom, String prenom, String formation, String ville, String codePostal,
                       String email, String telephone, String sexe, String statut, String interet,
                       String origineContact, Salon salon) {
        this.nom = nom;
        this.prenom = prenom;
        this.formation = formation;
        this.ville = ville;
        this.codePostal = codePostal;
        this.email = email;
        this.telephone = telephone;
        this.sexe = sexe;
        this.statut = statut;
        this.interet = interet;
        this.origineContact = origineContact;
        this.salon = salon;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getInteret() {
        return interet;
    }

    public void setInteret(String interet) {
        this.interet = interet;
    }

    public String getOrigineContact() {
        return origineContact;
    }

    public void setOrigineContact(String origineContact) {
        this.origineContact = origineContact;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
