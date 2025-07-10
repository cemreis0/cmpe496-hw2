package ui;

import model.Purchaser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

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

    // Constructors
    public PurchaserPanel() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Purchaser"));

        JPanel form = new JPanel(new GridLayout(6, 2, 8, 8));

        nameField = new JTextField();
        phoneField = new JTextField();
        postalCodeField = new JTextField();
        provinceField = new JTextField();
        cityField = new JTextField();
        deliveryAddressField = new JTextField();
        todaysDateField = new JTextField();
        creditCardNoField = new JTextField();
        validationIdField = new JTextField();

        // Row 1
        form.add(new JLabel("Name:"));
        form.add(nameField);

        form.add(new JLabel("Phone:"));
        form.add(phoneField);

        // Row 2
        form.add(new JLabel("Postal Code:"));
        form.add(postalCodeField);

        form.add(new JLabel("Province:"));
        form.add(provinceField);

        // Row 3
        form.add(new JLabel("City:"));
        form.add(cityField);

        // empty to fill 2nd column
        form.add(new JLabel(""));

        // Row 4
        form.add(new JLabel("Delivery Address:"));
        form.add(deliveryAddressField);

        // Row 5
        form.add(new JLabel("Today's Date:"));
        form.add(todaysDateField);

        form.add(new JLabel("Credit Card No:"));
        form.add(creditCardNoField);

        // Row 6
        form.add(new JLabel("Validation ID:"));
        form.add(validationIdField);

        add(form, BorderLayout.CENTER);
    }

    // Other Methods
    public Purchaser getPurchaserData() {
        return new Purchaser(
                nameField.getText().trim(),
                phoneField.getText().trim(),
                postalCodeField.getText().trim(),
                provinceField.getText().trim(),
                cityField.getText().trim(),
                deliveryAddressField.getText().trim(),
                todaysDateField.getText().trim(),
                creditCardNoField.getText().trim(),
                validationIdField.getText().trim()
        );
    }

    public void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        postalCodeField.setText("");
        provinceField.setText("");
        cityField.setText("");
        deliveryAddressField.setText("");
        todaysDateField.setText("");
        creditCardNoField.setText("");
        validationIdField.setText("");
    }

}
