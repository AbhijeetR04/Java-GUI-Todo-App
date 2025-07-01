import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("To-Do List");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            TodoApp todoApp = new TodoApp();
            frame.add(todoApp.createUI());

            frame.setVisible(true);
        });
    }
}
