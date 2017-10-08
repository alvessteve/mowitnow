package org.xebia.mowitnow.adapter;

import org.xebia.mowitnow.domain.factory.InstructionFactory;
import org.xebia.mowitnow.domain.model.instructions.Instruction;
import org.xebia.mowitnow.domain.service.InstructionService;

public class InstructionPortImpl implements InstructionPort {

    private InstructionService instructionService;

    public InstructionPortImpl(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @Override
    public void translate(String content) {
        Instruction instruction = InstructionFactory.build(content);
        instructionService.process(instruction);
    }

}

