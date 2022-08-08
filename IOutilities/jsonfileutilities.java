public class jsonfileutilities {
    
    public String jsonString;
    try (InputStream is = new ByteArrayInputStream(jsonString.getBytes()) {
        JsonReader reader = Json.createReader(is); 
        JsonObject data = reader.readObject();
    }catch(IOException e){
        
    }
}