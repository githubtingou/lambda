package com.ting.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * 链表实现
 *
 * @author lishuang
 * @version 1.0
 * @date 2021/01/12
 */
@Slf4j
public class NodeLinked<E> {

    /**
     * 数量
     */
    private static int size = 0;

    /**
     * 第一个元素
     */
    Node<E> first;

    /**
     * 最后一个元素
     */
    Node<E> end;

    /**
     * 添加
     *
     * @param index
     * @param e
     * @param <E>
     */
//    public <E> boolean add(int index, E e) {
////        if (index == size) {
////            addEnd(e);
////        }
//        size++;
//        return true;
//    }

    /**
     * 添加，默认添加到行尾
     */
    public boolean add(E e) {
        nodeLast(e);
        return true;

    }

    /**
     * 根据下标添加数据
     *
     * @param index 下标
     * @param e     数据
     * @return
     */
    public boolean add(int index, E e) {
        judeIndex(index);
        if (size == 0 || index == size) {
            nodeLast(e);
        }
        addIndex(e, addNode(index));
        return true;
    }

    /**
     * @param e
     * @param addNode
     */
    private void addIndex(Node<E> e, Node<E> addNode) {
        // 数组替换
        Node<E> prev = addNode.prev;

    }

    /**
     * 添加数据
     *
     * @param index 下标
     */
    private Node<E> addNode(int index) {
        // 根据size >> 1判断要插入的下标是在前一半的范围内还是后面一半的范围内做处理(中分)
        if (index < (size >> 1)) {
            Node<E> x = first;
            // 循环遍历index次，返回该index的下标信息
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = end;
            for (int i = index - 1; i > index; i--) {
                x = x.next;
            }
            return x;
        }
    }

    /**
     * 判断下标是否是合法下标，
     *
     * @param index 下标
     */
    private void judeIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }

    }

    public void nodeLast(E e) {
        // 将之前链表的最后的一个元素取出来
        final Node<E> oldNode = end;
        // 将新增的数据修改为链表的最后一个元素
        final Node<E> newNode = new Node<>(e, first, null);
        end = newNode;
        // 判断最后一个元素是否为null。为null以为这个首次添加
        if (oldNode == null) {
            first = newNode;
        } else {
            // 不是将新增的节点设为end的下一节点指向
            oldNode.next = newNode;
        }
        size++;

    }

    public static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }

}
