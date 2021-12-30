package com.mask.data.array;

/**
 * 数据
 * @author Mask
 * @date 2021.07.11
 */
public class Array {

	private int[] intArrays;

	private int size;

	/* 初始化数组容量 */
	public Array(int capacity) {
		this.intArrays = new int[capacity];
		size = 0;
	}

	/**
	 * 插入（到数组的尾部）
	 * @param value 值
	 */
	public void insert(int value) {
		if (size + 1 >= intArrays.length) {
			throw new IllegalArgumentException("Out range exception");
		}

		intArrays[size - 1] = value;
		size++;
	}

	/**
	 * 插入元素到指定位置
	 * @param element
	 * @param index
	 */
	public void insert(int element, int index) {
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("超出数组实际范围");
		}

		/* 从右向左循环，将元素逐个向右挪一位 */
		// TODO 有BUG， 当插入的顺序无序时， 数组下表越界
		for (int i = size - 1; i >= index; i--) {
			intArrays[i + 1] = intArrays[i];
		}
		intArrays[index] = element;
		size++;
	}

	/**
	 * 查询
	 * @return
	 */
	public int query(int index) {
		return intArrays[index];
	}

	/**
	 * 更新操作
	 * @return
	 */
	public void update(int value, int index) {
		if (size >= intArrays.length) {
			throw new IllegalArgumentException("Out range exception");
		}

		intArrays[index] = value;
	}

	/**
	 * 删除
	 */
	public void delete(int index) {
		if (index > size) {
			return;
		}

		for (int i = index; i < size - 1; i++ ) {
			intArrays[i] = intArrays[i + 1];
		}
		size--;
	}

	public void output() {
		for (int i = 0; i < size; i++) {
			System.out.println(intArrays[i]);
		}
	}


	public static void main(String[] args) {
		Array array = new Array(10);

		array.insert(3,0);
		array.insert(7,1);
		array.insert(9,2);
		array.insert(5,3);
		array.insert(6,1);
		array.output();

	}


}
