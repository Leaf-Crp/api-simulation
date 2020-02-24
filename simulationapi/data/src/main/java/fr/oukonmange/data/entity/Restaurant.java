package fr.oukonmange.data.entity;

import javax.persistence.*;


@Entity
@Table(name = "Restaurant")
public class Restaurant {

    @Id
    @Column(name = "id_restaurant")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idRestaurant;

    @Column(name = "nom_restaurant")
    private String nomRestaurant;

    @Column(name = "type_restaurant")
    private String typeRestaurant;

    @Column(name = "commentaire_restaurant")
    private String commentaireRestaurant;

    @Column(name = "story_restaurant")
    private String storyRestaurant;

    @Column(name = "adresse_restaurant")
    private String adresseRestaurant;

    public String getCommentaireRestaurant() {
        return commentaireRestaurant;
    }

    public void setCommentaireRestaurant(String commantaireRestaurant) {
        this.commentaireRestaurant = commantaireRestaurant;
    }

    public String getStoryRestaurant() {
        return storyRestaurant;
    }

    public void setStoryRestaurant(String storyRestaurant) {
        this.storyRestaurant = storyRestaurant;
    }

    public String getAdresseRestaurant() {
        return adresseRestaurant;
    }

    public void setAdresseRestaurant(String adresseRestaurant) {
        this.adresseRestaurant = adresseRestaurant;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant = nomRestaurant;
    }

    public String getTypeRestaurant() {
        return typeRestaurant;
    }

    public void setTypeRestaurant(String typeRestaurant) {
        this.typeRestaurant = typeRestaurant;
    }
}
