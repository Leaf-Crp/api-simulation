package fr.oukonmange.beans.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantBean {
    @JsonProperty("id_restaurant")
    private String idRestaurant;

    @JsonProperty("nom_restaurant")
    private String nameRestaurant;

    @JsonProperty("type_restaurant")
    private String typeRestaurant;

    @JsonProperty("commentaire_restaurant")
    private String commentaireRestaurant;

    @JsonProperty("story_restaurant")
    private String storyRestaurant;

    @JsonProperty("adresse_restaurant")
    private String adresseRestaurant;
}
