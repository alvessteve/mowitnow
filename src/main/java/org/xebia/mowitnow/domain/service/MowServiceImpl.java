package org.xebia.mowitnow.domain.service;

import org.xebia.mowitnow.domain.factory.MowFactory;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.mow.Mow;
import org.xebia.mowitnow.domain.model.mow.Position;
import org.xebia.mowitnow.domain.repository.GrassRepository;
import org.xebia.mowitnow.domain.repository.MowRepository;

public class MowServiceImpl implements MowService {

    private MowRepository mowRepository;
    private GrassRepository grassRepository;

    public MowServiceImpl(MowRepository mowRepository, GrassRepository grassRepository) {
        this.mowRepository = mowRepository;
        this.grassRepository = grassRepository;
    }

    @Override
    public void create(Position initialPosition) {
        Grass grass = grassRepository.get();
        Mow mow = MowFactory.build(initialPosition,grass);
        mowRepository.add(mow);
    }

    @Override
    public void moveIfWithinGrass() {
        Mow mow = mowRepository.currentMowMoving();
        Grass grass = grassRepository.get();
        switch (mow.getPosition().getOrientation()){
            case NORTH:
                simulateNewCoordinatesAndMoveIfNecessary(mow.getPosition().getCoordinates().getX(), mow.getPosition().getCoordinates().getY() +1, grass,mow);
                break;
            case EAST:
                simulateNewCoordinatesAndMoveIfNecessary(mow.getPosition().getCoordinates().getX() + 1, mow.getPosition().getCoordinates().getY(), grass,mow);
                break;
            case WEST:
                simulateNewCoordinatesAndMoveIfNecessary(mow.getPosition().getCoordinates().getX() - 1, mow.getPosition().getCoordinates().getY(), grass,mow);
                break;
            case SOUTH:
                simulateNewCoordinatesAndMoveIfNecessary(mow.getPosition().getCoordinates().getX(), mow.getPosition().getCoordinates().getY() - 1, grass,mow);
                break;
        }
    }

    @Override
    public void spinRight() {
        Mow mow = mowRepository.currentMowMoving();
        mow.spinRight();
    }

    @Override
    public void spinLeft() {
        Mow mow = mowRepository.currentMowMoving();
        mow.spinLeft();
    }

    private void simulateNewCoordinatesAndMoveIfNecessary(int newCoordinatesInX, int newCoordinatesInY, Grass grass, Mow mow){
        if(Coordinates.areValid(newCoordinatesInX,newCoordinatesInY)){
            Coordinates newCoordinates = new Coordinates(newCoordinatesInX, newCoordinatesInY);
            if(!grass.outOfBounds(newCoordinates))
                mow.moveForward();
        }
    }
}
