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
        if (equals(other))
            return true;
        else if ( other instanceof Bar) {
            Bar bar = (Bar) other;
            int oneX = bar.getPointOne().getxCoord();
            int twoX = bar.getPointTwo().getxCoord();
            int oneY = bar.getPointOne().getyCoord();
            int twoY = bar.getPointTwo().getyCoord();

            if (getxCoord() >= Math.min( oneX , twoX) && getxCoord() <= Math.max(oneX, twoX) && getyCoord() >= Math.min(oneY, twoY) && getyCoord() <= Math.max(oneY, twoY))
                return true;
            else
                return false;
        }
        else if ( other instanceof BarAlt) {
            BarAlt bar = (BarAlt) other;
            int oneX = bar.getFirstCornerX();
            int twoX = bar.getSecondCornerX();
            int oneY = bar.getFirstCornerY();
            int twoY = bar.getSecondCornerY();

            if (getxCoord() >= Math.min( oneX , twoX) && getxCoord() <= Math.max(oneX, twoX) && getyCoord() >= Math.min(oneY, twoY) && getyCoord() <= Math.max(oneY, twoY))
                return true;
            else
                return false;
        }
        else
            return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;

        if (point.getxCoord() == this.getxCoord() && point.getyCoord() == this.getyCoord())
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
