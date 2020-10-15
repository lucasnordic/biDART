package dart.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

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
