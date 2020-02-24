package fr.oukonmange.beans.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowBusBean {

    @JsonProperty("id_user")
    private String idUser;

    @JsonProperty("id_bus")
    private String idBus;
}

