package com.image.app.restApi;

import java.util.ArrayList;
import java.util.List;

public class FormattedAnnotation
{
   private String annotationName;
   private String userName;
   private int id;
   private List<Coordinate> coordinates = new ArrayList<>();
     
   FormattedAnnotation() {
      
   }
   
   FormattedAnnotation(int id, String annotationName, String userName, List<Coordinate>coor) {
      setAnnotationName(annotationName);
      setUserName(userName);
      setCoordinates(coor);
      setId(id);
   }
   
   public int getId() {
      return this.id;
   }
   
   public void setId(int id) {
      this.id = id ;
   }
   
   public String getAnnotationName() {
      return this.annotationName;
   }
   
   public void setAnnotationName(String annotation) {
      this.annotationName = annotation;
   }
   
   public String getUserName() {
      return this.userName;
   }
   
   public void setUserName(String user) {
      this.userName = user;
   } 
  
   public List<Coordinate> getCoordinates() {
      return this.coordinates;
   }
   
   public void setCoordinates(List<Coordinate> coordinates) {
      this.coordinates = coordinates;
   }   
}


