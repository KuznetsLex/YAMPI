package org.kuzne.labs.lab7;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOStream {
    public static void writeArrayBin(int[] buf, OutputStream out) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(out)) {
            for (int i = 0; i < buf.length; i++) {
                dos.writeInt(buf[i]);
            }
        }
    }

    public static int[] readArrayBin(int n, InputStream in) throws IOException {
        try(DataInputStream dos = new DataInputStream(in)) {
            int[] buf = new int[n];
            for (int i = 0; i < buf.length; i++) {
                buf[i] = dos.readInt();
            }
            return buf;
        }
    }

    public static void writeArrayChar(int[] buf, Writer out) throws IOException {
        try (PrintWriter pw = new PrintWriter(out))
        {
            for (int i = 0; i < buf.length; i++) {
                pw.print(buf[i]);
                if (i <  buf.length-1) {
                    pw.print(" ");
                }
            }
        }
    }


    public static int[] readArrayChar(int n, Reader in) throws IOException {
        int[] buf = new int[n];
        try (Reader dw = new BufferedReader(in))
        {
            for (int i =0; i < n; i++) {
                buf[i] = dw.read();
            }
        }
        return buf;
    }

    public static int[] RandomAccessFileReader(int startPos) throws IOException {
        File file = new File("src/main/java/org/kuzne/labs/lab7/lab7.txt");
        try (RandomAccessFile fileAccess = new RandomAccessFile(file, "r");) {
            fileAccess.seek(startPos);
            int[] buf = new int[(int) ((fileAccess.length()-fileAccess.getFilePointer()))];
            for (int i = 0; i < (buf.length); i++) {
                buf[i] = fileAccess.read();
            }
            return buf;
        }
    }

    public static String[] fileExtensionFinder(String extension, String dir) {
        File currentDir = new File(dir);
        return currentDir.list(new ExtensionFilter(extension));
    }

    public static void fileAdvancedFinder(String regex, String dir, Writer in) throws IOException {
        File currentDir = new File(dir);
        findFiles(currentDir.listFiles(), regex, in);
    }
    public static void findFiles(File[] files,  String regex, Writer in) throws IOException {
        for (File file : files) {
            RegexFilter filter = new RegexFilter(regex);
            if (filter.accept(file, file.getName())) {
                in.write(file.getAbsolutePath());
                in.write("\n");
            }
            if (file.isDirectory()) {
                findFiles(file.listFiles(), regex, in);
            }
        }
    }
}
