package com.zds.leetcode.linknode;

import java.util.HashMap;
import java.util.Map;

public class T138 {
    public static Node copyRandomList(Node head) {
        Node newHead = new Node(-1);
        Node newCur = newHead;

        // 构造一个 map 存储 <Node，索引> 这里的 node 是原来的链表节点
        Map<Node, Integer> oldMap = new HashMap<>();
        Map<Integer, Node> newMap = new HashMap<>();

        Node cur = head;

        int i = 0;
        // 构造链表
        while (null != cur) {
            Node node = new Node(cur.val);
            oldMap.put(cur, i);
            newMap.put(i, node);
            newCur.next = node;
            cur = cur.next;
            newCur = newCur.next;
            i++;
        }

        // 设置random节点
        cur = head;
        newCur = newHead.next;
        while (null != cur) {
            if (null != cur.random) {
                Integer index = oldMap.get(cur.random);
                // 先根据旧节点的信息拿到旧索引，再根据索引拿到新节点，设置新节点的random节点
                newCur.random = newMap.get(index);
            }
            cur = cur.next;
            newCur = newCur.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);

        node.next.next.random = node.next;
        node.next.random = node;
        node.random = node.next;

        Node newHead = copyRandomList(node);

        System.out.println(node);

        System.out.println(newHead);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        Node next = this;
        StringBuilder sb = new StringBuilder();
        while (next != null) {
            sb.append("(").append(next.val).append(",");
            if (next.random != null) {
                sb.append(next.random.val);
            } else {
                sb.append("null");
            }
            sb.append("),");
            next = next.next;
        }
        return sb.toString();
    }
}
