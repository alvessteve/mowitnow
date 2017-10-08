package org.xebia.mowitnow.infrastructure.inmemory;

import org.xebia.mowitnow.domain.model.mow.Mow;
import org.xebia.mowitnow.domain.repository.MowRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMowRepository implements MowRepository {

    private List<Mow> mowList;
    private Mow currentMowMoving;

    private static InMemoryMowRepository instance;

    public static InMemoryMowRepository getInstance(){
        if(instance == null){
            synchronized (InMemoryMowRepository.class){
                instance = new InMemoryMowRepository();
            }
        }
        return instance;
    }

    @Override
    public void add(Mow mow) {
        if(mowList == null)
            mowList = new ArrayList<>();
        getInstance().mowList.add(mow);
        currentMowMoving = mow;
    }

    @Override
    public List<Mow> all(){
        return getInstance().mowList;
    }

    @Override
    public Mow currentMowMoving() {
        Mow mow = getInstance().currentMowMoving;
        if(mow == null)
            throw new IllegalStateException("No mow is moving");
        return mow;
    }

}
