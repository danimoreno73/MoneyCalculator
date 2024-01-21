package software.ulpgc.MoneyCalculator.view;

import software.ulpgc.MoneyCalculator.model.Rate;
import software.ulpgc.MoneyCalculator.controller.Command;
import software.ulpgc.MoneyCalculator.controller.ExchangeMoneyCommand;
import software.ulpgc.MoneyCalculator.Loader.FixerCurrencyLoader;
import software.ulpgc.MoneyCalculator.Loader.FixerExchangeRateLoader;
import software.ulpgc.MoneyCalculator.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingMain extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;


    public static void exec(){
        SwingMain main = new SwingMain();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Map<String, Double> rates = new FixerExchangeRateLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                new Rate(rates),
                main.moneyDisplay());
        main.add("exchange money", command);
        main.setVisible(true);
    }

    private SwingMain() throws HeadlessException {
        this.setTitle("Money calculator");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.CYAN);
        this.setTitle();
        this.setContainerPanel();
        this.add(createMoneyDisplay());

        this.add(toolbar());
    }

    private void setContainerPanel() {
        JPanel containerPanel = new JPanel();

        this.add(containerPanel);

        containerPanel.setBackground(Color.WHITE);

        containerPanel.add(createMoneyDialog());
        containerPanel.add(createCurrencyDialog());

    }

    private void setTitle() {
        JLabel title = new JLabel("Money Calculator", JLabel.CENTER);
        title.setFont(new Font("New Font",Font.PLAIN | Font.BOLD,75));
        this.add(title);
    }

    private Component toolbar() {
        JButton button = new JButton("calculate");

        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;

        return dialog;
    }

    private void add(String name, Command command) {
        commands.put(name, command);
    }

    private MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    private CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    private MoneyDialog moneyDialog() {
        return moneyDialog;
    }
}
