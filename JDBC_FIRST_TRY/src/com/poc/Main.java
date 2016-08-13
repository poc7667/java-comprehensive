package com.poc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        String dbPassword = "";

        System.out.printf("Enter DB password: ");
        dbPassword = sc.nextLine().trim();

        String conn_url  = "jdbc:postgresql://localhost:5432/ezFly_development";
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            Connection conn = DriverManager.getConnection(conn_url, "postgres", dbPassword);
            Statement stmt = conn.createStatement();
            String sql = "select * from cities";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                for (int i=1;i< 7;i++){
                    System.out.printf("%s\t", rs.getString(i));
                }
                System.out.println();
            }
        }catch (Exception e){

        }

    }
}

