package org.xebia.mowitnow.infrastructure.di;

import org.xebia.mowitnow.adapter.InstructionPort;
import org.xebia.mowitnow.adapter.InstructionPortImpl;
import org.xebia.mowitnow.application.DataService;
import org.xebia.mowitnow.domain.repository.GrassRepository;
import org.xebia.mowitnow.domain.repository.MowRepository;
import org.xebia.mowitnow.domain.service.*;
import org.xebia.mowitnow.infrastructure.PromptService;
import org.xebia.mowitnow.infrastructure.file.DataFileService;
import org.xebia.mowitnow.infrastructure.inmemory.InMemoryGrassRepository;
import org.xebia.mowitnow.infrastructure.inmemory.InMemoryMowRepository;

public class DependencyInjector {
    public static DataService newDataService(){
        return new DataFileService(newInstructionPort());
    }

    public static InstructionPort newInstructionPort(){
        return new InstructionPortImpl(newInstructionService());
    }

    public static InstructionService newInstructionService(){
        return new InstructionServiceImpl(newGrassService(),newMowrepository(),newMoveInstructionService(),newPromptOutputService(),newMowService());
    }

    public static GrassRepository newGrassRepository(){
        return InMemoryGrassRepository.getInstance();
    }

    public static MowRepository newMowrepository(){
        return InMemoryMowRepository.getInstance();
    }

    public static MoveInstructionService newMoveInstructionService(){
        return new MoveInstructionServiceImpl(newMowService());
    }

    public static MowService newMowService(){
        return new MowServiceImpl(newMowrepository(),newGrassRepository());
    }

    public static OutputService newPromptOutputService(){
        return new PromptService();
    }

    public static GrassService newGrassService(){
        return new GrassServiceImpl(newGrassRepository());
    }
}
