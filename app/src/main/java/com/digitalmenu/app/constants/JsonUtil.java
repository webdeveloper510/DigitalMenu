package com.digitalmenu.app.constants;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;



public class JsonUtil {
    private static final JsonParser PARSER = new JsonParser();
    private static final String API = "http://45.132.125.252:8080";
    private static final Gson gson = new Gson();

    public static JsonArray request(String content) throws IOException {
        return request(objectFromString(content));
    }

    public static JsonArray request(JsonObject post) throws IOException {
        URL url = new URL(API);
        String content = post.toString();
        byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", Integer.toString(contentBytes.length));

        OutputStream os = connection.getOutputStream();
        os.write(contentBytes, 0, contentBytes.length);
        os.close();

        BufferedReader rs = (connection.getResponseCode() == 200) ?
                new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) :
                new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));

        StringBuilder extracted = new StringBuilder();
        String line = rs.readLine();
        while(line != null) {
            extracted.append(line);
            line = rs.readLine();
        }
        rs.close();
        connection.disconnect();
        return arrayFromString(extracted.toString());
    }


   /* public static BufferedImage[] getImagesFromJson(JsonArray json) {
        BufferedImage[] bufferedImages = new BufferedImage[json.size()];
        for (int i = 0; i < json.size(); i++) {
            try {
                JsonObject jsonObject = JsonUtil.objectFromString(json.get(i).toString());
                byte[] data = JsonUtil.gson().fromJson(jsonObject.get("image").toString().replace("\"", ""), byte[].class);
                InputStream inputStream = new ByteArrayInputStream(data);
                BufferedImage bufferedImage = ImageIO.read(inputStream);
                bufferedImages[i] = bufferedImage;
            }catch(Exception ignored) {
                // maybe handle error appropriately
            }
        }
        return bufferedImages;
    }
*/
    public static JsonObject objectFromString(String jsonString) {
        JsonObject jsonObject = new JsonObject();
        if ((jsonString != null) && !(jsonString.isEmpty())) {
            jsonObject = (JsonObject) PARSER.parse(jsonString.replaceAll("\\s",""));
        }
        return jsonObject;
    }

    public static JsonArray arrayFromString(String jsonString) {
        JsonArray jsonArray = new JsonArray();
        if ((jsonString != null) && !(jsonString.isEmpty())) {
            jsonArray = PARSER.parse(jsonString.replaceAll("\\s","")).getAsJsonArray();
        }
        return jsonArray;
    }

    public static Gson gson() {
        return gson;
    }
}

