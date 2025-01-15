package fr.hb.assurance.model;

import jakarta.validation.constraints.NotBlank;

public class Contrat {
    private int id;
    private int clientId;
    private String voitureImmatriculation;
    @NotBlank
    private String dateDebut;
    @NotBlank
    private String dateFin;
    private double prixTotal;
    private String etat;

    public Contrat() {}

    public Contrat(int id, int clientId, String voitureImmatriculation, String dateDebut, String dateFin, double prixTotal, String etat) {
        this.id = id;
        this.clientId = clientId;
        this.voitureImmatriculation = voitureImmatriculation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
        this.etat = etat;
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
     * @return int return the clientId
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * @return String return the voitureImmatriculation
     */
    public String getVoitureImmatriculation() {
        return voitureImmatriculation;
    }

    /**
     * @param voitureImmatriculation the voitureImmatriculation to set
     */
    public void setVoitureImmatriculation(String voitureImmatriculation) {
        this.voitureImmatriculation = voitureImmatriculation;
    }

    /**
     * @return String return the dateDebut
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return String return the dateFin
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return double return the prixTotal
     */
    public double getPrixTotal() {
        return prixTotal;
    }

    /**
     * @param prixTotal the prixTotal to set
     */
    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    /**
     * @return String return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

}
