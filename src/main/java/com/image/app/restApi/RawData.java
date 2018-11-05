package com.image.app.restApi;

public class RawData
{
   private int id;
   private String fileName;
   private String annotationName;
   private String userName;
   private int startX;
   private int startY;
   private int endX;
   private int endY;
   
   public int getId() {
      return this.id;
   }
   
   public void setId(int id) {
      this.id = id;
   }
   
   public String getFileName() {
      return this.fileName;
   }
   
   public void setFileName(String file) {
      this.fileName = file;
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
   
   public int getStartX() {
      return this.startX;
   }
   
   public void setStartX(int startx) {
      this.startX = startx;
   }

   public int getStartY() {
      return this.startY;
   }
   
   public void setStartY(int starty) {
      this.startY = starty;
   }
   
   public int getEndX() {
      return this.endX;
   }
   
   public void setEndX(int endx) {
      this.endX = endx;
   }
   
   public int getEndY() {
      return this.endY;
   }
   
   public void setEndY(int endY) {
      this.endY = endY;
   }
   
   
}
