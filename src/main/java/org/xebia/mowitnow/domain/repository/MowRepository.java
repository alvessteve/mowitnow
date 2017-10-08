package org.xebia.mowitnow.domain.repository;

import org.xebia.mowitnow.domain.model.mow.Mow;

import java.util.List;

public interface MowRepository {

    void add(Mow mow);

    List<Mow> all();

    Mow currentMowMoving();

}
