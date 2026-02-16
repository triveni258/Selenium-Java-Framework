package Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    @Test
    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

        // Read JSON to String
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty
                ("user.dir") + "/src/test/resources/Data/PurchaseOrder.json"),
                StandardCharsets.UTF_8);

        // String to HashMap - Jackson Databind
        ObjectMapper mapper = new ObjectMapper();

        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {});

        return data;
    }
}
