package fr.oukonmange.beans.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BusBean {

    @JsonProperty("id_bus")
    private String idBus;

    @JsonProperty("nom_bus")
    private String nomBus;

    @JsonProperty("type_bus")
    private String typeBus;

    @JsonProperty("oukonmangeurs")
    private List<UserBean> oukonmangeurs;
}
