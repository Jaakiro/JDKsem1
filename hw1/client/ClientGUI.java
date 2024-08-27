package hw1.client;

import hw1.server.ServerWindow;

import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAdress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("Ivan");
    private final JPasswordField tfPassword = new JPasswordField("qwe");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final ServerWindow serverWindow;

    public ClientGUI(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAdress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        btnLogin.addActionListener(e -> login());
        btnSend.addActionListener(e -> sendMessage());

        serverWindow.registerClient(this);

        setVisible(true);
    }

    private void login() {
        log.append("You are logged in as " + tfLogin.getText() + "\n");

        panelTop.setVisible(false);
    }

    private void sendMessage() {
        String message = tfLogin.getText() + ": " + tfMessage.getText();
        log.append(message + "\n");
        serverWindow.broadcastMessage(message, this);
        tfMessage.setText("");
    }

    public void receiveMessage(String message) {
        log.append(message + "\n");
    }

    public static void main(String[] args) {
        new ClientGUI(new ServerWindow());
    }
}
