package fr.oukonmange.api.rest;

import fr.oukonmange.beans.common.BusBean;
import fr.oukonmange.beans.response.ResultWrapper;
import fr.oukonmange.services.bus.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebSocketMessageController {

    @Autowired
    private IBusService busService;

    @SendTo("/global-message/tick")
    @MessageMapping("/from-client")
    public ResultWrapper<List<BusBean>> fromClient(String content) {
        ResultWrapper<List<BusBean>> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(busService.getAllBus());
        return resultWrapper;
    }
}
