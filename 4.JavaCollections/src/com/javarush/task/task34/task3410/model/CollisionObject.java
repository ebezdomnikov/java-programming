package com.javarush.task.task34.task3410.model;

import java.awt.*;

public abstract class CollisionObject extends GameObject {

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    /**
     * 4.3.3.2. Метод boolean isCollision(GameObject gameObject, Direction direction).
     * Этот метод должен возвращаться true, если при перемещении текущего объекта
     * в направлении direction на FIELD_CELL_SIZE произойдет столкновение с объектом
     * gameObject, переданным в качестве параметра.
     * Иначе - возвращать false. Столкновением считать совпадение координат x и y.
     *
     * @param gameObject
     * @param direction
     * @return
     */
    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case UP:
                return (getX() == gameObject.getX()) && (gameObject.getY() == (getY() - Model.FIELD_CELL_SIZE));
            case DOWN:
                return (getX() == gameObject.getX()) && (gameObject.getY() == (getY() + Model.FIELD_CELL_SIZE));
            case LEFT:
                return (gameObject.getX() == getX() - Model.FIELD_CELL_SIZE) && (gameObject.getY() == getY());
            case RIGHT:
                return (gameObject.getX() == getX() + Model.FIELD_CELL_SIZE) && (gameObject.getY() == getY());
            default:
                return false;
        }
    }
}
