package ui.panels;

import model.Purchaser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaserPanel extends JPanel {

    // Data Members
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField postalCodeField;
    private JTextField provinceField;
    private JTextField cityField;
    private JTextField deliveryAddressField;
    private JTextField todaysDateField;
    private JTextField creditCardNoField;
    private JTextField validationIdField;

    private Purchaser purchaser;

    // Constructors
    public PurchaserPanel() {
        purchaser = new Purchaser();

        setBorder(BorderFactory.createTitledBorder("Purchaser"));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(4, 4, 4, 4);

        int y = 0;

        // Row 1
        addLabel("Name:", 0, y, 1, gbc);
        nameField = addField(1, y, 1, gbc);
        addLabel("Phone:", 2, y, 1, gbc);
        phoneField = addField(3, y++, 1, gbc);

        // Row 2
        addLabel("Postal Code:", 0, y, 1, gbc);
        postalCodeField = addField(1, y, 1, gbc);
        addLabel("Province:", 2, y, 1, gbc);
        provinceField = addField(3, y, 1, gbc);
        addLabel("City:", 4, y, 1, gbc);
        cityField = addField(5, y++, 1, gbc);

        // Row 3
        addLabel("Delivery Address:", 0, y, 1, gbc);
        deliveryAddressField = addField(1, y++, 5, gbc); // spans full row

        // Row 4
        addLabel("Today's Date:", 0, y, 1, gbc);
        todaysDateField = addField(1, y++, 1, gbc);

        // Row 5
        addLabel("Credit Card No:", 0, y, 1, gbc);
        creditCardNoField = addField(1, y, 1, gbc);
        addLabel("For Dept. Use, Validation ID:", 2, y, 1, gbc);
        validationIdField = addField(3, y++, 1, gbc);
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

    public Purchaser getPurchaser() {
        purchaser.setName(nameField.getText().trim());
        purchaser.setPhone(phoneField.getText().trim());
        purchaser.setPostalCode(postalCodeField.getText().trim());
        purchaser.setProvince(provinceField.getText().trim());
        purchaser.setCity(cityField.getText().trim());
        purchaser.setDeliveryAddress(deliveryAddressField.getText().trim());
        purchaser.setTodaysDate(todaysDateField.getText().trim());
        purchaser.setCreditCardNo(creditCardNoField.getText().trim());
        purchaser.setValidationId(validationIdField.getText().trim());
        return purchaser;
    }

    public List<String> validateFields() {
        List<String> errors = new ArrayList<>();

        if (nameField.getText().trim().isEmpty()) {
            errors.add("Name cannot be empty.");
        }
        if (phoneField.getText().trim().isEmpty()) {
            errors.add("Phone cannot be empty.");
        }
        if (postalCodeField.getText().trim().isEmpty()) {
            errors.add("Postal Code cannot be empty.");
        }
        if (provinceField.getText().trim().isEmpty()) {
            errors.add("Province cannot be empty.");
        }
        if (cityField.getText().trim().isEmpty()) {
            errors.add("City cannot be empty.");
        }
        if (deliveryAddressField.getText().trim().isEmpty()) {
            errors.add("Delivery Address cannot be empty.");
        }
        if (todaysDateField.getText().trim().isEmpty()) {
            errors.add("Today's Date cannot be empty.");
        }
        if (creditCardNoField.getText().trim().isEmpty()) {
            errors.add("Credit Card Number cannot be empty.");
        }
        if (validationIdField.getText().trim().isEmpty()) {
            errors.add("Validation ID cannot be empty.");
        }

        return errors;
    }

}
