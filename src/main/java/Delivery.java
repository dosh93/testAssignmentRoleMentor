import enums.CargoDimensions;
import enums.WorkloadDeliveryService;

public class Delivery {


    public static double getCostDelivery(
            int distance,
            CargoDimensions cargoDimensions,
            boolean isFragile,
            WorkloadDeliveryService workloadDeliveryService
    ){
        double minSum = 400;
        double result = 0;

        if(cargoDimensions == null) throw new NullPointerException("cargoDimensions недолжен быть null");
        if(workloadDeliveryService == null) throw new NullPointerException("workloadDeliveryService не должен быть null");
        if(isFragile && distance >= 30) throw new IllegalArgumentException("Хрупкие грузы нельзя возить на расстояние более 30 км");
        if(distance <= 0) throw new IllegalArgumentException("Дистанция должна быть больше 0");

        if (distance < 2) result += 50;
        else if(distance < 10) result += 100;
        else if(distance < 30) result += 200;
        else result += 300;

        switch (cargoDimensions){
            case BIG:
                result += 200;
                break;
            case SMALL:
                result += 100;
                break;
        }

        if(isFragile) result += 300;

        switch (workloadDeliveryService){
            case VERY_HIGH:
                result *= 1.6;
                break;
            case HIGH:
                result *= 1.4;
                break;
            case AVERAGE:
                result *= 1.2;
                break;
        }

        return Math.max(result, minSum);

    }
}
