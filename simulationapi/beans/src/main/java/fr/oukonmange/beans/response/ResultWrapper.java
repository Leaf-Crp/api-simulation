package fr.oukonmange.beans.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultWrapper<T> {

    private T payload;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
