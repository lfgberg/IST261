package LotteryThree;

public class LotteryThree {

    public static void main(String[] args) {
        //https://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        javax.swing.SwingUtilities.invokeLater(() -> {
            Controller cntl = new Controller();
            cntl.showView();
        });
    }

}
