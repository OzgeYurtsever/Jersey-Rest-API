package com.image.app.restApi;

import java.util.List;

public class ResultOnUserName
{
   private String username;
   private List<ResultOnFileName> files;
   
   ResultOnUserName() {
      
   }
   
   ResultOnUserName(String user, List<ResultOnFileName> fileList) {
      setUserName(user);
      setFiles(fileList);
   }
   
   public void setUserName(String user) {
      this.username = user;
   }
   
   public void setFiles(List<ResultOnFileName> fileList) {
      this.files = fileList;
   }
   
   public String getUserName() {
     return this.username;
   }
   
   public List<ResultOnFileName> getFiles() {
      return this.files;
   }
}
