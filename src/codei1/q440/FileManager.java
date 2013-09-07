package codei1.q440;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ファイル処理
 */
public class FileManager {
    public static RateManager fileToRates(String fileName) {
        RateManager mng = new RateManager();
        try {
            FileReader in = new FileReader(fileName);
            BufferedReader br = new BufferedReader(in);
            String line;
            String[] splited;
            while ((line = br.readLine()) != null) {
                splited = line.split("\t");
                mng.add(new Rate(splited[0], splited[1], splited[2]));
            }
            br.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return mng;
    }
}
