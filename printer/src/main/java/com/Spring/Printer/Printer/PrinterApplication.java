package com.Spring.Printer.Printer;
import com.Spring.Printer.Printer.Gui.Frame;
import com.Spring.Printer.Printer.Gui.Frontend;
import com.Spring.Printer.Printer.HealthService.HealthService;
import com.Spring.Printer.Printer.StarterService.StarterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@SpringBootApplication
public class PrinterApplication {
	public static boolean healthSituation = true;
	public static int numOfPlanes = 0;
	public static int numOfHumans = 0;
	public static int numOfCars = 0;
	static com.Spring.Printer.Printer.Gui.Frame frame;

	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ApplicationContext apc = SpringApplication.run(PrinterApplication.class, args);
		StarterService ss = apc.getBean(StarterService.class);
		HealthService hs = apc.getBean(HealthService.class);
		HealthService healthService = new HealthService();
		while (true) {
			TimeUnit.SECONDS.sleep(1);
			if (!healthService.isIsReceivedCarDetector() || !healthService.isIsReceivedHumanDetector() || !healthService.isIsReceivedPlaneDetector() || !healthService.isIsReceivedCarPy()) {
				System.out.println("There is a problem in the system!");
				healthSituation = false;
				frame.healthButton.setBackground(new Color(255,51,51));
				frame.healthButton.setText("System off!");
				continue;
			} else{
				healthSituation = true;
				frame.healthButton.setBackground(new Color(153,255,153));
				frame.healthButton.setText("System on!");
			}
			healthService.setIsReceivedPlaneDetector(false);
			healthService.setIsReceivedHumanDetector(false);
			healthService.setIsReceivedCarDetector(false);
			healthService.setIsReceivedCarPy(false);
		}
	}
		@Bean
		public Consumer<String> planeBean () {
			return in -> {
				System.out.println(in);
				numOfPlanes = Integer.parseInt(in);
				if(numOfPlanes == 0) {
					System.out.println(" kuömcuygs hntrjmtrnhsth");
					frame.setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\radar.png", frame.planepicsLabel);;
				}
				else {
					try {
						TimeUnit.SECONDS.sleep(3);
						frame.setImage("C:\\Users\\stj.emaslan\\Desktop\\AeroplaneDetected\\aeroplaneDetected.jpg", frame.planepicsLabel);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}



			};
		}
	@Bean
	public Consumer<String> carBean () {
		return in -> {
			System.out.println(in);
			numOfCars = Integer.valueOf(in);
			if(numOfCars == 0) {
				frame.setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\car.png", frame.carpicsLabel);
			}
			else {
				try {
					TimeUnit.SECONDS.sleep(3);
					frame.setImage("C:\\Users\\stj.emaslan\\Desktop\\CarsDetected\\carDetected.jpg", frame.carpicsLabel);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

		};
	}
	@Bean
	public Consumer<String> humanBean () {
		return in -> {
			System.out.println(in);
			numOfHumans = Integer.valueOf(in);
			if(numOfHumans == 0) {
				frame.setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\body-scan.png", frame.humanpicsLabel);
			}
			else {
				try {
					TimeUnit.SECONDS.sleep(3);
					frame.setImage("C:\\Users\\stj.emaslan\\Desktop\\PersonDetected\\personDetected.jpg", frame.humanpicsLabel);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}


		};
	}



}