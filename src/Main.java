import ui.CheapShopApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CheapShopApp app = new CheapShopApp();

            app.setVisible(true);
        });
    }
}
