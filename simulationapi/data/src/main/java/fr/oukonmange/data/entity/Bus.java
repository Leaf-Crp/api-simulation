package fr.oukonmange.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Bus")
public class Bus {
    @Id
    @Column(name = "id_bus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idBus;

    @Column(name = "nom_bus")
    private String nomBus;

    @Column(name = "type_bus")
    private String typeBus;

    public String getIdBus() {
        return idBus;
    }

    public void setIdBus(String idBus) {
        this.idBus = idBus;
    }

    public String getNomBus() {
        return nomBus;
    }

    public void setNomBus(String nomBus) {
        this.nomBus = nomBus;
    }

    public String getTypeBus() {
        return typeBus;
    }

    public void setTypeBus(String typeBus) {
        this.typeBus = typeBus;
    }
}
