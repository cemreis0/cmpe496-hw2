package ui.panels;

import model.CatalogItem;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogItemPanel extends JPanel {

    // Data Members
    private JTextField numberField;
    private JSpinner quantitySpinner;
    private JTextField costPerItemField;
    private JTextField totalField;

    // Constructors
    public CatalogItemPanel() {
        setBorder(BorderFactory.createTitledBorder("Catalog Menu Item"));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(4, 4, 4, 4);

        // Row 1
        addLabel("Number:", 0, 0, 1, gbc);
        numberField = addField(1, 0, 1, gbc);
        addLabel("Quantity:", 2, 0, 1, gbc);
        quantitySpinner = addSpinner(3, 0, 1, gbc);
        addLabel("Cost/Item", 4, 0, 1, gbc);
        costPerItemField = addField(5, 0, 1, gbc);
        addLabel("Total", 6, 0, 1, gbc);
        totalField = addField(7, 0, 1, gbc);
        totalField.setEditable(false);

        // Listeners to update the Total field
        quantitySpinner.addChangeListener(e -> updateTotal());
        costPerItemField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { updateTotal(); }
            public void removeUpdate(DocumentEvent e) { updateTotal(); }
            public void changedUpdate(DocumentEvent e) { updateTotal(); }
        });

        updateTotal();
    }

    // Other Methods
    private void addLabel(String text, int x, int y, int width, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        JLabel label = new JLabel(text, JLabel.RIGHT);
        add(label, gbc);
    }

    private JTextField addField(int x, int y, int width, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField field = new JTextField(15);
        add(field, gbc);
        return field;
    }

    private JSpinner addSpinner(int x, int y, int width, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        SpinnerNumberModel model = new SpinnerNumberModel(1, 0, 1000, 1);
        JSpinner spinner = new JSpinner(model);
        add(spinner, gbc);
        return spinner;
    }

    private void updateTotal() {
        try {
            int quantity = (Integer) quantitySpinner.getValue();
            double costNum = Double.parseDouble(costPerItemField.getText());
            double total = quantity * costNum;
            totalField.setText(String.format("%.2f", total));
        } catch (Exception e) {
            totalField.setText("0.00");
        }
    }

    public CatalogItem getCatalogItem() {
        CatalogItem item = new CatalogItem();
        item.setNumber(numberField.getText().trim());
        item.setQuantity((Integer) quantitySpinner.getValue());
        try {
            item.setCostPerItem(Double.parseDouble(costPerItemField.getText().trim()));
        } catch (NumberFormatException e) {
            item.setCostPerItem(0.0);
        }
        return item;
    }

    public List<String> validateFields() {
        List<String> errors = new ArrayList<>();

        if (numberField.getText().trim().isEmpty()) {
            errors.add("Number field cannot be empty.");
        }
        if (costPerItemField.getText().trim().isEmpty()) {
            errors.add("Cost per item field cannot be empty.");
        } else {
            try {
                Double.parseDouble(costPerItemField.getText().trim());
            } catch (NumberFormatException e) {
                errors.add("Cost per item must be a number.");
            }
        }
        return errors;
    }

}
