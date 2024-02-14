import java.sql.*;

public class JavaDBC {
    public static void main(String... args){
        String url = "jdbc:sqlite:C:/Users/bta96367/Downloads/chinook-2.db";

        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url);
            PreparedStatement ps = connect.prepareStatement("select * from tracks where UnitPrice > (?)");
            ps.setString(1, "1.50");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Name");
                String comp = rs.getString("Composer");
                String up = rs.getString("UnitPrice");
                System.out.println(name + " " + comp + " " + up);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }






//        String url = "jdbc:sqlite:C:/Users/bta96367/Downloads/chinook-2.db";
//
//        try {
//            Connection connect = DriverManager.getConnection(url);
//            Statement statement = connect.createStatement();
//            ResultSet result = statement.executeQuery("select * from artists");
//            while (result.next()) {
//
//                String name = result.getString("Name"); // name of column you want
//                System.out.println(name);
//            }
//        } catch (SQLException e) {
//            System.out.println("ERROR");
//            e.printStackTrace();
//        }
    }
}
