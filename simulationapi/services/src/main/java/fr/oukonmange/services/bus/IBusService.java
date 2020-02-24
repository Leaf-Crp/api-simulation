package fr.oukonmange.services.bus;


import fr.oukonmange.beans.common.BusBean;


import java.util.List;

public interface IBusService {

    List<BusBean> getAllBus();

    BusBean createBus(BusBean request);

    Integer deleteBus(BusBean request);
}
