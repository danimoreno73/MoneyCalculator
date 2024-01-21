package software.ulpgc.MoneyCalculator.view;

import software.ulpgc.MoneyCalculator.model.Money;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    public SwingMoneyDisplay() {
        this.setBackground(Color.BLACK);
    }

    @Override
    public void show(Money money) {
        this.setText( money.toString());
    }
}
