package org.kuzne.labs.lab7;

import java.io.*;

public class IOStream {
    public static void writeArrayBin(byte[] buf, OutputStream out) throws IOException {
        out.write(buf);
    }

    public static byte[] readArrayBin(int n, InputStream in) throws IOException {
        byte[] buf = new byte[n];
        in.read(buf, 0, n);
        return buf;
    }
}
