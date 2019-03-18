package xyz.zhangyi.practicejava.ut;

import java.rmi.server.ExportException;
import java.util.Random;

public class FileServerUtil {
    private static Random rand = new Random(47);

    public static String getRandomServer(String fileServer) {
        if (fileServer == null || fileServer == "") {
            throw new FileServerException("No server configurated.");
        }
        String[] urlArr = fileServer.split(",");
        int idx = rand.nextInt(2);
        return urlArr[idx].trim();
    }
}
