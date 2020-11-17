package com.minos.datastructure.linearstructure.array;

/**
 * 自定义动态数组
 * size 的值就是数组的实际长度, 刚好是最后一个element的index+1
 *
 * @Author: minos
 * @Date: 2020/9/14 21:09
 */
public class Array<E> {

    private E[] data;
    /**
     * 实际存放数据的个数
     */
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 用户传入的数组容量
     */
    public Array(int capacity) {
        //java中new泛型数组需要先new一个Object类型数组后再强转
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造
     * 默认 capacity = 10
     */
    public Array() {
        // this()调用类构造函数，只能在构造函数中调用且必须放在第一行
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 获取数组长度
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数据是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param index 元素插入的位置
     * @param e     需插入的元素
     */
    public void add(int index, E e) {

        //确保元素紧密排列，并且不出现非法索引
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (size == data.length) {
            //动态扩容 JAVA中ArrayList的扩容因子为1.5倍
            resize(2 * data.length);
        }

        //index及其以后的元素全部向后挪一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        //插入新元素
        data[index] = e;
        size++;
    }

    /**
     * 向末尾添加一个新元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向元素头位置添加一个新元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否包含元素e
     *
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i <= data.length; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引, 如果不存在则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i <= data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素
     *
     * @param index 需删除元素索引
     * @return 返回喊出的元素
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }

        E ret = data[index];
        //index后一位的每一个元素向前挪一位
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        //是的size指向的地址资源可以被垃圾回收机制自动回收 loitering objects != memory leak
        data[size] = null;

        /*
            删除元素后数组空闲容量占总容量3/4则缩小总容量
            缩小1/2
            data.length / 4 lazy策略解决复杂度震荡问题
            data.length / 2 != 0 防止当data.length = 1时data.length / 2 = 0的情况
            不能new一个空间为0 的数组
        */
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除头元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 交换两个元素的位置
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {

        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal !");
        }

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 动态扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        //把原数组中的数据复制到新数组中
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        //让data指向newData的地址
        data = newData;
    }


}

















