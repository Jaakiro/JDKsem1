package client;

import server.ServerWindow;

public class ClientController {
    private final ServerWindow serverWindow;

    public ClientController(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;
    }

    public void login(String login) {

    }

    public void sendMessage(String message, ClientGUI clientGUI) {
        serverWindow.broadcastMessage(message, clientGUI);
    }
}
