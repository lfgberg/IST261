package sumcalculator;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class View extends JFrame {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 250;

    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;

    private static final String INPUT_SPECIFIER = "\nEnter just six different "
            + "integers from 1 through 60, separated by one or more spaces";

    private JLabel label;
    private JTextField textField;
    private JButton button;
    private final JTextArea resultArea;

    private final Controller cntl;

    public View(Controller controller) {
        super("Sum Calculator");
        cntl = controller;
        resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        resultArea.setEditable(false);
        resultArea.setText("");

        createTextField();
        createButton();
        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null); // centers frame
        setDefaultCloseOperation(EXIT_ON_CLOSE); // quits when frame closed
        //https://stackoverflow.com/questions/13731710/allowing-the-enter-key-to-press-the-submit-button-as-opposed-to-only-using-mo
        getRootPane().setDefaultButton(button);
    }

    private void createTextField() {
        label = new JLabel(INPUT_SPECIFIER);
        final int FIELD_WIDTH = 10;
        textField = new JTextField(FIELD_WIDTH);
    }

    private void createButton() {
        button = new JButton("Compute Sum");
        
        //  use lambda to add button logic
        button.addActionListener((ActionEvent e) ->{
            //  get input from text field
            String input = textField.getText();
            
            //  utilize controller method to check input, if there's an error display it, if not, compute sum
            String err = cntl.validateInput(input);
            if (!err.equals("")){
                javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), err);
            } else {
                resultArea.append(String.valueOf(cntl.computeSum(input) + "\n"));
            }
        });
    }

    private void createPanel() {
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);
        panel.add(button);
        add(panel);
    }

    public void displaySelf() {
        this.setVisible(true);
    }
}
