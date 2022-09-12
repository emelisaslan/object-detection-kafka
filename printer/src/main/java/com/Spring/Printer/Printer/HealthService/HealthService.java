package com.Spring.Printer.Printer.HealthService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.function.Consumer;

@Service
public class HealthService {
    private static boolean isReceivedPlaneDetector = false;
    private static boolean isReceivedHumanDetector = false;
    private static boolean isReceivedCarDetector = false;
    private static boolean isReceivedStarter = false;
    private static boolean isReceivedCarPy = false;
    @Bean
    public Consumer<String> heartBeats() {
        return heartBeat -> {
            if (heartBeat.equals("Starter")) {
                isReceivedStarter = true;
            }
            if (heartBeat.equals("CarDetector")) {
                isReceivedCarDetector = true;
            }
            if (heartBeat.equals("HumanDetector")) {
                isReceivedHumanDetector = true;
            }
            if (heartBeat.equals("PlaneDetector")) {
                isReceivedPlaneDetector= true;
            }

            if (heartBeat.equals("carPy")) {
                isReceivedCarPy= true;
            }
        };
    }

    public static boolean isIsReceivedPlaneDetector() {
        return isReceivedPlaneDetector;
    }

    public static void setIsReceivedPlaneDetector(boolean isReceivedPlaneDetector) {
        HealthService.isReceivedPlaneDetector = isReceivedPlaneDetector;
    }

    public static boolean isIsReceivedHumanDetector() {
        return isReceivedHumanDetector;
    }

    public static void setIsReceivedHumanDetector(boolean isReceivedHumanDetector) {
        HealthService.isReceivedHumanDetector = isReceivedHumanDetector;
    }

    public static boolean isIsReceivedCarDetector() {
        return isReceivedCarDetector;
    }

    public static void setIsReceivedCarDetector(boolean isReceivedCarDetector) {
        HealthService.isReceivedCarDetector = isReceivedCarDetector;
    }

    public static boolean isIsReceivedStarter() {
        return isReceivedStarter;
    }

    public static void setIsReceivedStarter(boolean isReceivedStarter) {
        HealthService.isReceivedStarter = isReceivedStarter;
    }

    public static boolean isIsReceivedCarPy() {
        return isReceivedCarPy;
    }

    public static void setIsReceivedCarPy(boolean isReceivedCarPy) {
        HealthService.isReceivedCarPy = isReceivedCarPy;
    }
}


