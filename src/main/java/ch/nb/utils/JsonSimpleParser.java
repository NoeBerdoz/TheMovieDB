package ch.nb.utils;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class JsonSimpleParser {
    public static void printJson(String jsonString) throws JsonException {
        JsonObject jsonObject = (JsonObject) Jsoner.deserialize(jsonString);
        System.out.println((Number) jsonObject.get("page"));
    }
}
