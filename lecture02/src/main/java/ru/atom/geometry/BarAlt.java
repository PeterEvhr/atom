package ru.atom.geometry;

public class BarAlt implements Collider {

    private int firstCornerX;
    private int firstCornerY;
    private int secondCornerX;
    private int secondCornerY;

    public int getFirstCornerX() {
        return firstCornerX;
    }

    public int getFirstCornerY() {
        return firstCornerY;
    }

    public int getSecondCornerX() {
        return secondCornerX;
    }

    public int getSecondCornerY() {
        return secondCornerY;
    }
    public BarAlt(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY)
    {
        this.firstCornerX = firstCornerX;
        this.firstCornerY = firstCornerY;
        this.secondCornerX = secondCornerX;
        this.secondCornerY = secondCornerY;
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
        else if (o instanceof  BarAlt)
        {
            BarAlt bar = (BarAlt) o;
            if ( equals(bar))
                return true;
            int xmin = Math.min( bar.getFirstCornerX(), bar.getSecondCornerX());
            int xmax = Math.max( bar.getFirstCornerX(), bar.getSecondCornerX());
            int ymin = Math.min( bar.getFirstCornerY(), bar.getSecondCornerY());
            int ymax = Math.max( bar.getFirstCornerY(), bar.getSecondCornerY());
            int xtmin = Math.min(this.firstCornerX, this.secondCornerX);
            int xtmax = Math.max(this.firstCornerX, this.secondCornerX);
            int ytmin = Math.min(this.getFirstCornerY(), this.getSecondCornerY());
            int ytmax = Math.max(this.getFirstCornerY(), this.getSecondCornerY());
            if (
                    xmin >= xtmin && xmin <= xtmax && ymin >= ytmin && ymin <= ytmax
                    || xtmin >= xmin && xtmin <= xmax && ytmin >= ymin && ytmin <= ymax
                    || xmin >= xtmin && xmin <= xtmax && ytmin >= ymin && ytmin <= ymax
                    || xtmin >= xmin && xtmin <= xmax && ymin >= ytmin && ymin <= ytmax
                    || xmin <= xtmin && xmax >= xtmax && ytmin <= ymin && ytmax >= ymax
                    || xtmin <= xmin && xtmax >= xmax && ymin <= ytmin && ymax >= ytmax
            )
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
        BarAlt bar = (BarAlt) o;
        int x1 = Math.min( bar.getFirstCornerX(), bar.getSecondCornerX());
        int x2 = Math.max( bar.getFirstCornerX(), bar.getSecondCornerX());
        if (x1 == Math.min( getFirstCornerX(), getSecondCornerX()) && x2 == Math.max(getFirstCornerX(), getSecondCornerX()))
        {
            int y1 = Math.min( bar.getFirstCornerY(), bar.getSecondCornerY());
            int y2 = Math.max( bar.getFirstCornerY(), bar.getSecondCornerY());
            if (y1 == Math.min( getFirstCornerY(), getSecondCornerY()) && y2 == Math.max( getFirstCornerY(), getSecondCornerY()))
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
