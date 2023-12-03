import java.io.File;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;



public class Json{
    public static void main(String[] args) {
        try{
            File xmlFile = new File("noExiste.xml");
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode jsonNode = xmlMapper.readTree(xmlFile);

            ObjectMapper objectMapper = new ObjectMapper();
            String json =  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            System.out.println(json);

            File jsonFile = new File("bookings.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, jsonNode);
            System.out.println("Json file created");
        }catch(NullPointerException e){
            System.out.println("No existe el archivo");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}