package hw1.server;

import hw1.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane(log);
    private boolean isServerWorking;

    private ClientGUI client1;
    private ClientGUI client2;

    public ServerWindow() {
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    log.append("Server is not running.\n");
                } else {
                    isServerWorking = false;
                    log.append("Server stopped.\n");
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    log.append("Server is already running.\n");
                } else {
                    isServerWorking = true;
                    log.append("Server started.\n");
                }
            }
        });

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

    public void registerClient(ClientGUI client) {
        if (client1 == null) {
            client1 = client;
        } else if (client2 == null) {
            client2 = client;
        }
    }

    public void broadcastMessage(String message, ClientGUI sender) {
        if (client1 != null && client1 != sender) {
            client1.receiveMessage(message);
        }
        if (client2 != null && client2 != sender) {
            client2.receiveMessage(message);
        }
    }
}
