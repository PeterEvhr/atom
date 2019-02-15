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
            Point three = new Point(two.getxCoord(),one.getyCoord());
            Point four = new Point(one.getxCoord(),two.getyCoord());
            int xmin = Math.min(one.getxCoord(), two.getxCoord());
            int xmax = Math.max(one.getxCoord(), two.getxCoord());
            int ymin = Math.min(one.getyCoord(), two.getyCoord());
            int ymax = Math.max(one.getyCoord(), two.getyCoord());
            int xtmin = Math.min(this.pointOne.getxCoord(), this.getPointTwo().getxCoord());
            int xtmax = Math.max(this.pointOne.getxCoord(), this.getPointTwo().getxCoord());
            int ytmin = Math.min(this.getPointOne().getyCoord(), this.getPointTwo().getyCoord());
            int ytmax = Math.max(this.getPointOne().getyCoord(), this.getPointTwo().getyCoord());
            if (one.isColliding(this) || two.isColliding(this) || three.isColliding(this) || four.isColliding(this)
            || xmin <= xtmin && xmax >= xtmax && ytmin <= ymin && ytmax >= ymax
            || xtmin <= xmin && xtmax >= xmax && ymin <= ytmin && ymax >= ytmax)
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
        int x1 = Math.min( bar.getPointOne().getxCoord(), bar.getPointTwo().getxCoord());
        int x2 = Math.max(bar.getPointOne().getxCoord(), bar.getPointTwo().getxCoord());
        if (x1 == Math.min(getPointOne().getxCoord(), getPointTwo().getxCoord()) && x2 == Math.max(getPointOne().getxCoord(), getPointTwo().getxCoord()))
        {
            int y1 = Math.min( bar.getPointOne().getyCoord(), bar.getPointTwo().getyCoord());
            int y2 = Math.max(bar.getPointOne().getyCoord(), bar.getPointTwo().getyCoord());
            if (y1 == Math.min(getPointOne().getyCoord(), getPointTwo().getyCoord()) && y2 == Math.max(getPointOne().getyCoord(), getPointTwo().getyCoord()))
            {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
}
