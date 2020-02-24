package fr.oukonmange.services.adapter;


import fr.oukonmange.beans.common.BusBean;
import fr.oukonmange.data.entity.Bus;

public class BusBeanAdapter {

    private BusBeanAdapter() {
        throw new IllegalStateException("Utility class");
    }

    public static BusBean transform(Bus bus){
        BusBean busBean = new BusBean();
        busBean.setIdBus(bus.getIdBus());
        busBean.setNomBus(bus.getNomBus());
        busBean.setTypeBus(bus.getTypeBus());
        return busBean;
    }
}
