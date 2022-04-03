package mysql.labs;

import java.sql.*;
import java.util.ArrayList;


/*
*  MySQL Exercise 4:
*
*   Now that you have mastered your air travel database, it's time to connect this DB to a Java application
*   using JDBC. You can start simple here and build your way up. Within a Java application, using JDBC, please
*   demonstrate how to:
*
*   Note: CRUD means (Create, Read, Update, Delete)
*
*       1.) CRUD new flights
*       2.) CRUD new passengers
*       3.) Bonus: flex those JDBC muscles! How nice, clean, useful can you make this? Show us what you've got!
*
 */

public class Exercise_04 {

    public static void main(String[] args) {
        /*
        Just as a casual example - each of these operations should be in it's own method. Feel free to
        create all required classes/methods to accomplish this.

        createFlight(...);
        queryFlight(...);
        updateFlight(...);
        deleteFlight(...);

        createPassenger(...);
        queryPassenger(...);
        updatePassenger(...);
        deletePassenger(...);
         */

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/air_travel?user=default" +
                            "&password=fakepassword&useSSL=false");

            //Populate ArrayList with current flights objects
            preparedStatement = connection.prepareStatement("SELECT * FROM air_travel.flights");
            resultSet = preparedStatement.executeQuery();
            flights = mapToFlights(resultSet);

            //Populate ArrayList with current passengers
            preparedStatement = connection.prepareStatement("SELECT * FROM air_travel.passengers");
            resultSet = preparedStatement.executeQuery();
            passengers = mapToPassengers(resultSet);


            //1) CRUD Flights
            //createFlight(connection);
            //queryFlights(connection);
            //updateFlight(connection);
            //deleteFlight(connection, "3");

            //2) CRUD Passengers
            //System.out.println(queryPassenger(passengers, "kyle"));
            //System.out.println(queryPassenger(passengers, "brandon"));
            //createPassenger(connection);
            //updatePassenger(connection);
            //deletePassenger(connection, "4");

