package ch.nb.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// TODO rework this as PrettyJson instead of JsonParser
public class PrettyJsonWithGson {
    public static void printJson(String jsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(gson.fromJson(jsonString, Object.class));
        System.out.println(prettyJson);
    }
}
