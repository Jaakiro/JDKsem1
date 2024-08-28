package server;

import client.ClientGUI;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane(log);

    private final ServerController controller;

    public ServerWindow(ServerController controller) {
        this.controller = controller;

        btnStop.addActionListener(e -> stopServer());
        btnStart.addActionListener(e -> startServer());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new BorderLayout());

        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);

        JPanel panelButtons = new JPanel(new GridLayout(1, 2));
        panelButtons.add(btnStart);
        panelButtons.add(btnStop);

        add(panelButtons, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void startServer() {
        controller.startServer();
        appendLog("Server started.\n");
    }

    private void stopServer() {
        controller.stopServer();
        appendLog("Server stopped.\n");
    }

    public void appendLog(String message) {
        log.append(message);
    }

    public void registerClient(ClientGUI client) {
        controller.registerClient(client);
    }

    public void unregisterClient(ClientGUI client) {
        controller.unregisterClient(client);
    }

    public void broadcastMessage(String message, ClientGUI sender) {
        controller.broadcastMessage(message, sender);
    }
}
