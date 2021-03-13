package education;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {
    int num;
    Tree leftNode = null;
    Tree rightNode = null;
    boolean isFake = false;

    public Tree setFake(boolean fake) {
        isFake = fake;
        return this;
    }

    public boolean isFake() {
        return isFake;
    }

    public Tree(int num) {
        this.num = num;
    }

    public void add(int val) {
        add(this, val);
    }

    private void add(Tree tree, int num) {
        if (num > tree.num) {
            if (tree.rightNode == null) {
                tree.rightNode = new Tree(num);
            } else add(tree.rightNode, num);
        } else if (num < tree.num) {
            if (tree.leftNode == null) {
                tree.leftNode = new Tree(num);
            } else add(tree.leftNode, num);
        }
    }

    public StringBuilder goBreadth() {
        Queue<Tree> queue = new ArrayDeque<>();
        queue.offer(this);
        StringBuilder s = new StringBuilder();
        while (!queue.isEmpty()) {
            Tree tree = queue.poll();
            s.append(tree.num).append("->");
            if (tree.leftNode != null) {
                queue.offer(tree.leftNode);
            }
            if (tree.rightNode != null) {
                queue.offer(tree.rightNode);
            }
        }
        s.delete(s.length() - 2, s.length());
        return s;
    }


    public StringBuilder getRepresentation() {
        Queue<Tree> queue = new ArrayDeque<>();
        StringBuilder s = new StringBuilder();
        StringBuilder indent;
        int counter = 0, level = 0, levelTemp, indentTemp, height = getHeight() + 1;

        queue.offer(this);

        //отступы для корня
        levelTemp = (height - level) * (height - level) / 2;
        indent = new StringBuilder();
        while (levelTemp-- > 0)
            indent.append(" ");
        if(indent.length()>=4)
        s.append(indent.substring(0,indent.length()-4));
        else s.append(indent);


        while (!queue.isEmpty()) {
            Tree tree = queue.poll();

            if (tree.isFake()) {
                s.append(indent);
                s.append("[]");

            } else {

                s.append(indent);
                s.append(String.format("%2d", tree.num));
                if (tree.leftNode == null)
                    queue.offer(new Tree(-999999999).setFake(true));
                else
                    queue.offer(tree.leftNode);
                if (tree.rightNode == null)
                    queue.offer(new Tree(-999999999).setFake(true));
                else
                    queue.offer(tree.rightNode);
            }
            //новая строка, перерасчёт отступов
            if (counter == 0) {
                level++;
                levelTemp = (height - level) * (height - level) / 2;
                indent = new StringBuilder();
                while (levelTemp-- > 0)
                    indent.append(" ");
                counter = (int) Math.pow(2, level);

                s.append('\n').append(indent);
            }
            counter--;
        }
        return s;
    }

    private int getHeight() {

        ArrayDeque<Tree> queue = new ArrayDeque<>();
        int counter = 0, level = 0, levelTemp = 0;
        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree tree = queue.poll();
            if (!tree.isFake()) {
                if (tree.leftNode == null)
                    queue.offer(new Tree(-999999999).setFake(true));
                else
                    queue.offer(tree.leftNode);
                if (tree.rightNode == null)
                    queue.offer(new Tree(-999999999).setFake(true));
                else
                    queue.offer(tree.rightNode);
            }
            if (counter == 0) {
                counter = (int) Math.pow(2, level);
                level++;
            }
            counter--;
        }
        return level;

    }
}
