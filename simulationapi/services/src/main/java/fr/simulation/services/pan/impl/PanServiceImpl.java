package fr.simulation.services.pan.impl;


import fr.simulation.beans.common.PanBean;
import fr.simulation.data.dao.IPanRepository;
import fr.simulation.data.entity.Pan;
import fr.simulation.services.adapter.PanBeanAdapter;
import fr.simulation.services.pan.IPanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PanServiceImpl implements IPanService {

    @Autowired
    private IPanRepository panRepository;

    public PanBean getAllPan() {
        return PanBeanAdapter.transform(panRepository.findAll().get(0));
    }

    public PanBean updatePan(String temperature) {
        Pan pan = panRepository.findAll().get(0);
        pan.setTemperature(temperature);
        return PanBeanAdapter.transform(panRepository.save(pan));
    }
}
