package ru.atom.geometry;

public class Bar implements Collider {

    private Point pointOne;
    private Point pointTwo;

    public Bar(Point one, Point two)
    {
        pointOne = one;
        pointTwo = two;
    }


    public Point getPointOne() {
        return pointOne;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
    }

    public boolean isColliding(Collider o)
    {
        return true;
    }
}
