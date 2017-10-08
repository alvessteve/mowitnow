package org.xebia.mowitnow.domain.service;

import org.xebia.mowitnow.domain.model.instructions.MoveInstruction;

public class MoveInstructionServiceImpl implements MoveInstructionService {

    private MowService mowService;

    public MoveInstructionServiceImpl(MowService mowService) {
        this.mowService = mowService;
    }

    @Override
    public void move(MoveInstruction moveInstruction) {
        switch (moveInstruction){
            case RIGHT:
                mowService.spinRight();
                break;
            case LEFT:
                mowService.spinLeft();
                break;
            case FORWARD:
                mowService.moveIfWithinGrass();
                break;
        }
    }
}
