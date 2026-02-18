package Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;



public class DataReader {



    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        String jsonContent = FileUtils.readFileToString
                (new File(System.getProperty
                        ("user.dir") + "/src/test/resources/Data/PurchaseOrder.json"),
                        StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data =
                (List)mapper.readValue(jsonContent,
                        new TypeReference<List<HashMap<String,String>>>() {
        });
        return data;
    }
}
