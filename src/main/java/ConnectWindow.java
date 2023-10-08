import javax.swing.*;
import java.awt.*;

public class ConnectWindow extends JFrame {
    static private final int WINDOW_HEIGHT = 150;
    static private final int WINDOW_WIDTH = 350;
    static private final int WINDOW_POS_X = 300;
    static private final int WINDOW_POS_Y = 100;
    static private final String WINDOW_NAME = "Подключение к серверу";
    JLabel loginLabel = new JLabel("Логин");
    JTextField loginField = new JTextField();
    JLabel passwordLabel = new JLabel("Пароль");
    JTextField passwordField = new JTextField();
    JLabel serverLabel = new JLabel("Адрес и порт");
    JTextField serverField = new JTextField();
    JButton buttonConnect = new JButton("Подключиться");
    JPanel area = new JPanel(new GridLayout(3,2));
    JPanel button = new JPanel(new GridLayout(1,1));
    JPanel window = new JPanel(new GridLayout(2,1));

    ConnectWindow(){
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        area.add(loginLabel);
        area.add(loginField);
        area.add(passwordLabel);
        area.add(passwordField);
        area.add(serverLabel);
        area.add(serverField);
        button.add(buttonConnect);
        window.add(area);
        window.add(button);
        add(window);
        setVisible(true);
        String chatLog = new ChatLogger().logReader();
        buttonConnect.addActionListener(e -> {
            String login = loginField.getText();
            new ChatWindow(login, chatLog);
        });
    }
}
