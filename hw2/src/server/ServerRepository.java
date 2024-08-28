package server;

import client.ClientGUI;

import java.util.ArrayList;
import java.util.List;

public class ServerRepository {
    private final List<ClientGUI> clients = new ArrayList<>();

    public void addClient(ClientGUI client) {
        clients.add(client);
    }

    public void removeClient(ClientGUI client) {
        clients.remove(client);
    }

    public List<ClientGUI> getClients() {
        return clients;
    }
}
