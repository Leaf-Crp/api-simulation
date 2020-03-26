package fr.simulation.beans.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PanBean {

    @JsonProperty("id_pus")
    private String idPan;

    @JsonProperty("temperature")
    private String temperature;
}
