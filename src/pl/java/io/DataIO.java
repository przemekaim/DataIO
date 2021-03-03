package pl.java.io;

import java.io.*;

public class DataIO {

    public static void writeFixedString(String name, int size, DataOutputStream out) throws IOException {
        for (int i = 0; i < size; i++) {
            char c = 0;
            if (i < name.length())
                c = name.charAt(i);
            out.writeChar(c);
        }
    }

    public static String readFixedString(int size, RandomAccessFile in) throws IOException {
        var b = new StringBuilder(size);
        int i = 0;
        var done = false;
        while (!done && i < size) {
            char c = in.readChar();
            i++;
            if (c == 0)
                done = true;
            else
                b.append(c);
        }
        in.skipBytes(2 * (size - i));
        return b.toString();
    }
}
