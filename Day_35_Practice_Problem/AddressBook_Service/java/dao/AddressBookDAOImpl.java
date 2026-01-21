package Day_35_Practice_Problem.AddressBook_Service.java.dao;

import Day_35_Practice_Problem.AddressBook_Service.java.model.ContactPerson;
import Day_35_Practice_Problem.AddressBook_Service.java.util.DBConnection;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class AddressBookDAOImpl implements Day_35_Practice_Problem.AddressBook_Service.java.dao.AddressBookDAO {

    @Override
    public boolean addContact(ContactPerson person) {
        String sql = """
                INSERT INTO contacts
                (first_name, last_name, address, city, state, zip,
                 phone, email, date_added)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getAddress());
            ps.setString(4, person.getCity());
            ps.setString(5, person.getState());
            ps.setString(6, person.getZip());
            ps.setString(7, person.getPhone());
            ps.setString(8, person.getEmail());
            ps.setDate(9, Date.valueOf(person.getDateAdded()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error adding contact", e);
        }
    }

    @Override
    public boolean updateContact(ContactPerson person) {
        String sql = """
                UPDATE contacts
                SET address=?, city=?, state=?, zip=?, phone=?, email=?
                WHERE first_name=? AND last_name=?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, person.getAddress());
            ps.setString(2, person.getCity());
            ps.setString(3, person.getState());
            ps.setString(4, person.getZip());
            ps.setString(5, person.getPhone());
            ps.setString(6, person.getEmail());
            ps.setString(7, person.getFirstName());
            ps.setString(8, person.getLastName());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating contact", e);
        }
    }

    @Override
    public boolean deleteContact(String firstName, String lastName) {
        String sql = "DELETE FROM contacts WHERE first_name=? AND last_name=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting contact", e);
        }
    }

    @Override
    public List<ContactPerson> getAllContacts() {
        String sql = "SELECT * FROM contacts";
        List<ContactPerson> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                ContactPerson p = new ContactPerson();
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
                p.setCity(rs.getString("city"));
                p.setState(rs.getString("state"));
                list.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching contacts", e);
        }
        return list;
    }

    @Override
    public List<ContactPerson> getContactsByCity(String city) {
        return List.of();
    }

    @Override
    public Map<String, Long> getCountByState() {
        String sql = "SELECT state, COUNT(*) AS count FROM contacts GROUP BY state";
        Map<String, Long> map = new HashMap<>();

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                map.put(rs.getString("state"), rs.getLong("count"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    @Override
    public List<ContactPerson> getContactsAddedBetween(LocalDate start, LocalDate end) {
        String sql = """
                SELECT * FROM contacts
                WHERE date_added BETWEEN ? AND ?
                """;

        List<ContactPerson> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(start));
            ps.setDate(2, Date.valueOf(end));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ContactPerson p = new ContactPerson();
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
                list.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
