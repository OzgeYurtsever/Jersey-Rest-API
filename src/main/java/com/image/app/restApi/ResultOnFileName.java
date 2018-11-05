package com.image.app.restApi;

import java.util.List;

public class ResultOnFileName
{
   private String fileName;
   private List<FormattedAnnotation> annotations;
   
   ResultOnFileName() {

   }
   
   ResultOnFileName(String fileName, List<FormattedAnnotation> annotations) {
      setFileName(fileName);
      setAnnotationList(annotations);
   }
   
   public void setFileName(String fileName) {
      this.fileName = fileName;
   }
   
   public void setAnnotationList(List<FormattedAnnotation> list) {
      this.annotations = list;
   }
   
   public String getFileName() {
      return this.fileName;
   }
   
   public List<FormattedAnnotation> getAnnotationList() {
      return this.annotations;
   }
   
}
