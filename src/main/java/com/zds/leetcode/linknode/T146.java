package com.zds.leetcode.linknode;

import java.util.HashMap;
import java.util.Map;

public class T146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(1));
        lRUCache.put(5, 5);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(5));

    }
}

class LRUCache {
    class DNode {
        int key;
        int value;
        DNode pre;
        DNode next;
    }

    int capacity;
    int size;
    Map<Integer, DNode> map = new HashMap<>();
    DNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 使用伪头节点和伪尾节点
        head = new DNode();
        tail = new DNode();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DNode node = map.get(key);
        if (null==node) {
            return -1;
        } else {
            // 将节点移动到末尾，表示最近使用过
            removeNode(node);
            moveNodeToTail(node);

            return node.value;
        }
    }

    public void put(int key, int value) {
        DNode node = map.get(key);

        if (null!=node) {
            // 更新
            node.value = value;
            // 移动到尾部
            removeNode(node);
            moveNodeToTail(node);
        } else {
            DNode newNode = new DNode();
            newNode.key = key;
            newNode.value = value;

            map.put(key, newNode);
            addToTail(newNode);
            size++;

            if (size > capacity) {
                // 删除头节点，最久未使用
                DNode removed = removeHead();
                map.remove(removed.key);
                size--;
            }
        }
    }

    // 从链表中移除指定节点
    void removeNode(DNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 添加节点到链表尾部
    void addToTail(DNode node) {
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }

    // 移动节点到链表尾部(这一步重点理解)
    void moveNodeToTail(DNode node) {
        addToTail(node);
    }

    // 删除头节点并返回（用于淘汰）
    DNode removeHead() {
        DNode head = this.head.next;
        removeNode(head);
        return head;
    }

}
