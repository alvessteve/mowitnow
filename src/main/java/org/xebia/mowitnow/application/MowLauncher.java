package org.xebia.mowitnow.application;

import org.xebia.mowitnow.adapter.InstructionPort;
import org.xebia.mowitnow.infrastructure.di.DependencyInjector;

public class MowLauncher {


    public static void main(String... args){
        if(args.length == 1){
            initializeFromFile(args[0]);
        } else {
            initializeFromInput(args);
        }
    }

    private static void initializeFromInput(String[] args) {
        InstructionPort instructionPort = DependencyInjector.newInstructionPort();
        for(String arg : args){
            instructionPort.translate(arg);
        }
    }

    private static void initializeFromFile(String arg) {
        String filepath = arg;
        DataService dataService = DependencyInjector.newDataService();
        dataService.readFile(filepath);
    }

}
