package org.xebia.mowitnow.domain.repository;

import org.xebia.mowitnow.domain.model.grass.Grass;

public interface GrassRepository {
    void add(Grass grass);

    Grass get();
}
