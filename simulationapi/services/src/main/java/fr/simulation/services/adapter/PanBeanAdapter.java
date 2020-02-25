package fr.simulation.services.adapter;


import fr.simulation.beans.common.PanBean;
import fr.simulation.data.entity.Pan;

public class PanBeanAdapter {

    private PanBeanAdapter() {
        throw new IllegalStateException("Utility class");
    }

    public static PanBean transform(Pan pan){
        PanBean panBean = new PanBean();
        panBean.setIdPan(pan.getIdPan());
        panBean.setTemperature(pan.getTemperature());
        return panBean;
    }
}
