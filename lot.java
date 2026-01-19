//java code for iot temerature monitoring Device;-
    
    public class lot {
    public static void main(String[] args) {

        System.out.println("IoT Device Monitoring Web Application");

        String deviceName = "Temperaturs Sensor";
        int temperature = 28;
        boolean deviceStatus = true;

        System.out.println("Device Name: " + deviceName);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Device Active: " + deviceStatus);
    }
}

//application connected to dtabase with JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class lot {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/iot_db";
        String username = "root";
        String password = "root"; // change if needed

        String deviceName = "Temperature Sensor";
        int temperature = 30;
        boolean status = true;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO device_data(device_name, temperature, status) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, deviceName);
            ps.setInt(2, temperature);
            ps.setBoolean(3, status);

            ps.executeUpdate();

            System.out.println("Device data stored successfully.");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
