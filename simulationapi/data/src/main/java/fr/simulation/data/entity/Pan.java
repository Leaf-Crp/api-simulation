package fr.simulation.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Pan")
public class Pan {
    @Id
    @Column(name = "id_pan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idPan;

    @Column(name = "temperature")
    private String temperature;

    public String getIdPan() {
        return idPan;
    }

    public void setIdPan(String idPan) {
        this.idPan = idPan;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
