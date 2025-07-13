package ui;

import javax.swing.*;
import java.awt.*;

public class CheapShopApp extends JFrame {

    // Constructors
    public CheapShopApp() {
        new ScreenManager(this);

        setTitle("Cheap Shop Catalog Store");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(600, 450));
        setResizable(false);
        setLocationRelativeTo(null);
    }

}
