package test;

import education.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void goBreadth() {
        Tree t = new Tree(10);
        t.add(5);
        t.add(15);
        t.add(3);
        t.add(8);
        t.add(12);
        t.add(18);
        t.add(1);
        t.add(4);
        t.add(0);
        t.add(11);
        String trail = t.goBreadth().toString();
        assertEquals("10->5->15->3->8->12->18->1->4->11->0",trail);
        System.out.println(trail);
        System.out.println(t.getRepresentation());
    }
}