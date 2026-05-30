package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;

import java.awt.BorderLayout;

public class MainWindow extends JFrame {

    private JTextArea storyArea;
    private JPanel choicePanel;

    public MainWindow() {

        setTitle("AI Horror Story Studio");

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());



        JPanel mainPanel =
                new JPanel(new BorderLayout());



        storyArea = new JTextArea();

        storyArea.setText(
                "Welcome to Horror Story Studio"
        );

        choicePanel=new JPanel();
        choicePanel.setLayout(
                new GridLayout(0, 1) //unlimited rows, 1 col
        );
        JButton button1 =
                new JButton("Open Basement");

        JButton button2 =
                new JButton("Run Outside");

        storyArea.setEditable(false);



        JScrollPane scrollPane =
                new JScrollPane(storyArea);



        add(mainPanel, BorderLayout.CENTER);

        mainPanel.add(scrollPane,
                BorderLayout.CENTER);

        mainPanel.add(choicePanel,
                BorderLayout.SOUTH);

        choicePanel.add(button1);
        choicePanel.add(button2);




        setVisible(true);
    }

    public void displayScene(String title,
                             String content) {

        storyArea.setText(
                title + "\n\n" + content
        );
    }
}