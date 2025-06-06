package com.rsvp.controller;



import com.rsvp.model.RSVPRequest;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@RestController
@CrossOrigin(origins = "*") // allow JS to call from file:// or localhost
public class RSVPController {

    @PostMapping("/rsvp")
    public String handleRSVP(@RequestBody RSVPRequest request) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/rsvp", "root", "root");

            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO users (name, attendence, veg, nonveg) VALUES (?, ?, ?, ?)");
            stmt.setString(1, request.getName());
            stmt.setInt(2, request.getAttendingNum());
            stmt.setInt(3, request.getAttendingVeg());
            stmt.setInt(4, request.getAttendingNonVeg());

            int rows = stmt.executeUpdate();

            stmt.close();
            con.close();

            return rows > 0 ? "RSVP saved successfully!" : "RSVP not saved.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}

