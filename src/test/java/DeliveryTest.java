import enums.CargoDimensions;
import enums.WorkloadDeliveryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryTest {

    @DisplayName("Test Delivery.getCostDelivery positive min sum")
    @Test
    public void testGetCostDeliveryPositiveMinSum(){
        assertEquals(400.0, Delivery.getCostDelivery(1, CargoDimensions.SMALL, false, WorkloadDeliveryService.NORMAL));
        assertEquals(400.0, Delivery.getCostDelivery(31, CargoDimensions.SMALL, false, WorkloadDeliveryService.NORMAL));
        assertEquals(400.0, Delivery.getCostDelivery(29, CargoDimensions.BIG, false, WorkloadDeliveryService.NORMAL));
        assertEquals(400.0, Delivery.getCostDelivery(1, CargoDimensions.BIG, false, WorkloadDeliveryService.AVERAGE));
        assertEquals(400.0, Delivery.getCostDelivery(1, CargoDimensions.BIG, false, WorkloadDeliveryService.HIGH));
        assertEquals(400.0, Delivery.getCostDelivery(1, CargoDimensions.BIG, false, WorkloadDeliveryService.VERY_HIGH));
    }

    @DisplayName("Test Delivery.getCostDelivery positive")
    @Test
    public void testGetCostDeliveryPositiveDistance(){
        assertEquals(550.0, Delivery.getCostDelivery(1, CargoDimensions.BIG, true, WorkloadDeliveryService.NORMAL));
        assertEquals(480.0, Delivery.getCostDelivery(2, CargoDimensions.BIG, false, WorkloadDeliveryService.VERY_HIGH));
        assertEquals(720.0, Delivery.getCostDelivery(3, CargoDimensions.BIG, true, WorkloadDeliveryService.AVERAGE));
        assertEquals(800.0, Delivery.getCostDelivery(5, CargoDimensions.SMALL, true, WorkloadDeliveryService.VERY_HIGH));
        assertEquals(700.0, Delivery.getCostDelivery(9, CargoDimensions.SMALL, true, WorkloadDeliveryService.HIGH));
        assertEquals(420.0, Delivery.getCostDelivery(10, CargoDimensions.SMALL, false, WorkloadDeliveryService.HIGH));
        assertEquals(1120.0, Delivery.getCostDelivery(11, CargoDimensions.BIG, true, WorkloadDeliveryService.VERY_HIGH));
        assertEquals(480.0, Delivery.getCostDelivery(15, CargoDimensions.BIG, false, WorkloadDeliveryService.AVERAGE));
        assertEquals(600.0, Delivery.getCostDelivery(29, CargoDimensions.SMALL, true, WorkloadDeliveryService.NORMAL));
        assertEquals(560.0, Delivery.getCostDelivery(30, CargoDimensions.SMALL, false, WorkloadDeliveryService.HIGH));
        assertEquals(600.0, Delivery.getCostDelivery(31, CargoDimensions.BIG, false, WorkloadDeliveryService.AVERAGE));
        assertEquals(800.0, Delivery.getCostDelivery(60, CargoDimensions.BIG, false, WorkloadDeliveryService.VERY_HIGH));
    }

    @DisplayName("Test Delivery.getCostDelivery negative IllegalArgumentException")
    @Test
    public void testGetCostDeliveryNegativeIllegalArgumentException(){
        IllegalArgumentException thrownIllegal =
                assertThrows(IllegalArgumentException.class,
                        () -> Delivery.getCostDelivery(30, CargoDimensions.BIG, true, WorkloadDeliveryService.HIGH));
        assertEquals(thrownIllegal.getMessage(), "Хрупкие грузы нельзя возить на расстояние более 30 км");

        thrownIllegal =
                assertThrows(IllegalArgumentException.class,
                        () -> Delivery.getCostDelivery(-1, CargoDimensions.BIG, true, WorkloadDeliveryService.HIGH));
        assertEquals(thrownIllegal.getMessage(), "Дистанция должна быть больше 0");

        thrownIllegal =
                assertThrows(IllegalArgumentException.class,
                        () -> Delivery.getCostDelivery(0, CargoDimensions.BIG, true, WorkloadDeliveryService.HIGH));
        assertEquals(thrownIllegal.getMessage(), "Дистанция должна быть больше 0");

        thrownIllegal =
                assertThrows(IllegalArgumentException.class,
                        () -> Delivery.getCostDelivery(-10, CargoDimensions.BIG, true, WorkloadDeliveryService.HIGH));
        assertEquals(thrownIllegal.getMessage(), "Дистанция должна быть больше 0");


    }

    @DisplayName("Test Delivery.getCostDelivery negative NullPointerException")
    @Test
    public void testGetCostDeliveryNegativeNullPointerException(){
        NullPointerException thrownNull =
                assertThrows(NullPointerException.class,
                        () -> Delivery.getCostDelivery(30, null, true, WorkloadDeliveryService.HIGH));
        assertEquals(thrownNull.getMessage(), "cargoDimensions недолжен быть null");

        thrownNull =
                assertThrows(NullPointerException.class,
                        () -> Delivery.getCostDelivery(30, CargoDimensions.BIG, true, null));
        assertEquals(thrownNull.getMessage(), "workloadDeliveryService не должен быть null");

    }
}
