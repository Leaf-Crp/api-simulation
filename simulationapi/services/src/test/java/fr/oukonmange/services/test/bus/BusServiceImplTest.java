package fr.oukonmange.services.test.bus;


import fr.oukonmange.beans.common.BusBean;
import fr.oukonmange.data.dao.IBusRepository;
import fr.oukonmange.data.entity.Bus;
import fr.oukonmange.services.bus.impl.BusServiceImpl;
import fr.oukonmange.services.user.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doReturn;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BusServiceImpl.class})
public class BusServiceImplTest {

    @MockBean
    private IBusRepository busRepository;

    @MockBean
    private UserServiceImpl userService;

    @Autowired
    private BusServiceImpl busService;

    @Test
    public void getAllBusTest(){
        List<Bus> busList = new ArrayList<>();
        busList.add(new Bus());
        busList.add(new Bus());
        busList.add(new Bus());

        doReturn(busList).when(busRepository).findAll();

        assertEquals(3, busService.getAllBus().size());
    }

    @Test
    public void createBusTest(){
        Bus bus = new Bus();
        bus.setIdBus("1");
        bus.setTypeBus("TEST");
        bus.setNomBus("TEST");

        doReturn(bus).when(busRepository).saveAndFlush(any(Bus.class));

        BusBean busBean = busService.createBus(new BusBean());

        assertEquals(bus.getIdBus(), busBean.getIdBus());
        assertEquals(bus.getNomBus(), busBean.getNomBus());
        assertEquals(bus.getTypeBus(), busBean.getTypeBus());
    }

    @Test
    public void deleteBusTest(){
        BusBean busBean = new BusBean();
        busBean.setIdBus("1");

        Bus bus = new Bus();
        bus.setIdBus("1");

        doReturn(bus).when(busRepository).findById(anyString());

        assertEquals(Integer.valueOf(1), busService.deleteBus(busBean));
        verify(busRepository, times(1)).findById(anyString());
        verify(busRepository, times(1)).delete(any(Bus.class));

    }
}