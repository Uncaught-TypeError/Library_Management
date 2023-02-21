/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Connecting2B {

    public Connection newConnection() {
        Connection con = null;
        Statement st;
        ResultSet rs;
        String url = "jdbc:ucanaccess://C:\\Users\\Asus\\Documents\\NetBeansProjects\\JavaApplication1\\Book.accdb";
        try {
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            String sql = "Select * from Book";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String author, title, YOP, publisher, ISBN, Clo, BC;
                author = rs.getString("Author");
                title = rs.getString("Title");
                YOP = rs.getString("YearOfPublication");
                publisher = rs.getString("Publisher");
                ISBN = rs.getString("ISBN");
                Clo = rs.getString("Current Location");
                BC = rs.getString("BookCategory");

            }
        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
        return con;
    }

    public boolean searchA(String user) {
        boolean status = false;
        try {
            Connection con = newConnection();
            Statement st = con.createStatement();
            String query = "Select * From Book Where Author='" + user + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String userr = rs.getString("Author");
                if (userr.equals(user)) {
                    status = true;
                    JOptionPane.showMessageDialog(null, "The author is found.");
                } else {

                    status = false;

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public boolean searchT(String user) {
        boolean status = false;
        try {
            Connection con = newConnection();
            Statement st = con.createStatement();
            String query = "Select * From Book Where Title='" + user + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String userr = rs.getString("Title");
                if (userr.equals(user)) {
                    status = true;
                    JOptionPane.showMessageDialog(null, "The title is found.");
                } else {

                    status = false;

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public boolean searchC(String user) {
        boolean status = false;
        try {
            Connection con = newConnection();
            Statement st = con.createStatement();
            String query = "Select * From Book Where BookCategory='" + user + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String userr = rs.getString("BookCategory");
                if (userr.equals(user)) {
                    status = true;
                    JOptionPane.showMessageDialog(null, "The category is found.");
                } else {

                    status = false;

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
