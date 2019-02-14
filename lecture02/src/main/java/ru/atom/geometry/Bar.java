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
        if (o == null )
            return false;
        Point one;
        if (o instanceof Point) {
            one = (Point)o;
            if (one.isColliding(this))
                return true;
            else
                return false;
        }
        else if (o instanceof  Bar)
        {
            Bar bar = (Bar) o;
            if ( equals(bar))
                return true;
            one = bar.getPointOne();
            Point two = bar.getPointTwo();
            if (one.isColliding(this) || two.isColliding(this))
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
        Bar bar = (Bar) o;

        if ((bar.getPointOne().equals(this.getPointOne()) ||  (bar.getPointTwo().equals(this.getPointOne())) && (bar.getPointTwo().equals(this.getPointTwo()) || bar.getPointTwo().equals(this.getPointOne()))))
            return true;
        else
            return false;
    }
}
