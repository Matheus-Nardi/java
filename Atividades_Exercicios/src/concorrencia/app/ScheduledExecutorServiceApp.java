package concorrencia.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceApp {

    private static final Random random = new Random();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    
    private static double getStockPrice() {
        return 100 + (200 - 100) * random.nextDouble(); 
    }

  
    private static void displayStockPrice() {
        double price = getStockPrice();
        System.out.printf("Preço atual da ação: $%.2f%n", price);
        System.out.println("Data: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy - HH:mm:ss")));
        System.out.println("------------");
    }

    public static void main(String[] args) {
      
        scheduler.scheduleAtFixedRate(ScheduledExecutorServiceApp::displayStockPrice, 0, 5, TimeUnit.SECONDS);

       
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Monitoramento encerrado.");
        }, 60, TimeUnit.SECONDS);
    }
}
