import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    static private final int WINDOW_HEIGHT = 640;
    static private final int WINDOW_WIDTH = 720;
    static private final int WINDOW_POS_X = 300;
    static private final int WINDOW_POS_Y = 100;
    static private final String WINDOW_NAME = "Чат с сервером";
    JTextArea textOutput = new JTextArea();
    JLabel label = new JLabel("Поле ввода сообщения");
    JTextField textInput = new JTextField();
    JButton buttonSend = new JButton("Отправить");
    JPanel chatWindow = new JPanel(new GridLayout(1,1));
    JPanel sendWindow = new JPanel(new GridLayout(3,1));
    JPanel window = new JPanel(new GridLayout(2,1));

    ChatWindow(String login, String chatLog){
        setResizable(false);
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        textOutput.setEditable(false);
        textOutput.setBackground(Color.GRAY);
        chatWindow.add(textOutput);
        sendWindow.add(label);
        sendWindow.add(textInput);
        sendWindow.add(buttonSend);
        window.add(chatWindow);
        window.add(sendWindow);
        add(window);
        setVisible(true);
        textOutput.setText(chatLog);
        buttonSend.addActionListener(e -> {
            DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String message = LocalDateTime.now().format(dTF) + " " + login + " : " + textInput.getText() + "\n";
            textOutput.append(message);
            ChatLogger.logToFile(message);
            textInput.setText("");
        });
    }
}