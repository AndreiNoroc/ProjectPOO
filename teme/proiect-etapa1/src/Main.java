import com.fasterxml.jackson.databind.ObjectMapper;
import input.InputData;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
            System.out.println(args[0]);
            ObjectMapper obMap = new ObjectMapper();
            // obMap.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            InputData input = obMap.readValue(new File(args[0]), InputData.class);
            System.out.println(input);
    }
}
