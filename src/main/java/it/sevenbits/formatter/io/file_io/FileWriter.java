package it.sevenbits.formatter.io.file_io;

import it.sevenbits.formatter.io.core_io.CloseException;
import it.sevenbits.formatter.io.core_io.IClosable;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * FileWriter implementation.
 */
public class FileWriter implements IWriter, IClosable {

    private Writer writer;

    /**
     * Constructor FileWriter.
     * @param pathFile The path to the file.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    public FileWriter(final String pathFile) throws WriterException {
        try {
            FileSystem fileSystem = FileSystems.getDefault();
            Path path = fileSystem.getPath(pathFile);
            writer = new OutputStreamWriter(Files.newOutputStream(path), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new WriterException("Error IO", e);
        }
    }

    /**
     * Write to file.
     * @param s String to write.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    public void write(final String s) throws WriterException {
        try {
            writer.write(s);
        } catch (Exception e) {
            throw new WriterException("Error IO", e);
        }
    }

    /**
     * Close file.
     * @throws CloseException Failed or interrupted I/O operations.
     */
    public void close() throws CloseException {
        try {
            writer.close();
        } catch (Exception e) {
            throw new CloseException("Error", e);
        }
    }
}
