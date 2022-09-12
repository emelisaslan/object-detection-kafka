package com.Spring.Printer.Printer.StarterService;
import com.Spring.Printer.Printer.Gui.Frame;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
@Service
public class StarterService{
        private static String imagePath = "";

        @Bean
        public Supplier<String> imagePathSupplier(){
        return () -> {
            imagePath = "";
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                askForImagePath();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Supplier " + imagePath);

            return imagePath;
        };
    }

        public void askForImagePath() throws InterruptedException {
        System.out.println("ima " + imagePath);
        while(imagePath == ""){
            imagePath = Frame.path;
        }

    }

        public String getImagePath() {
        return imagePath;
    }

        public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}


