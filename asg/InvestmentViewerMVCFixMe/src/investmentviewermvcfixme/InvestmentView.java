package investmentviewermvcfixme;

/**
 * Based on program in Big Java: Late Objects by Cay Horstmann
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        resultArea.setText(cntl.fetchStartingBalance() + "\n");

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
        rateField.setText(Double.toString(cntl.fetchStartingInterestRate()));
    }

    private void createButton() {
        button = new JButton("Add Interest");
        
        //  Implement logic for button
        button.addActionListener((ActionEvent e) -> {
            //  If the interest entered is different from the current interest, update it
            if (Double.parseDouble(rateField.getText()) == cntl.getInterestRate()){
                
            }
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
