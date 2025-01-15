package fr.hb.assurance.model;

import jakarta.validation.constraints.NotBlank;

public class Voiture {
    private int id;
    @NotBlank
    private String immatriculation;
    @NotBlank
    private String modele;
    @NotBlank
    private String marque;
    @NotBlank
    private String categorie;
    @NotBlank
    private String statut;

    public Voiture() {}

    public Voiture(int id, String immatriculation, String modele, String marque, String categorie, String statut) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.marque = marque;
        this.categorie = categorie;
        this.statut = statut;
    }

    // Getters et Setters (générés automatiquement dans ton IDE)

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
     * @return String return the immatriculation
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * @param immatriculation the immatriculation to set
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    /**
     * @return String return the modele
     */
    public String getModele() {
        return modele;
    }

    /**
     * @param modele the modele to set
     */
    public void setModele(String modele) {
        this.modele = modele;
    }

    /**
     * @return String return the marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return String return the categorie
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * @return String return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

}
