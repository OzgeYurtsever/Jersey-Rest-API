package com.image.app.restApi;

import java.util.ArrayList;
import java.util.List;

public class ResultOnAll
{
   private String userName;
   private String fileName;
   private String annotationName;
   private List<Coordinate> coordinates = new ArrayList<>();

   ResultOnAll() {
      
   }
   
   ResultOnAll(String file, String user, String annotation, List<Coordinate> coor) {
      setUserName(user);
      setFileName(file);
      setAnnotationName(annotation);
      setCoordinates(coor);
   }
   
   public void setUserName(String user) {
      this.userName = user;
   }

   public String getUserName() {
      return this.userName;
    }
    
   public void setFileName(String file) {
      this.fileName = file;
   }

   public String getFileName() {
      return this.fileName;
    }
   
   public void setAnnotationName(String annotation) {
      this.annotationName = annotation;
   }

   public String getAnnotationName() {
      return this.annotationName;
    }
   
   public void setCoordinates(List<Coordinate> coor) {
      this.coordinates = coor;
   }
   
   public List<Coordinate> getCoordinates() {
      return this.coordinates;
   }
}
