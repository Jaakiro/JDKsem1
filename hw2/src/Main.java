import client.ClientGUI;
import server.ServerController;
import server.ServerRepository;
import server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerRepository repository = new ServerRepository();
        ServerController controller = new ServerController(repository);
        ServerWindow serverWindow = new ServerWindow(controller);

        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
