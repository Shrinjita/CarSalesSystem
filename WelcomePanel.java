import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.File;
import java.text.NumberFormat;

public class WelcomePanel extends JPanel implements ChangeListener {
    private CarSalesSystem carSystem;
    private JLabel headingLabel = new JLabel("Welcome to the Car Sales System", JLabel.CENTER);
    private JLabel carsLabel = new JLabel();
    private JLabel manufacturersLabel = new JLabel();
    private JLabel avgPriceLabel = new JLabel();
    private JLabel avgKmLabel = new JLabel();
    private JLabel avgAgeLabel = new JLabel();
    private JLabel dataSizeLabel = new JLabel();
    private JPanel statsPanel = new JPanel();
    private boolean carsUpdated = false;
    private String file;

    public WelcomePanel(CarSalesSystem carSys, String data) {
        carSystem = carSys;
        file = data;
        setLayout(new BorderLayout(0, 15));

        // Add update listener
        carSys.addCarUpdateListener(this);

        // Styling the heading label
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headingLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        // Stats panel layout
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        updateStats();

        // Add labels to the stats panel
        statsPanel.add(carsLabel);
        statsPanel.add(manufacturersLabel);
        statsPanel.add(avgPriceLabel);
        statsPanel.add(avgKmLabel);
        statsPanel.add(avgAgeLabel);
        statsPanel.add(Box.createVerticalStrut(15));
        statsPanel.add(dataSizeLabel);

        add(headingLabel, BorderLayout.NORTH);
        add(statsPanel, BorderLayout.CENTER);
    }

    @Override
    public void carsUpdated(CarUpdateEvent ev) {
        if (ev.getSource() == carSystem) {
            carsUpdated = true;
        }
    }

    @Override
    public void stateChanged(ChangeEvent ev) {
        if (ev.getSource() instanceof JTabbedPane) {
            JTabbedPane tab = (JTabbedPane) ev.getSource();
            if (tab.getSelectedIndex() == 0 && carsUpdated) {
                updateStats();
                carsUpdated = false;
            }
        }
    }

    private void updateStats() {
        // Fetching statistics
        int cars = (int) carSystem.getStatistics(CarSalesSystem.CARS_COUNT);
        int manufacturers = (int) carSystem.getStatistics(CarSalesSystem.MANUFACTURERS_COUNT);
        double avgPrice = carSystem.getStatistics(CarSalesSystem.AVERAGE_PRICE);
        double avgKm = carSystem.getStatistics(CarSalesSystem.AVERAGE_DISTANCE);
        double avgAge = carSystem.getStatistics(CarSalesSystem.AVERAGE_AGE);

        // Format large numbers with commas
        NumberFormat formatter = NumberFormat.getInstance();
        String carsStr = formatter.format(cars);
        String manufacturersStr = formatter.format(manufacturers);

        // Format decimal numbers to 2 decimal places
        String avgPriceStr = String.format("%.2f", avgPrice);
        String avgKmStr = String.format("%.2f", avgKm);
        String avgAgeStr = String.format("%.2f", avgAge);

        // File size calculation with error handling
        long size = 0;
        File f = new File(file);
        if (f.exists()) {
            size = f.length();
        } else {
            size = 0;  // File not found
        }

        // Displaying the stats with formatting
        carsLabel.setText("Total cars: " + carsStr);
        manufacturersLabel.setText("Total manufacturers: " + manufacturersStr);
        avgPriceLabel.setText("Average price: $" + avgPriceStr);
        avgKmLabel.setText("Average kilometers: " + avgKmStr + " km");
        avgAgeLabel.setText("Average car age: " + avgAgeStr + " years");
        dataSizeLabel.setText("Data file size: " + formatter.format(size) + " bytes");
    }
}
