package org.xebia.mowitnow.domain.service;

import org.xebia.mowitnow.domain.factory.MoveInstructionsFactory;
import org.xebia.mowitnow.domain.factory.PositionFactory;
import org.xebia.mowitnow.domain.model.instructions.Instruction;
import org.xebia.mowitnow.domain.model.instructions.MoveInstruction;
import org.xebia.mowitnow.domain.model.mow.Mow;
import org.xebia.mowitnow.domain.model.mow.Position;
import org.xebia.mowitnow.domain.repository.MowRepository;

import java.util.List;

public class InstructionServiceImpl implements InstructionService {

    private GrassService grassService;
    private MowRepository mowRepository;
    private MoveInstructionService moveInstructionService;
    private OutputService outputService;
    private MowService mowService;

    public InstructionServiceImpl(GrassService grassService, MowRepository mowRepository, MoveInstructionService moveInstructionService, OutputService outputService, MowService mowService) {
        this.grassService = grassService;
        this.mowRepository = mowRepository;
        this.moveInstructionService = moveInstructionService;
        this.outputService = outputService;
        this.mowService = mowService;
    }

    @Override
    public void process(Instruction instruction) {
        if(!instruction.isEmpty()){
            switch (instruction.getType()){
                case MOW_CREATION:
                    Position initialPosition = PositionFactory.fromInstructionContent(instruction);
                    mowService.create(initialPosition);
                    break;
                case GRASS_CREATION:
                    grassService.create(instruction.getContent());
                    break;
                case MOVE_MOW:
                    List<MoveInstruction> moveInstructionList = MoveInstructionsFactory.build(instruction.getContent());
                    moveInstructionList.forEach(moveInstruction -> moveInstructionService.move(moveInstruction));
                    Mow currentMow = mowRepository.currentMowMoving();
                    outputService.showPosition(currentMow);
                    break;
                default:
                    break;
            }
        }
    }
}
