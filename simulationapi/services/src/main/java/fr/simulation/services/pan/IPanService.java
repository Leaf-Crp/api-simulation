package fr.simulation.services.pan;


import fr.simulation.beans.common.PanBean;

public interface IPanService {

    PanBean getAllPan();
    PanBean updatePan(String temperature);
}
