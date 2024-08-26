import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
 
    private JTextField inputField;
    private JLabel resultLabel;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel inputLabel = new JLabel("Enter temperature:");
        inputLabel.setBounds(10, 20, 150, 25);
        panel.add(inputLabel);

        inputField = new JTextField(20);
        inputField.setBounds(170, 20, 165, 25);
        panel.add(inputField);

        JLabel tempLabel = new JLabel("Select Temperature Unit:");
        tempLabel.setBounds(10, 50, 150, 25);
        panel.add(tempLabel);

        String[] temperatures = {"Fahrenheit", "Kelvin"};
        JComboBox<String> currencyComboBox = new JComboBox<>(temperatures);
        currencyComboBox.setBounds(170, 50, 120, 25);
        panel.add(currencyComboBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(10, 80, 100, 25); //save//
        panel.add(convertButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(150, 80, 300, 25);
        panel.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature(Double.parseDouble(inputField.getText()), currencyComboBox.getSelectedItem().toString());
            }
        });
    }

    private void convertTemperature(double temp, String targetTemp) {
        // You can replace this logic with a real API call or database lookup for the latest exchange rates
        double conversionValue = 1.0;

        switch (targetTemp) {
            case "Fahrenheit":
                conversionValue = 1.8; 
                break;
            case "Kelvin":
                conversionValue = 273.15; 
                break;

        }
        
        if (targetTemp == "Fahrenheit") {
            double convertedTemp = (temp * conversionValue) + 32;
            resultLabel.setText("Converted Amount: " + convertedTemp + " " + targetTemp);
        } else {
            double convertedTemp = temp + conversionValue;
            resultLabel.setText("Converted Amount: " + convertedTemp + " " + targetTemp);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverter());
    }
}

