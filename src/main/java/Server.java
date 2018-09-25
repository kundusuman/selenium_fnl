
import java.rmi.registry.LocateRegistry;

public class Server extends Thread {
    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(12345).rebind("//localhost//dictionary//", new Oxford());
            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}