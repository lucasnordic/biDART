package dart.tools;

import java.io.*;
import java.util.Scanner;

public class FileReader extends Reader {

    public void fileReader() throws IOException {
        FileReader file = new FileReader();
        BufferedReader fileInput = new BufferedReader(file);

        for (int i = 0; i < 3; i++) {
            System.out.println(fileInput.readLine());
        }
        fileInput.close();
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}

//package dart.storage;
//
//        import java.io.*;
//        import java.util.Scanner;
//
//
//public class Storage extends Reader {
//    private static String filePath = "./files/storage.txt";
//
//
//
//    public void readStorage() {
//        try {
////            FileOutputStream fs = new FileOutputStream("foo.ser");
////            ObjectInputStream os = new ObjectInputStream(fs);
////            os.
////            os.c
//            File myFile = new File(filePath);
//
//            if (!myFile.exists()) {
//                myFile.getParentFile().mkdirs();
//                myFile.createNewFile();
//                writeStorage();
//            }
//
//            Scanner myScanner = new Scanner(myFile);
//            while (myScanner.hasNextLine()) {
//                System.out.println(myScanner.nextLine());
//            }
//        } catch (IOException e) {
//            System.out.println("The file was not found");
//            e.printStackTrace();
//        }
////        FileReader file = new FileReader();
////        BufferedReader fileInput = new BufferedReader(file);
////
////        for (int i = 0; i < 3; i++) {
////            System.out.println(fileInput.readLine());
////        }
////        fileInput.close();
//    }
//
//    public static void writeStorage() {
//        try {
//            FileWriter myWriter = new FileWriter(filePath);
//            myWriter.write("test");
//            myWriter.close();
//        } catch (IOException e) {
//            System.out.println("Something wrong happened.");
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public int read(char[] cbuf, int off, int len) throws IOException {
//        return 0;
//    }
//
//    @Override
//    public void close() throws IOException {
//
//    }
//}
