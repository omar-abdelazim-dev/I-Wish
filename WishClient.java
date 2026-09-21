package iti.iwish.client;

import iti.iwish.server.WishServer;
import iti.iwish.shared.ApiRequest;
import iti.iwish.shared.ApiResponse;
import iti.iwish.shared.NetworkConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

/** Client-side protocol boundary; the GUI never talks to the database directly. */
public final class WishClient {
    public ApiResponse call(String action, Map<String,Object> data) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(NetworkConfig.host(), WishServer.PORT), 1300);
            try (ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream()); ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {
                output.writeObject(new ApiRequest(action,data)); output.flush(); return (ApiResponse) input.readObject();
            }
        } catch (IOException | ClassNotFoundException exception) { return ApiResponse.fail("Can’t reach the I-Wish server. Start it from the welcome screen or run ServerConsoleApp."); }
    }
}
