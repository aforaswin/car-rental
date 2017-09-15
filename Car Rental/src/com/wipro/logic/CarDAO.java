package com.wipro.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 

public class CarDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public CarDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertCar(Car car) throws SQLException {
        String sql = "INSERT INTO car (reg_no, company_name, car_name, type, no_of_seats, rent) VALUES (?, ?, ?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, car.getRegNo());
        statement.setString(2, car.getCompanyName());
        statement.setString(3, car.getCarName());
        statement.setString(4, car.getType());
        statement.setInt(5, car.getNoOfSeats());
        statement.setDouble(6, car.getRent());
        
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Car> listAllCars() throws SQLException {
        List<Car> listCar = new ArrayList<Car>();
         
        String sql = "SELECT * FROM car";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String regNo = resultSet.getString("reg_no");
            String companyName = resultSet.getString("company_name");
            String carName = resultSet.getString("car_name");
            String type = resultSet.getString("type");
            int noOfSeats = resultSet.getInt("no_of_seats");
            double rent = resultSet.getDouble("rent");
             
            Car car=new Car(companyName,carName,type, regNo, rent, noOfSeats);
            listCar.add(car);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCar;
    }
     
    public boolean deleteCar(Car car) throws SQLException {
        String sql = "DELETE FROM car where reg_no = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, car.getRegNo());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateCar(Car car) throws SQLException {
        String sql = "UPDATE car SET company_name=?, car_name=?, type=?, no_of_seats=?, rent=?";
        sql += " WHERE reg_no = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, car.getRegNo());
        statement.setString(2, car.getCompanyName());
        statement.setString(3, car.getCarName());
        statement.setString(4, car.getType());
        statement.setInt(5, car.getNoOfSeats());
        statement.setDouble(6, car.getRent());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Car getCar(String id) throws SQLException {
        Car car = null;
        String sql = "SELECT * FROM car WHERE reg_no = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String regNo = resultSet.getString("reg_no");
            String companyName = resultSet.getString("company_name");
            String carName = resultSet.getString("car_name");
            String type = resultSet.getString("type");
            int noOfSeats = resultSet.getInt("no_of_seats");
            double rent = resultSet.getDouble("rent");
             
            car=new Car(companyName,carName,type, regNo, rent, noOfSeats);
        }
         
        resultSet.close();
        statement.close();
         
        return car;
    }
}