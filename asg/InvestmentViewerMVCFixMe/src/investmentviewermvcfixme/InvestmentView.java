package investmentviewermvcfixme;

/**
 * Based on program in Big Java: Late Objects by Cay Horstmann
 */
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InvestmentView extends JFrame {

    private static final int FRAME_WIDTH = 800; // keep this at 800
    private static final int FRAME_HEIGHT = 250;

    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;

    // DEFAULT_RATE and INITIAL_BALANCE are in the model
    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private final JTextArea resultArea;
    // variable balance is in the model

    // // view communicates with model via controller
    private final InvestmentCntl cntl;

    public InvestmentView(InvestmentCntl investmentCntl) {
        super("Investment Viewer");
        cntl = investmentCntl;

        resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        resultArea.setEditable(false);
        resultArea.setText(cntl.fetchBalance() + "\n");

        createTextField();
        createButton();
        createPanel();

        // cf. Bloch, 3rd ed. pp. 95-96: overridable method call in constructor
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        // next two lines not in original Horstmann code
        setLocationRelativeTo(null); // centers frame
        setDefaultCloseOperation(EXIT_ON_CLOSE); // quits when frame closed
    }

    private void createTextField() {
        rateLabel = new JLabel("Interest Rate: ");
        final int FIELD_WIDTH = 10;
        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText(Double.toString(cntl.fetchRate()));
    }

    private void createButton() {
        button = new JButton("Add Interest");
        // fixes broken button logic by adding a listener w/ a lambda
        button.addActionListener((ActionEvent e) -> {
            //  get the rate from the text field, see if it's changed
            double currentRate = Double.parseDouble(rateField.getText());
            if (currentRate != cntl.fetchRate()){
                cntl.updateInterestRate(currentRate);
            }
            
            //  update the text field and balance
            resultArea.append(cntl.calcNewBalance() + "\n");
        });
    }

    private void createPanel() {
        JPanel panel = new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);
        panel.add(button);
        add(panel);
    }

    public void displaySelf() {
        this.setVisible(true);
    }

}
