package LotteryThree;

import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class View extends JFrame {

    private JLabel inputLabel, drawingLabel;
    private JTextField inputField, drawingField;
    private JButton button;
    private final JTextArea resultArea;

    private final Controller cntl;

    public View(Controller controller) {
        super("Lottery Drawing");
        cntl = controller;
        resultArea = new JTextArea(10, 50);
        resultArea.setEditable(false);
        resultArea.setText("");

        createInputField();
        createDrawingField();
        createButton();
        createPanel();

        setSize(800, 300);
        setLocationRelativeTo(null); // centers frame
        setDefaultCloseOperation(EXIT_ON_CLOSE); // quits when frame closed
        //https://stackoverflow.com/questions/13731710/allowing-the-enter-key-to-press-the-submit-button-as-opposed-to-only-using-mo
        getRootPane().setDefaultButton(button);
    }

    private void createInputField() {
        inputLabel = new JLabel("\nEnter 6 space seperated integers 1-60:");
        inputField = new JTextField(10);
    }
    
    private void createDrawingField() {
        drawingLabel = new JLabel("\nEnter 1 integer 1-100000:");
        drawingField = new JTextField(6);
    }

    private void createButton() {
        button = new JButton("I'm Feeling Lucky");
        
        //  use lambda to add button logic
        button.addActionListener((ActionEvent e) ->{
            //  get input from text field
            String numbers = inputField.getText();
            String drawings = drawingField.getText();
            
            //  clear the result field
            resultArea.setText("");
            
            //  utilize controller method to check input, if there's an error display it, if not, run drawing
            String err = cntl.validateInput(numbers);
            if (!err.equals("")){
                javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), err);
            } else {
                //  validate drawings
                if (cntl.validateDrawings(drawings)){
                    //  run drawings
                    Map<Integer, Integer> results = cntl.runDrawing(numbers, drawings);
                    resultArea.append(String.format("Your Lucky Numbers: %s\n%d drawings matched 0 of your numbers\n%d drawings matched 1 of your numbers\n%d drawings matched 2 of your numbers\n%d drawings matched 3 of your numbers\n%d drawings matched 4 of your numbers\n%d drawings matched 5 of your numbers\n%d drawings matched 6 of your numbers",
                            cntl.getInput(), results.get(0), results.get(1), results.get(2), results.get(3), results.get(4), results.get(5), results.get(6)));
                } else {
                    javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), "input for the number of drawings is not exactly one integer from 1 through 100000.");
                }
            }
        });
    }

    private void createPanel() {
        JPanel panel = new JPanel();
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(drawingLabel);
        panel.add(drawingField);
        panel.add(button);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);
        add(panel);
    }

    public void displaySelf() {
        this.setVisible(true);
    }
}
