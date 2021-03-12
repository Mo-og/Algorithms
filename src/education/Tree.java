package education;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {
    int num;
    Tree leftNode = null;
    Tree rightNode = null;

    public Tree(int num) {
        this.num = num;
    }

    public void add(int val) {
        _add(this, val);
    }


    private void _add(Tree tree, int val) {
        if(val > tree.num) {
            if(tree.rightNode == null) {
                tree.rightNode = new Tree(val);
            }
            else _add(tree.rightNode, val);
        }

        else if(val < tree.num) {
            if(tree.leftNode == null) {
                tree.leftNode = new Tree(val);
            }
            else _add(tree.leftNode, val);
        }
    }

    public void goBreadth() {
        Queue<Tree> q = new ArrayDeque<>();
        q.offer(this);
        while(!q.isEmpty()) {
            Tree t = q.poll();
            System.out.println(t.num);
            if(t.leftNode != null) {
                q.offer(t.leftNode);
            }if(t.rightNode != null) {
                q.offer(t.rightNode);
            }
        }
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        //prefix - времененное хранилище для одной строки дерева
        //sb постоянное хранилище для всех строк (то есть sb это совокупность префиксов)
        //если tail = true, то добавляем горизонтальную линию, в ином случае добавляем пробелы к prefix
        if (rightNode != null) {
            rightNode.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(num).append("\n");
        if (leftNode != null) {
            leftNode.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
