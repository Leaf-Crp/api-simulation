package fr.oukonmange.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idUser;

    @Column(name = "nom_user")
    private String nomUser;

    @Column(name = "prenom_user")
    private String prenomUser;

    @Column(name = "pseudo_user")
    private String pseudoUser;

    @Column(name = "password_user")
    private String passwordUser;

    @Column(name = "id_bus")
    private String idBusUser;

    public String getIdUser() {
      return idUser;
    }

    public void setIdUser(String idUser) {
      this.idUser = idUser;
    }

    public String getNomUser() {
      return nomUser;
    }

    public void setNomUser(String nomUser) {
      this.nomUser = nomUser;
    }

    public String getPrenomUser() {
      return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
      this.prenomUser = prenomUser;
    }

    public String getPseudoUser() {
      return pseudoUser;
    }

    public void setPseudoUser(String pseudoUser) {
      this.pseudoUser = pseudoUser;
    }

    public String getPasswordUser() {
      return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
      this.passwordUser = passwordUser;
    }

    public String getIdBusUser() {
      return idBusUser;
    }

    public void setIdBusUser(String idBusUser) {
      this.idBusUser = idBusUser;
    }
}
