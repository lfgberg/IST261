package investmentviewerfixme;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A frame that shows the growth of an investment with variable interest, using
 * a text area. Code from Big Java Late Objects, 1st edition by Cay Horstmann,
 * modified
 */
public class InvestmentFrame3 extends JFrame {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 250;

    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;

    private static final double DEFAULT_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private final JTextArea resultArea;
    private double balance;

    public InvestmentFrame3() {
        balance = INITIAL_BALANCE;
        resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        resultArea.setText(balance + "\n");
        resultArea.setEditable(false);

        createTextField();
        createButton();
        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField() {
        rateLabel = new JLabel("Interest Rate: ");

        final int FIELD_WIDTH = 10;
        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText("" + DEFAULT_RATE);
    }

    private void createButton() {
        button = new JButton("Add Interest");
        
        // fixes broken button logic by adding a listener w/ a lambda
        button.addActionListener((ActionEvent e) -> {
            //  take the current balance and add interest based on the inputted rate
            balance = balance + (balance * Double.parseDouble(rateField.getText()) / 100);
            
            //  update the text field
            resultArea.append(balance + "\n");
        });
    }

    private void createPanel() {
        JPanel panel = new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(button);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);
        add(panel);
    }
}
