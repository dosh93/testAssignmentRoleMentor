import enums.CargoDimensions;
import enums.WorkloadDeliveryService;

public class Main {
    public static void main(String[] args) {
        System.out.println(Delivery.getCostDelivery(2, null, true, WorkloadDeliveryService.VERY_HIGH));
    }
}
