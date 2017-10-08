package org.xebia.mowitnow.infrastructure.inmemory;

import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.repository.GrassRepository;

public class InMemoryGrassRepository implements GrassRepository {

    private Grass grass;

    private static InMemoryGrassRepository instance;

    public static InMemoryGrassRepository getInstance(){
        if(instance == null){
            synchronized (InMemoryGrassRepository.class){
                instance = new InMemoryGrassRepository();
            }
        }
        return instance;
    }

    @Override
    public void add(Grass grass){
        getInstance().grass = grass;
    }

    @Override
    public Grass get(){
        return getInstance().grass;
    }
}
