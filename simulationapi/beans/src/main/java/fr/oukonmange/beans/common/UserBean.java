package fr.oukonmange.beans.common;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBean {

    @JsonProperty("id_user")
    private String id;

    @JsonProperty("nom_user")
    private String nom;

    @JsonProperty("prenom_user")
    private String prenom;

    @JsonProperty("pseudo_user")
    private String pseudo;

    @JsonProperty("password_user")
    private String password;

    @JsonProperty("id_bus")
    private String idBus;
}
