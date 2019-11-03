package com.itcode.environment.datastructure.array;

/**
 * @Author:wx
 * @Date:2019/6/22 19:38
 */
public class Array<E> {

    private E[] data;
    /**数组有效元素大小即当前数组中元素的个数*/
    private int size;

    /**
     * 构造方法：初始化数组大小
     * @param capaCity 初始化数组容量
     */
    public Array(int capaCity){
        data = (E[])new Object[capaCity];
        size = 0;
    }

    /**
     * 无参构造方法，调用有参构造默认初始大小
     */
    public Array(){
        this(10);
    }

    /**
     * 添加元素
     * @param e
     */
    public void addLast(E e){
        //添加元素之前验证数据大小是否超过最大容量
//        if (size == data.length){
//            throw new IllegalArgumentException("AddLast failed");
//        }
//        data[size] = e;
//        size ++;
        add(size,e);
    }

    /**
     * 在数组头部添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在索引处添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw  new IllegalArgumentException("AddLast failed");
        }
        if (size == data.length){
//            throw new IllegalArgumentException("AddLast Failed");
        //进行数组扩容
            resize(2*data.length);
        }
        //将index之后的元素向后移动一位,从后向前移动
        for (int i = size - 1; i >= index; i --){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;

    }

    /**
     * 返回数组元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size){
            throw  new IllegalArgumentException("Get failed");
        }
        return data[index];
    }

    /**
     * 修改数组元素
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw  new IllegalArgumentException("set failed");
        }
        data[index] = e;
    }


    public E remove(int index){
        //返回要删除的元素值
        E ret = data[index];
        for(int i = index+1; i < size; i++){
            data[i-1] = data[i];
        }
        size --;
        data[size] = null;
        //删除缩容
        if (size == data.length/2){
            resize(data.length/2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }
    /**
     * 返回数组中当前元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组的容量即数组的长度
     * @return
     */
    public int getCapaCity(){
        return data.length;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 数组是否包含
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i = 0; i < size; i ++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 返回元素的索引值
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0; i < size; i ++){
            if (data[i] .equals(e)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capaCity = %d\n",size,data.length));
        sb.append('[');
        for(int i = 0; i < size; i ++){
            sb.append(data[i]);
            //不是最后一个元素的下标则拼接‘，’
            if (i != size - 1){
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
