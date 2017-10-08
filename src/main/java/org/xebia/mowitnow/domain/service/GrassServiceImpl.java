package org.xebia.mowitnow.domain.service;

import org.xebia.mowitnow.domain.factory.GrassFactory;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.repository.GrassRepository;

public class GrassServiceImpl implements GrassService {

    private GrassRepository grassRepository;

    public GrassServiceImpl(GrassRepository grassRepository) {
        this.grassRepository = grassRepository;
    }

    @Override
    public void create(String coordinates) {
        Grass newGrass = GrassFactory.build(coordinates);
        grassRepository.add(newGrass);
    }
}
