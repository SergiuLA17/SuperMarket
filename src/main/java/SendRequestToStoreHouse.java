
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@WebServlet(name = "SendRequestToStoreHouse", value = "/SendRequestToStoreHouse")
public class SendRequestToStoreHouse extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String query = "http://localhost:8080/GetMeProduct?pname=";
        String productName = req.getParameter("pname");

        HttpURLConnection connection = (HttpURLConnection) new URL(query + productName).openConnection();
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);

        StringBuilder stringBuilder = new StringBuilder();

        if (HttpURLConnection.HTTP_OK >=  connection.getResponseCode()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder);
            in.close();
        } else {
            System.out.println("Error " + connection.getResponseCode());
        }

    }
}