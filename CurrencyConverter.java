import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CurrencyConverter extends JFrame {

    private JComboBox<String> fromCurrency, toCurrency;
    private JTextField amountField, resultField;
    private JButton convertButton, resetButton;

    private final HashMap<String, HashMap<String, Double>> exchangeRates;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY"};

        // Initialize Components
        fromCurrency = new JComboBox<>(currencies);
        toCurrency = new JComboBox<>(currencies);
        amountField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        convertButton = new JButton("Convert");
        resetButton = new JButton("Reset");

        // Add Components to Frame
        add(new JLabel("From Currency:"));
        add(fromCurrency);
        add(new JLabel("To Currency:"));
        add(toCurrency);
        add(new JLabel("Amount:"));
        add(amountField);
        add(new JLabel("Converted Amount:"));
        add(resultField);
        add(convertButton);
        add(resetButton);

        // Set Exchange Rates
        exchangeRates = new HashMap<>();
        setExchangeRates();

        // Add Action Listeners
        convertButton.addActionListener(_ -> convertCurrency());
        resetButton.addActionListener(_ -> resetFields());

        setVisible(true);
    }

    private void setExchangeRates() {
        // Static conversion rates
        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY"};
        double[][] rates = {
                {1, 0.85, 0.75, 74, 110},
                {1.18, 1, 0.88, 87, 129},
                {1.33, 1.14, 1, 99, 147},
                {0.014, 0.011, 0.010, 1, 1.48},
                {0.0091, 0.0078, 0.0068, 0.68, 1}
        };

        for (int i = 0; i < currencies.length; i++) {
            HashMap<String, Double> innerMap = new HashMap<>();
            for (int j = 0; j < currencies.length; j++) {
                innerMap.put(currencies[j], rates[i][j]);
            }
            exchangeRates.put(currencies[i], innerMap);
        }
    }

    private void convertCurrency() {
        try {
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();
            double amount = Double.parseDouble(amountField.getText());

            if (amount < 0) {
                JOptionPane.showMessageDialog(this, "Amount must be non-negative.");
                return;
            }

            double rate = exchangeRates.get(from).get(to);
            double result = amount * rate;

            resultField.setText(String.format("%.2f", result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    private void resetFields() {
        amountField.setText("");
        resultField.setText("");
        fromCurrency.setSelectedIndex(0);
        toCurrency.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurrencyConverter::new);
    }
}
