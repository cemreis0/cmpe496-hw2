package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderFileWriter {

    // Other Methods
    public static void writeToFile(String content, String timestamp) {
        try {
            File dir = new File("orders");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, "order_" + timestamp + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
            }

            System.out.println("Order saved: " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
