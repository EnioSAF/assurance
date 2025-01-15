package fr.hb.assurance.model;

import jakarta.validation.constraints.NotBlank;

public class Client {
    private int id;
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotBlank
    private String email;
    private String permis;
    private String genre;
    private boolean bloque;

    public Client() {}

    public Client(int id, String nom, String prenom, String email, String permis, String genre, boolean bloque) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.permis = permis;
        this.genre = genre;
        this.bloque = bloque;
    }

    // Getters et Setters

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the permis
     */
    public String getPermis() {
        return permis;
    }

    /**
     * @param permis the permis to set
     */
    public void setPermis(String permis) {
        this.permis = permis;
    }

    /**
     * @return String return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return boolean return the bloque
     */
    public boolean isBloque() {
        return bloque;
    }

    /**
     * @param bloque the bloque to set
     */
    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

}
