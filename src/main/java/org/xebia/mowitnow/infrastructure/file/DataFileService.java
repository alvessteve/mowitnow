package org.xebia.mowitnow.infrastructure.file;

import org.xebia.mowitnow.application.DataService;
import org.xebia.mowitnow.adapter.InstructionPort;
import org.xebia.mowitnow.infrastructure.validator.StringValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataFileService implements DataService {

    private final InstructionPort instructionPort;

    public DataFileService(InstructionPort instructionPort) {
        this.instructionPort = instructionPort;
    }

    @Override
    public void readFile(String filepath) {
        if(StringValidator.isNullorEmpty(filepath))
            throw new IllegalArgumentException("A file path must be provided");
        Stream<String> linesStream = null;
        try{
            Path path = Paths.get(filepath);
            linesStream = Files.lines(path);
            linesStream.forEach(instructionPort::translate);
        } catch(IOException e){
            throw new IllegalStateException("An error occured when parsing the file", e);
        } finally {
            if(linesStream != null)
                linesStream.close();
        }

    }

}
