package fr.oukonmange.services.bus.impl;

import fr.oukonmange.services.adapter.BusBeanAdapter;
import fr.oukonmange.beans.common.BusBean;
import fr.oukonmange.data.dao.IBusRepository;
import fr.oukonmange.data.entity.Bus;
import fr.oukonmange.services.bus.IBusService;
import fr.oukonmange.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements IBusService {

    @Autowired
    private IBusRepository busRepository;

    @Autowired
    private IUserService userService;

    public List<BusBean> getAllBus() {
        List<Bus> busList = busRepository.findAll();
        List<BusBean> allBus = busList.stream().map(BusBeanAdapter::transform).collect(Collectors.toList());
        allBus.stream().forEach(bus -> bus.setOukonmangeurs(userService.getUserByBus(bus.getIdBus())));
        return allBus;
    }

    public BusBean createBus(BusBean request) {
        Bus createdBus = new Bus();
        createdBus.setNomBus(request.getNomBus());
        createdBus.setTypeBus(request.getTypeBus());
        return BusBeanAdapter.transform(busRepository.saveAndFlush(createdBus));
    }

    public Integer deleteBus(BusBean request) {
        Bus deleteBus = busRepository.findById(request.getIdBus());
        busRepository.delete(deleteBus);
        return Integer.valueOf(1);
    }
}
