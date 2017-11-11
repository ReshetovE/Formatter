package it.sevenbits.formatter.file_io;

import it.sevenbits.formatter.core.CloseException;
import it.sevenbits.formatter.core.IClosable;
import it.sevenbits.formatter.core.IReader;
import it.sevenbits.formatter.core.ReaderException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * FileReader implementation.
 */
public class FileReader implements IReader, IClosable {

    private Reader reader;
    private int idChar;

    /**
     * Constructor FileReader.
     * @param pathFile The path to the file.
     * @throws ReaderException If file not found.
     */
    public FileReader(final String pathFile) throws ReaderException {
        try {
            FileSystem fileSystem = FileSystems.getDefault();
            Path path = fileSystem.getPath(pathFile);
            reader = new InputStreamReader(Files.newInputStream(path), "UTF8");
        } catch (IOException e) {
            throw new ReaderException("File not found", e);
        }
    }

    /**
     * Checker char.
     * @return Checker last character.
     * @throws ReaderException  Failed or interrupted I/O operations.
     */
    public boolean hasChars() throws ReaderException {
        try {
            idChar = reader.read();
            return idChar > -1;
        } catch (IOException e) {
            throw new ReaderException("Error IO", e);
        }
    }

    /**
     * ReadChar method.
     * @return Read character.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    public char readChar() throws ReaderException {
        return (char) idChar;
    }

    /**
     * Close file method.
     * @throws CloseException Failed or interrupted I/O operations.
     */
    public void close() throws CloseException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new CloseException("Error", e);
        }
    }
}