package fr.simulation.api.rest;

import fr.simulation.beans.common.PanBean;
import fr.simulation.services.pan.IPanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/simulation")
public class PanController {

    @Autowired
    private IPanService panService;

    /********************** Action Pan **********************/
    @GetMapping("/pan")
    public ResponseEntity<PanBean> getAllPans() {
        return ResponseEntity.ok(panService.getAllPan());
    }

    @PostMapping("/update")
    public ResponseEntity<PanBean> getAllUsers(@RequestBody PanBean request) {
        return ResponseEntity.ok(panService.updatePan(request.getTemperature()));
    }
}
