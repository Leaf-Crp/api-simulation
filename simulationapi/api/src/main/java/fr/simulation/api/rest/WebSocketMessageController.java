package fr.simulation.api.rest;

import fr.simulation.beans.response.ResultWrapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketMessageController {

    @SendTo("/global-message/tick")
    @MessageMapping("/from-client")
    public ResultWrapper<String> fromClient(String content) {
        ResultWrapper<String> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(content);
        return resultWrapper;
    }
}
