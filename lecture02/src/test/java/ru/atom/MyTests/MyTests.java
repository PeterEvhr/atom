package ru.atom.MyTests;

import ru.atom.geometry.Collider;
import ru.atom.geometry.Point;
import org.junit.Test;
public class MyTests {
    @Test
    public void getClassOut()
    {
        String s ;
        Collider o = new Point(5,10);
        Class c = getClass();
        s = c.getName();
        System.out.println(s);
    }

}
