package za.org.secret;

import java.io.*;
import java.nio.file.Paths;
import java.util.Map;

public class Downloader {
    public static void main(String[] args) throws IOException {
        Map<String, String> config = UtilFunctions.readConfig();

        fetchGamepack(config.get(Constants.CODEBASE_PROPERTY) + config.get(Constants.INITIAL_JAR));
    }

    private static void fetchGamepack(String gamepackUrl) throws IOException {
        InputStream bodyByteStream = UtilFunctions.fetch(gamepackUrl).body().byteStream();

        // Save the JAR file to disk
        File folder = new File(Paths.get(System.getProperty("user.home"), "gamepack").toString());
        if (!folder.exists())
        {
            folder.mkdir();
        }
        FileOutputStream outputStream = new FileOutputStream( folder + File.separator + Constants.OUTPUT_FILE_NAME); // Replace with your file path
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = bodyByteStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        bodyByteStream.close();
    }

}