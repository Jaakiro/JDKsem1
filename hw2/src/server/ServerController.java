package server;

import client.ClientGUI;

public class ServerController {
    private final ServerRepository repository;

    public ServerController(ServerRepository repository) {
        this.repository = repository;
    }

    public void startServer() {
    }

    public void stopServer() {
    }

    public void registerClient(ClientGUI client) {
        repository.addClient(client);
    }

    public void unregisterClient(ClientGUI client) {
        repository.removeClient(client);
    }

    public void broadcastMessage(String message, ClientGUI sender) {
        for (ClientGUI client : repository.getClients()) {
            if (client != sender) {
                client.receiveMessage(message);
            }
        }
    }
}
