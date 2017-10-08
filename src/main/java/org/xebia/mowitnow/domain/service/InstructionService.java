package org.xebia.mowitnow.domain.service;

import org.xebia.mowitnow.domain.model.instructions.Instruction;

import java.util.List;

public interface InstructionService {

    void process(Instruction instruction);

}
