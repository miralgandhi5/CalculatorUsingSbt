package com.calculator;

import com.calculator.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operation {

    private Double leftOperand;
    private Double rightOperand;
    private String operator;
    private Double result;
    private Timestamp timestamp;

    public Double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(Double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public Double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(Double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Operation{" + "leftOperand=" + leftOperand +
                ", rightOperand=" + rightOperand +
                ", operator=" + operator +
                ", result=" + result +
                ", timestamp=" + timestamp +
                '}';
    }

    public Operation(Double leftOperand, Double rightOperand, String operator, Double result, Timestamp timestamp) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
        this.result = result;
        this.timestamp = timestamp;
    }

    public Boolean addOperation() {

        DbConnection dbConnection = DbConnection.getInstance();
        try {
            PreparedStatement preparedStatement = dbConnection.con.prepareStatement("insert into operations (left_operand,right_operand,operator,result,timestamp) values (?,?,?,?,?)");
            preparedStatement.setTimestamp(5, this.timestamp);
            preparedStatement.setDouble(1, this.leftOperand);
            preparedStatement.setDouble(2, this.rightOperand);
            preparedStatement.setString(3, this.operator);
            preparedStatement.setDouble(4, this.result);
            int res = preparedStatement.executeUpdate();
            if (res > 0)
                return true;


        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                dbConnection.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static List<Operation> readOperation() {

        DbConnection dbConnection = DbConnection.getInstance();
        List<Operation> operationList = new ArrayList<>();

        try {
            Statement statement = dbConnection.con.createStatement();
            ResultSet rs = statement.executeQuery("select * from operations");
            System.out.println(rs);
            while (rs.next()) {
                Operation operation = new Operation(rs.getDouble(2), rs.getDouble(3), rs.getString(4), rs.getDouble(5), rs.getTimestamp(6));
                operationList.add(operation);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return operationList;


    }

    public static List<Operation> readSpecificOperation(String operator) {

        DbConnection dbConnection = DbConnection.getInstance();
        List<Operation> operationList = new ArrayList<>();

        try {
            PreparedStatement stmt = dbConnection.con.prepareStatement("select * from operations where operator=?");
            stmt.setString(1, operator);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Operation operation = new Operation(rs.getDouble(2), rs.getDouble(3), rs.getString(4), rs.getDouble(5), rs.getTimestamp(6));
                operationList.add(operation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return operationList;


    }
}

