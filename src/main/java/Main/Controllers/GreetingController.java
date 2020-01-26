package Main.Controllers;



import Main.Objects.Requests.PhoneNumberAndDateOrderRequest;
import Main.Objects.Responses.Login.Authorization;
import Main.Objects.Responses.Oganizatons.Organization;
import Main.Objects.Responses.Oganizatons.Organizations;
import Main.Objects.Responses.Orders.OrdersByOrganization;
import Main.RestServicies.ConnectionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.*;
import java.net.HttpURLConnection;;
import java.util.ArrayList;
import java.util.List;


@Controller
public class GreetingController {

    String date = "";
    String phone = "";

    @Autowired
    public ConnectionService сonnectionService;

    @GetMapping("/")
    public String greeting() {
        List<String> ids = new ArrayList<>();
        for (Organization org : GetOrgId().getOrganizations()){
            ids.add(org.getId());
        }
        GetOrdersByPhoneDate(date,phone,ids);
        return "greeting";
    }

    public Authorization TestJson() throws IOException {

        HttpURLConnection con = сonnectionService.postConnetion("access_token");
        Gson gson = new Gson();
        Authorization authorization = new Authorization();
        //JSON String need to be constructed for the specific resource.
        //We may construct complex JSON using any third-party JSON libraries such as jackson or org.json
        String jsonInputString = "{\"apiLogin\": \"e5f38ebd\"}";

        try(OutputStream os = con.getOutputStream()){
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int code = con.getResponseCode();
        System.out.println(code);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            authorization = gson.fromJson(String.valueOf(response), Authorization.class);
            System.out.println(response.toString());
        }
        return authorization;
    }
    public Organizations GetOrgId(){
        Organizations organizations = new Organizations();
        Gson gson = new Gson();
        HttpURLConnection con = null;
        try {
            con = сonnectionService.getConnetion("organizations");
            con.setRequestProperty("Authorization", "Bearer " + TestJson().getToken());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            organizations = gson.fromJson(String.valueOf(response), Organizations.class);
            System.out.println(response.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return organizations;

    }

    public OrdersByOrganization GetOrdersByPhoneDate(String date, String phone, List<String> organizations){

        /*String formate = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat sf = new SimpleDateFormat(formate);
        String date = sf.format(new Date());*/

        PhoneNumberAndDateOrderRequest phoneNumberAndDateOrderRequest = new PhoneNumberAndDateOrderRequest();
        phoneNumberAndDateOrderRequest.setDeliveryDateFrom(date);
        phoneNumberAndDateOrderRequest.setOrganizationIds(organizations);
        phoneNumberAndDateOrderRequest.setPhone(phone);
        HttpURLConnection connection = null;
        Gson gson = new Gson();
        OrdersByOrganization ordersByOrganization = new OrdersByOrganization();
        try {
            connection = сonnectionService.getConnetion("deliveries/by_delivery_date_and_phone");
            connection.setRequestProperty("Authorization", "Bearer " + TestJson().getToken());

        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            ordersByOrganization = gson.fromJson(String.valueOf(response), OrdersByOrganization.class);
            System.out.println(response.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ordersByOrganization;
    }


}