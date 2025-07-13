package ui;

import model.CatalogItem;
import model.Order;
import service.MessageService;
import ui.screens.Screen1;
import ui.screens.Screen2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ScreenManager {

    // Data Members
    private JFrame frame;
    private Screen1 screen1;
    private Screen2 screen2;
    private Order order;
    private MessageService messageService;

    // Constructors
    public ScreenManager(JFrame frame) {
        this.frame = frame;
        this.order = new Order();
        this.order.setItems(new ArrayList<>());

        messageService = new MessageService();

        screen1 = new Screen1();
        screen2 = new Screen2();

        initializeScreen1Listeners();
        initializeScreen2Listeners();

        showScreen(screen1);
    }

    // Other Methods
    private void initializeScreen1Listeners() {
        screen1.getActionPanel().getNextCatalogItemButton().addActionListener(e -> {
            List<String> purchaserErrors = screen1.getPurchaserPanel().validateFields();
            List<String> catalogErrors = screen1.getCatalogItemPanel().validateFields();

            if (!purchaserErrors.isEmpty()) {
                messageService.showError(String.join("\n", purchaserErrors));
                return;
            }

            if (!catalogErrors.isEmpty()) {
                messageService.showError(String.join("\n", catalogErrors));
                return;
            }

            savePurchaserToOrder();
            saveCatalogItemToOrder(screen1.getCatalogItemPanel().getCatalogItem());
            updateBalance();
            showScreen(screen2);
        });

        screen1.getActionPanel().getTriggerInvoiceButton().addActionListener(e -> {
            List<String> purchaserErrors = screen1.getPurchaserPanel().validateFields();
            List<String> catalogErrors = screen1.getCatalogItemPanel().validateFields();

            if (!purchaserErrors.isEmpty()) {
                messageService.showError(String.join("\n", purchaserErrors));
                return;
            }

            if (!catalogErrors.isEmpty()) {
                messageService.showError(String.join("\n", catalogErrors));
                return;
            }

            savePurchaserToOrder();
            saveCatalogItemToOrder(screen1.getCatalogItemPanel().getCatalogItem());
            updateBalance();
            triggerInvoice();
            System.exit(0);
        });
    }

    private void initializeScreen2Listeners() {
        screen2.getActionPanel().getNextCatalogItemButton().addActionListener(e -> {
            List<String> catalogErrors = screen2.getCatalogItemPanel().validateFields();

            if (!catalogErrors.isEmpty()) {
                messageService.showError(String.join("\n", catalogErrors));
                return;
            }

            saveCatalogItemToOrder(screen2.getCatalogItemPanel().getCatalogItem());
            updateBalance();
        });

        screen2.getActionPanel().getTriggerInvoiceButton().addActionListener(e -> {
            List<String> catalogErrors = screen2.getCatalogItemPanel().validateFields();

            if (!catalogErrors.isEmpty()) {
                messageService.showError(String.join("\n", catalogErrors));
                return;
            }

            saveCatalogItemToOrder(screen2.getCatalogItemPanel().getCatalogItem());
            updateBalance();
            triggerInvoice();
            System.exit(0);
        });
    }

    private void savePurchaserToOrder() {
        order.setPurchaser(screen1.getPurchaserPanel().getPurchaser());
    }

    private void saveCatalogItemToOrder(CatalogItem catalogItem) {
        order.addItem(catalogItem);
    }

    private void showScreen(JPanel screen) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(screen);
        frame.revalidate();
        frame.repaint();
    }

    private void updateBalance() {
        double balance = order.calculateBalanceOwing();
        screen1.getActionPanel().updateBalance(balance);
        screen2.getActionPanel().updateBalance(balance);
    }

    private void triggerInvoice() {
        new service.OrderService().saveOrder(order);
    }
}
