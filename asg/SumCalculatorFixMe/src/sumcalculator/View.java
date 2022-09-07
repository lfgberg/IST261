package sumcalculator;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
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
        button.addActionListener((ActionEvent e) ->{
            validateInput(textField.getText());
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

    private void validateInput(String input) {
        //  matches only 6 ints seperated by whitespace, no further validation needed if it doesn't pass this check
        if (input.matches("((\\d){1,2}\\s+){6}")) {
            //  split the string into an array of ints, perform further validation
            String[] splitInput = input.split("\\s+");
            List<Integer> parsedInput = new ArrayList<>();
            for (String entry : splitInput){
                parsedInput.add(Integer.parseInt(entry));
            }
            
            //  error message string
            String errorMessage = "";
            
            //  check to ensure entered ints are within range
           if (!cntl.withinRange(parsedInput)){
               errorMessage.concat("One or more of the input integers is out of bounds (less than 1 or greater than 60)");
           }
            
            //  check for duplicates
            if (cntl.containsDuplicates(parsedInput)){
                if (!errorMessage.equals("")){
                    errorMessage.concat("; ");
                }
                errorMessage.concat("The input has integer values that are repeated");
            }
            
            if (!errorMessage.equals("")){
                javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), errorMessage);
            textField.requestFocus();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(),
                    "The input does not contain exactly just six one- or two-digit integers, separated by one or more spaces");
            textField.requestFocus();
        }
    }

}
