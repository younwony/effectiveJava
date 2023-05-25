package dev.wony.effectivejava.chapter_2.item_9;

import java.io.*;

/**
 * 아이템 9. try-finally보다는 try-with-resources를 사용하라
 */
public class item_9 {
    public static void main(String[] args) {

    }

    static String firstLineOfFile(String path)  {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return "Error";
        }
    }

    static void copy(String src, String dst) throws Exception {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[100];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
}
