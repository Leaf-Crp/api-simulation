package fr.oukonmange.beans.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBean {

    @JsonProperty("pseudo")
    private String pseudo;

    @JsonProperty("password")
    private String password;

}
