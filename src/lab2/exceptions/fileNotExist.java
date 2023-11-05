package lab2.exceptions;

import java.io.FileNotFoundException;

public class fileNotExist extends FileNotFoundException {
    public fileNotExist(String message) {
        super(message);
    }
}
