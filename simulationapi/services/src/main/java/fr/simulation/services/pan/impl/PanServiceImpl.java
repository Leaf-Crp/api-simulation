package fr.simulation.services.pan.impl;


import fr.simulation.beans.common.PanBean;
import fr.simulation.data.dao.IPanRepository;
import fr.simulation.data.entity.Pan;
import fr.simulation.services.adapter.PanBeanAdapter;
import fr.simulation.services.pan.IPanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PanServiceImpl implements IPanService {

    @Autowired
    private IPanRepository panRepository;

    public List<PanBean> getAllPan() {
        List<Pan> panList = panRepository.findAll();
        List<PanBean> allPan = panList.stream().map(PanBeanAdapter::transform).collect(Collectors.toList());
        return allPan;
    }
}
