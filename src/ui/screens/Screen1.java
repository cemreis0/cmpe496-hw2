package ui.screens;

import ui.panels.ActionPanel;
import ui.panels.CatalogItemPanel;
import ui.panels.PurchaserPanel;

import javax.swing.*;
import java.awt.*;

public class Screen1 extends JPanel {

    // Data Members
    private PurchaserPanel purchaserPanel;
    private CatalogItemPanel catalogItemPanel;
    private ActionPanel actionPanel;

    // Constructors
    public Screen1() {
        setLayout(new BorderLayout());

        // Top note
        JLabel note = new JLabel("Cem Reis, Screen 1", SwingConstants.RIGHT);
        note.setFont(new Font("Arial", Font.ITALIC, 12));
        note.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        add(note, BorderLayout.NORTH);

        // Purchaser panel
        purchaserPanel = new PurchaserPanel();
        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        centerWrapper.add(purchaserPanel, BorderLayout.CENTER);
        add(centerWrapper, BorderLayout.CENTER);

        // Catalog + Action
        catalogItemPanel = new CatalogItemPanel();
        actionPanel = new ActionPanel();

        JPanel bottomWrapper = new JPanel(new BorderLayout());
        bottomWrapper.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        bottomWrapper.add(catalogItemPanel, BorderLayout.CENTER);
        bottomWrapper.add(actionPanel, BorderLayout.SOUTH);
        add(bottomWrapper, BorderLayout.SOUTH);
    }

    // Getters
    public PurchaserPanel getPurchaserPanel() {
        return purchaserPanel;
    }

    public CatalogItemPanel getCatalogItemPanel() {
        return catalogItemPanel;
    }

    public ActionPanel getActionPanel() {
        return actionPanel;
    }
}
