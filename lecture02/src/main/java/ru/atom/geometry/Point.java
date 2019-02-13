package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider/* super class and interfaces here if necessary */ {
    // fields
    // and methods
    private int xCoord;
    private int yCoord;
    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    public Point(int x, int y)
    {
        this.setxCoord(x);
        this.setyCoord(y);
    }
    @Override
    public boolean isColliding(Collider other)
    {
        if (((Point)other).getxCoord() == this.getxCoord() && ((Point)other).getyCoord() == this.getyCoord())
            return true;
        else
            return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;

        if (((Point) o).getxCoord() == this.getxCoord() && ((Point) o).getyCoord() == this.getyCoord())
            return true;
        else
            return false;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}
