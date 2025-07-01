import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;

    public JPanel createUI() {
        // Main panel
        JPanel panel = new JPanel(new BorderLayout());

        // Input field
        taskField = new JTextField();
        panel.add(taskField, BorderLayout.NORTH);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Selected");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add task logic
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        });

        // Remove task logic
        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        return panel;
    }
}
