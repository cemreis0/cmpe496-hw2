package ui.screens;

import ui.panels.ActionPanel;
import ui.panels.CatalogItemPanel;

import javax.swing.*;
import java.awt.*;

public class Screen2 extends JPanel {

    // Data Members
    private CatalogItemPanel catalogItemPanel;
    private ActionPanel actionPanel;

    // Constructors
    public Screen2() {
        setLayout(new BorderLayout());

        // Top note
        JLabel note = new JLabel("Cem Reis, Screen 2", SwingConstants.RIGHT);
        note.setFont(new Font("Arial", Font.ITALIC, 12));
        note.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        add(note, BorderLayout.NORTH);

        // Catalog Item panel inside BorderLayout wrapper to expand properly
        catalogItemPanel = new CatalogItemPanel();
        JPanel centerWrapper = new JPanel(new BorderLayout());  // changed here
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        centerWrapper.add(catalogItemPanel, BorderLayout.CENTER);
        add(centerWrapper, BorderLayout.CENTER);

        // Action panel inside bottom wrapper - add to CENTER to be visible
        actionPanel = new ActionPanel();
        JPanel bottomWrapper = new JPanel(new BorderLayout());
        bottomWrapper.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        bottomWrapper.add(actionPanel, BorderLayout.CENTER);  // changed from SOUTH to CENTER
        add(bottomWrapper, BorderLayout.SOUTH);
    }


    // Getters
    public CatalogItemPanel getCatalogItemPanel() {
        return catalogItemPanel;
    }

    public ActionPanel getActionPanel() {
        return actionPanel;
    }
}
