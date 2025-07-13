package ui.panels;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {

    // Data Members
    private JTextField balanceField;
    private JButton nextCatalogItemButton;
    private JButton triggerInvoiceButton;

    // Constructor
    public ActionPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.gridy = 0;

        // Row 1
        addLabel("Balance Owing:", 0, 0, 1, gbc);
        balanceField = addField(1, 0, 1, gbc);
        balanceField.setEditable(false);

        // Spacer
        gbc.gridx = 2;
        gbc.weightx = 1.0;
        add(Box.createHorizontalGlue(), gbc);

        nextCatalogItemButton = addButton("Next Catalog Item (PF8)", 3, 0, 1, gbc);
        triggerInvoiceButton = addButton("Trigger Invoice (PF5)", 4, 0, 1, gbc);
    }

    // Other Methods
    private void addLabel(String text, int x, int y, int width, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel(text, JLabel.RIGHT), gbc);
    }

    private JTextField addField(int x, int y, int width, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField field = new JTextField(10);
        add(field, gbc);
        return field;
    }

    private JButton addButton(String text, int x, int y, int width, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        JButton button = new JButton(text);
        add(button, gbc);
        return button;
    }

    // Public Accessors and Actions
    public void updateBalance(double value) {
        balanceField.setText(String.format("%.2f", value));
    }

    public double getBalance() {
        try {
            return Double.parseDouble(balanceField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public void resetBalance() {
        balanceField.setText("0.00");
    }

    public JButton getNextCatalogItemButton() {
        return nextCatalogItemButton;
    }

    public JButton getTriggerInvoiceButton() {
        return triggerInvoiceButton;
    }
}
