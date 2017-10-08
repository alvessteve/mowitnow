package org.xebia.mowitnow.domain.service;

import org.xebia.mowitnow.domain.model.mow.Position;

public interface MowService {

    void create(Position initialPosition);

    void moveIfWithinGrass();

    void spinRight();

    void spinLeft();
}
