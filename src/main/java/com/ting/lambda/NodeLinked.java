package com.ting.lambda;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

/**
 * 链表实现
 *
 * @author ting
 * @version 1.0
 * @date 2021/01/12
 */
@Slf4j
public class NodeLinked<E> {

    /**
     * 数量
     */
    int size = 0;

    /**
     * 第一个元素
     */
    Node<E> first;

    /**
     * 最后一个元素
     */
    Node<E> end;


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
        // 行尾添加，直接进行添加
        if (index == size) {
            nodeLast(e);
        }
        addIndex(e, addNode(index));
        return true;
    }

    public void getList() {
        getListOut(first);
    }

    public void getListOut(Node<E> node) {
        if (!ObjectUtils.isEmpty(node.next)) {
            System.out.print(node.item + ",");
            getListOut(node.next);
        } else {
            System.out.println(node.item);

        }
    }

    /**
     * @param e
     * @param addNode
     */
    private void addIndex(E e, Node<E> addNode) {
        /*
            节点替换 将替换的节点信息的上一个节点指向新增的节点
            将替换的节点的上一个节点的下一个节点指向新增的节点
         */
        Node<E> oldFirst = addNode.prev;
        Node<E> newNode = new Node<>(oldFirst, e, addNode);
        addNode.prev = newNode;
        // 判断是不是替换的链表的第一个，如果是第一个将新增的节点指向first
        if (oldFirst == null) {
            first = newNode;
        } else {
            // 将替换的节点的上一个节点的下一个节点指向新增的节点
            oldFirst.next = newNode;
        }
        size++;

    }

    /**
     * 获取插入前的下标
     *
     * @param index 下标
     */
    private Node<E> addNode(int index) {
        // 根据size >> 1判断要插入的下标是在前一半的范围内还是后面一半的范围内做处理(中分)
        if (index < (size >> 1)) {
            Node<E> x = first;
            // 循环遍历index次，返回该index的下一个指标信息
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = end;
            // 倒序遍历index次，返回该index的上一一个指标信息
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
        final Node<E> newNode = new Node<>(first, e, null);
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
        Node<E> prev;
        E item;

        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }

    public void remove(E e) {

        // 交换
        if (e.equals(first.item)) {
            firstRemove(e);
            return;
        }
        unFirstRemove(e);

    }

    /**
     * 非第一个删除
     *
     * @param e
     */
    private void unFirstRemove(E e) {

    }

    /**
     * 根据下标获取数据
     *
     * @param index 下标地址
     * @return 数值
     */
    public E get(int index) {
        judeIndex(index);
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x.item;

        } else {
            Node<E> x = end;
            for (int i = size - 1; i > index; i--) {
                x = end.prev;
            }
            return x.item;

        }


    }

    /**
     * 删除第一个
     *
     * @param e
     */
    private void firstRemove(E e) {
        // 将第一个指标设置为null,将第二个设置为第一个指标

        Node<E> nextNode = first.next;
        first.next = null;
        first.item = null;
        nextNode.prev = null;
        first = nextNode;


    }

//    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < 19; i++) {
//            list.add(i);
//
//        }
//        log.info("修改前：{}", JSON.toJSON(list));
//        list.add(10, 250);
//        log.info("修改后：{}", JSON.toJSON(list));
//    }

    public static void main(String[] args) {
        NodeLinked<Integer> integerNodeLinked = new NodeLinked<>();
        integerNodeLinked.add(10);
        integerNodeLinked.add(11);
        integerNodeLinked.add(12);
        integerNodeLinked.add(13);
        integerNodeLinked.add(14);
        integerNodeLinked.add(15);
        integerNodeLinked.getList();
        integerNodeLinked.remove(10);
        integerNodeLinked.getList();
        System.out.println(integerNodeLinked.get(5));
        log.info(JSON.toJSONString(integerNodeLinked.size));
    }
}
