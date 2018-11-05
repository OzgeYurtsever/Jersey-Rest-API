package com.image.app.restApi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Model
{
    DBConnection dBConObj = new DBConnection();
   
    public ArrayList<RawData> getOnAll(String fileName, String userName, String annotationName) throws Exception {
       ArrayList<RawData> allData = new ArrayList<>();
       Connection connect = null;
       Statement statement = null;  
       ResultSet result = null;
       try {
          connect = dBConObj.connectDataBase();
          statement = connect.createStatement();
          String sql = "select * from annotations where file_name = '" + fileName + "' and user = '"
                + userName + "' and ann_name = '" + annotationName +"'";
          
          result = statement.executeQuery(sql);
          while(result.next()) {  
             allData.add(createRawDataObject(result));
          }
          return allData;
       } catch (Exception e) {
          throw e;     
       } finally {
          close(result, statement, connect);       
       }    
    }
    
   public void postAllData(String userName, String file, String annotation, 
         int startx, int starty, int endx, int endy) throws Exception {
      Connection connect = null;
      Statement statement = null;

      try {
         connect = dBConObj.connectDataBase();
         statement = connect.createStatement();
          String sql = "insert into annotations(user, file_name, ann_name, start_x, start_y, end_x, end_y) values('" +
                userName + "','" + file + "','" + annotation + "'," + startx + "," + starty + "," + endx + "," + endy +")";
          statement.executeUpdate(sql);
      } catch (Exception e) {
         throw e;     
      } finally {
         close(null, statement, connect);       
      }
   }
   
   public ArrayList<RawData> getOnFile(String fileName) throws Exception {
      ArrayList<RawData> allData = new ArrayList<>();
      Connection connect = null;
      Statement statement = null;  
      ResultSet result = null;
      try {
         connect = dBConObj.connectDataBase();
         statement = connect.createStatement();
          String sql = "select * from annotations where file_name = '" + fileName + "'";
          
          result = statement.executeQuery(sql);
          while(result.next()) {  
             allData.add(createRawDataObject(result));
          }
          return allData;
      } catch (Exception e) {
         throw e;     
      } finally {
         close(result, statement, connect);       
      }    
   }
   
   public ArrayList<RawData> getOnFileAndUser(String fileName, String userName) throws Exception {
      ArrayList<RawData> allData = new ArrayList<>();
      Connection connect = null;
      Statement statement = null;  
      ResultSet result = null;
      try {
         connect = dBConObj.connectDataBase();
         statement = connect.createStatement();
          String sql = "select * from annotations where file_name = '" + fileName + "' and user = '" + userName + "'";
          
          result = statement.executeQuery(sql);
          while(result.next()) {  
             allData.add(createRawDataObject(result));
          }
          return allData;
      } catch (Exception e) {
         throw e;     
      } finally {
         close(result, statement, connect);       
      }      
   }
   
   public ArrayList<RawData> getOnUser(String userName) throws Exception {
      ArrayList<RawData> allData = new ArrayList<>();
      Connection connect = null;
      Statement statement = null;  
      ResultSet result = null;
      try {
         connect = dBConObj.connectDataBase();
         statement = connect.createStatement();
          String sql = "select * from annotations where user = '" + userName + "'";
          
          result = statement.executeQuery(sql);
          while(result.next()) {  
             allData.add(createRawDataObject(result));
          }
          return allData;
      } catch (Exception e) {
         throw e;     
      } finally {
         close(result, statement, connect);       
      }    
   }
   
   public void close(ResultSet resultSet, Statement statement, Connection connect) {
      try {
          if (resultSet != null) {
              resultSet.close();
          }

          if (statement != null) {
              statement.close();
          }

          if (connect != null) {
              connect.close();
          }
      } catch (Exception e) {

      }
  }
   
   private RawData createRawDataObject(ResultSet result) throws SQLException {
      RawData ann = new RawData();
      ann.setId(result.getInt("id"));
      ann.setUserName(result.getString("user"));
      ann.setFileName(result.getString("file_name"));
      ann.setAnnotationName(result.getString("ann_name"));
      ann.setStartX(result.getInt("start_x"));
      ann.setStartY(result.getInt("start_y"));
      ann.setEndX(result.getInt("end_x"));
      ann.setEndY(result.getInt("end_y"));      
      return ann;
   }
}