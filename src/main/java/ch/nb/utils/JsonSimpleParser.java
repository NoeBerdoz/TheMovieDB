package ch.nb.utils;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class JsonSimpleParser {
    public static void parseJson(String jsonString) throws JsonException {

        System.out.println(jsonString);

        JsonObject jsonObject = (JsonObject) Jsoner.deserialize(jsonString);
        System.out.println(jsonObject.get("title"));
    }
}
