package Main.RestServicies;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ConnectionService {
    private final String URL = "https://api-ru.iiko.services/api/1/";

    public HttpURLConnection postConnetion (String to) throws IOException {
        URL url = new URL(URL+to);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json; utf-8");
        con.setRequestProperty("Accept","application/json");
        con.setDoOutput(true);
        return con;
    }
    public HttpURLConnection getConnetion (String to) throws IOException {
        URL url = new URL(URL+to);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json; utf-8");
        con.setRequestProperty("Accept","application/json");
        con.setDoOutput(true);
        return con;
    }



    public ConnectionService() {
    }
}