            //3) Bonus: Give Flight Information for a Passenger
            flightInfo(connection);

        } catch(SQLException e){
            System.out.println("SQL exception");
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println("Driver not found on class path");
            e.printStackTrace();
        } finally{
            try{
                preparedStatement.close();
                resultSet.close();
                connection.close();
            } catch(SQLException e){
                System.out.println("Failed to close");
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Flight> mapToFlights(ResultSet resultSet) throws SQLException{

        ArrayList<Flight> flights = new ArrayList<>();

        while(resultSet.next()){
            Flight holder = new Flight();

            holder.setId(resultSet.getInt("id"));
            holder.setStart_id(resultSet.getInt("start_id"));
            holder.setEnd_id(resultSet.getInt("end_id"));
            holder.setAirline_id(resultSet.getInt("airline_id"));
            holder.setDate(resultSet.getString("flight_time"));

            flights.add(holder);
        }

        return flights;
    }

    public static ArrayList<Passenger> mapToPassengers(ResultSet resultSet) throws SQLException{

        ArrayList<Passenger> passengers = new ArrayList<>();

        while(resultSet.next()){
             Passenger passenger = new Passenger();

             passenger.setId(resultSet.getInt("id"));
             passenger.setFirst_name(resultSet.getString("first_name"));
             passenger.setLast_name(resultSet.getString("last_name"));
             passenger.setEmail(resultSet.getString("email"));
             passenger.setMealPref(resultSet.getString("meal_pref"));

             passengers.add(passenger);
        }

        return passengers;
    }


    //Queries All flights from MySQL
    public static void queryFlights(Connection connection) throws  SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT f.id AS flight_id, l.name as start_name, loc.name " +
                "as destination, a.name AS airline_name, f.flight_time AS date_of_flight " +
                "FROM flights f " +
                "INNER JOIN locations l " +
                "ON f.start_id = l.id " +
                "INNER JOIN locations loc " +
                "ON f.end_id = loc.id " +
                "INNER JOIN airlines a " +
                "ON f.airline_id = a.id " +
                "ORDER BY f.id ASC");

        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Flight Information: \n");

        while(resultSet.next()){
            int id = resultSet.getInt("flight_id");
            String start = resultSet.getString("start_name");
            String destination = resultSet.getString("destination");
            String arline = resultSet.getString("airline_name");
            String date = resultSet.getString("date_of_flight");

            System.out.println("Flight ID: " + id + "\n" +
            "Flying from " + start + " to " + destination + " using airline " + arline + " on " + date);
            System.out.println();
        }
    }

    public static boolean createFlight(Connection connection) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO air_travel.flights VALUES  (? , ? , ? , ?, ?)");
        preparedStatement.setInt(1, 36);
        preparedStatement.setInt(2, 6);
        preparedStatement.setInt(3, 10);
        preparedStatement.setInt(4, 4);
        preparedStatement.setString(5, "2022-10-03");

        int y = preparedStatement.executeUpdate();

        if(y==1){
            System.out.println("New Flight Successfully added");
            return true;
        }
        System.out.println("New Flight was not added");
        return  false;
    }

    public static boolean updateFlight(Connection connection) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE air_travel.flights SET airline_id = 8 " +
                "WHERE id = 16");
        int x = preparedStatement.executeUpdate();

        if(x == 1){
            System.out.println("Successfully updated flight");
            return true;
        }

        System.out.println("Flight not updated");
        return false;
    }

    public static void deleteFlight(Connection connection, String id)throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from air_travel.flights WHERE id = ?");
        preparedStatement.setString(1, id);
        int x = preparedStatement.executeUpdate();

    }

    //Queries Individual Passenger from Passenger Class
    public static String queryPassenger(ArrayList<Passenger> passengers, String name){

        for(Passenger p : passengers){
            if(p.getFirst_name().equals(name)){
                return p.toString();
            }
        }

        return "Passenger not on System";
    }

    public static boolean createPassenger(Connection connection)throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO air_travel.passengers VALUES" +
                " (? , ? , ? , ? , ?) ");
        preparedStatement.setInt(1, 21 );
        preparedStatement.setString(2, "Draco");
        preparedStatement.setString(3, "Malfoy");
        preparedStatement.setString(4, "draco@hogwarts.com");
        preparedStatement.setString(5, "chicken");

        int x = preparedStatement.executeUpdate();

        if(x == 1){
            System.out.println("Successfully added new Passenger");
            return true;
        }
        System.out.println("Could not add new Passenger");
        return false;
    }

    public static boolean updatePassenger(Connection connection) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE air_travel.passengers SET last_name = " +
                "'Weasley' WHERE id = 18" );
        int x = preparedStatement.executeUpdate();

        if(x==1){
            System.out.println("Successfully updated Passenger");
            return true;
        }
        System.out.println("Could not update Passenger");
        return false;
    }

    public static void deletePassenger(Connection connection, String id) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM air_travel.passengers WHERE" +
                " id = " + id);
        preparedStatement.executeUpdate();
    }

    public static void flightInfo(Connection connection)throws SQLException{

        String name = "kyle";

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "p.first_name, p.last_name, f.id, l.name AS start, loc.name AS destination, f.flight_time , p.meal_pref " +
                "FROM tickets t " +
                "INNER JOIN passengers p " +
                "ON t.passenger_id = p.id " +
                "INNER JOIN flights f " +
                "ON t.flight_id = f.id " +
                "INNER JOIN locations l " +
                "ON f.start_id = l.id " +
                "INNER JOIN locations loc " +
                "ON f.end_id = loc.id " +
                " WHERE p.first_name = '" + name + "'" );

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int flightId = resultSet.getInt("id");
            String start = resultSet.getString("start");
            String destination = resultSet.getString("destination");
            String date = resultSet.getString("flight_time");
            String mealPref = resultSet.getString("meal_pref");

            System.out.println("Passenger Flight Details:");
            System.out.println(firstName + " " + lastName + " is on flight no: " + flightId);
            System.out.println("Travelling from: " + start + " to " + destination +  " on " + date );
            System.out.println("Meal Preference: " + mealPref);
        }
    }

}
