package it.sevenbits.formatter.io.file_io;

import it.sevenbits.formatter.io.core_io.CloseException;
import it.sevenbits.formatter.io.core_io.IClosable;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.ReaderException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * FileReader implementation.
 */
public class FileReader implements IReader, IClosable {

    private Reader reader;
    private int readChar = -1;

    /**
     * Constructor FileReader.
     * @param pathFile The path to the file.
     * @throws ReaderException If file not found.
     */
    public FileReader(final String pathFile) throws ReaderException {
        try {
            FileSystem fileSystem = FileSystems.getDefault();
            Path path = fileSystem.getPath(pathFile);
            reader = new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8);
            readChar = reader.read();
        } catch (Exception e) {
            throw new ReaderException("File not found", e);
        }
    }

    /**
     * Checker char.
     * @return Checker last character.
     * @throws ReaderException  Failed or interrupted I/O operations.
     */
    public boolean hasChars() throws ReaderException {
            return readChar > -1;
    }

    /**
     * ReadChar method.
     * @return Read character.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    public char nextChar() throws ReaderException {
        int prevChar = readChar;
        try {
            readChar = reader.read();
        } catch (IOException e) {
            throw new ReaderException("File not found", e);
        }
        return (char) prevChar;
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