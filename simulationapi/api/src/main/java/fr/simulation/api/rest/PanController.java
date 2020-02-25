package fr.simulation.api.rest;

import fr.simulation.beans.common.PanBean;
import fr.simulation.data.dao.IPanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pan")
public class PanController {

    @Autowired
    private IPanRepository panRepository;

    /********************** Action Pan **********************/
    @GetMapping("/users")
    public ResponseEntity<List<PanBean>> getAllUsers() {
//        List<PanBean> pans = PanBeanAdapter.transform(panRepository.findAll());
return ResponseEntity.ok(new ArrayList<>());
    }
}
