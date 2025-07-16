package server;

import java.sql.*;

public class DBOperations {

    public String insertOperation(int id, String make, String model, int engineSize, String status, int price) {
        String result = "";
        try {
            String query = "INSERT INTO vehicles (vid, vmake, vmodel, venginesize, vstatus, vprice) VALUES (?, ?, ?, ?, ?, ?)";
            DBConnection dbc = new DBConnection();
            PreparedStatement pst = dbc.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, make);
            pst.setString(3, model);
            pst.setInt(4, engineSize);
            pst.setString(5, status);
            pst.setInt(6, price);

            if (!pst.execute()) {
                result = "Insert successful";
                System.out.println(result);
            } else {
                result = "Insert failed";
                System.out.println(result);
            }
            dbc.con.close();
        } catch (SQLException e) {
            result = "Insert failed: " + e.getMessage();
            System.out.println(result);
        }
        return result;
    }

    public String[] selectOperation(int id) {
        String[] output = new String[6];
        try {
            String query = "SELECT * FROM vehicles WHERE vid = ?";
            DBConnection dbc = new DBConnection();
            PreparedStatement pst = dbc.con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                output[0] = rs.getString("vid");
                output[1] = rs.getString("vmake");
                output[2] = rs.getString("vmodel");
                output[3] = rs.getString("venginesize");
                output[4] = rs.getString("vstatus");
                output[5] = rs.getString("vprice");
            }
            dbc.con.close();
        } catch (SQLException e) {
            System.out.println("Select failed: " + e.getMessage());
        }
        return output;
    }

    public String updateOperation(int oldId, int newId, String make, String model, int engineSize, String status, int price) {
        String result = "";
        try {
            String query = "UPDATE vehicles SET vid = ?, vmake = ?, vmodel = ?, venginesize = ?, vstatus = ?, vprice = ? WHERE vid = ?";
            DBConnection dbc = new DBConnection();
            PreparedStatement pst = dbc.con.prepareStatement(query);
            pst.setInt(1, newId);
            pst.setString(2, make);
            pst.setString(3, model);
            pst.setInt(4, engineSize);
            pst.setString(5, status);
            pst.setInt(6, price);
            pst.setInt(7, oldId);

            int rows = pst.executeUpdate();
            result = rows + " row(s) updated successfully";
            System.out.println(result);
            dbc.con.close();
        } catch (SQLException e) {
            result = "Update failed: " + e.getMessage();
            System.out.println(result);
        }
        return result;
    }

   public String deleteOperation(int id) {
    String result = "";
    try {
        String query = "DELETE FROM vehicles WHERE vid = ?";
        DBConnection dbc = new DBConnection();
        PreparedStatement pst = dbc.con.prepareStatement(query);
        pst.setInt(1, id);
        int rows = pst.executeUpdate();
        if (rows > 0) {
            result = rows + " row(s) deleted successfully.";
        } else {
            result = "No record found with ID: " + id;
        }
        dbc.con.close();
    } catch (SQLException e) {
        result = "Delete failed: " + e.getMessage();
    }
    return result;
}

}