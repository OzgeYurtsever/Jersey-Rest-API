package com.image.app.restApi;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lib")
public class FileResource {
   
   Model model = new Model();
   
    @GET
    @Path("/images/{filename}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultOnFileName getDetailsForFile(@PathParam("filename") String fileName) throws Exception {
       List<RawData> queryResult = model.getOnFile(fileName);
       List<FormattedAnnotation> annotations = new ArrayList<FormattedAnnotation>();

       for (RawData data : queryResult) {
          annotations.add(createAnnotationObject(data));
       }       
       ResultOnFileName result = new ResultOnFileName(fileName, annotations);
       return result;
    }
     
    @GET
    @Path("/images/{filename}/users/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultOnFileName getDetailsForFileAndUser(@PathParam("filename") String fileName, 
                                           @PathParam("username") String userName) throws Exception {
       List<RawData> queryResult = model.getOnFileAndUser(fileName, userName);
       List<FormattedAnnotation> annotations = new ArrayList<FormattedAnnotation>();

       for (RawData data : queryResult) {
          annotations.add(createAnnotationObject(data));
       }
       ResultOnFileName result = new ResultOnFileName(fileName, annotations);
       return result;
    }
    
    @GET
    @Path("/users/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultOnUserName getDetailsForUser(@PathParam("username") String userName) throws Exception {
       List<RawData> queryResult = model.getOnUser(userName);
       List<ResultOnFileName> files = new ArrayList<ResultOnFileName>();
       
       String fileName = queryResult.get(0).getFileName();
       List<FormattedAnnotation> annotations = new ArrayList<FormattedAnnotation>();

       for (int i = 0; i < queryResult.size(); i++) {
          RawData data = queryResult.get(i);
          if (fileName.equalsIgnoreCase(data.getFileName())) {
             if (i + 1 == queryResult.size()) {
                annotations.add(createAnnotationObject(data));
                files.add(new ResultOnFileName(fileName, annotations));
                break;
             }            
             annotations.add(createAnnotationObject(data));
          } else {
             files.add(new ResultOnFileName(fileName, annotations));
             fileName = data.getFileName();
             annotations = new ArrayList<FormattedAnnotation>();
             annotations.add(createAnnotationObject(data));
          }         
       }
       ResultOnUserName result = new ResultOnUserName(userName, files);
       return result;     
    }  
    
    @GET
    @Path("/images/{filename}/users/{username}/annotations/{aimname}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultOnAll getDetailsForAllData(@PathParam("filename") String fileName, 
          @PathParam("username") String userName,
          @PathParam("aimname") String aimName) throws Exception {
       
       List<RawData> queryResult = model.getOnAll(fileName, userName, aimName);
       ResultOnAll result = new ResultOnAll();
       if (queryResult.size() > 1) {
          List<Coordinate> coordinates = new ArrayList<>();
          for (RawData data : queryResult) { 
             coordinates.add(new Coordinate(data.getStartX(), data.getStartY()));
             coordinates.add(new Coordinate(data.getEndX(), data.getEndY()));             
          }
          result = new ResultOnAll(fileName, userName, aimName, coordinates);
       } else if (queryResult.size() == 1) {
          RawData data = queryResult.get(0);
          List<Coordinate> coordinates = new ArrayList<>();
          coordinates.add(new Coordinate(data.getStartX(), data.getStartY()));
          coordinates.add(new Coordinate(data.getEndX(), data.getEndY())); 
          result = new ResultOnAll(fileName, userName, aimName, coordinates);
       }
      return result;       
    } 

    @POST
    @Path("/images/{filename}/users/{username}/annotations/{aimname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postAllData(@PathParam("filename") String fileName, 
                               @PathParam("username") String userName,
                               @PathParam("aimname") String aimName, RawData reqBody) throws Exception {
       String msg = "post sent!";       
       model.postAllData(userName, fileName, aimName, 
         reqBody.getStartX(), reqBody.getStartY(), reqBody.getEndX(), reqBody.getEndY());
       return Response.status(200).entity(msg).build();
    }
        
    private FormattedAnnotation createAnnotationObject(RawData data) {      
       List<Coordinate> coordinates = new ArrayList<>();
       coordinates.add(new Coordinate(data.getStartX(), data.getStartY()));
       coordinates.add(new Coordinate(data.getEndX(), data.getEndY()));
       return new FormattedAnnotation(data.getId(), data.getAnnotationName(), data.getUserName(), coordinates);
    }
}
