package com.sort.advance.quick;

import com.sort.base.ISort;
import com.sort.util.Utils;
/**
 * 如果说归并排序先对部分进行排序,然后在整体排序(部分->整体)
 * 那么快速排序就是先从整体确定某个元素的确定位置,然后对剩余部分依旧如此操作
 * (整体->部分)
 * @author 47
 * 还有这里,为什么不对类直接用伪泛型,呃,主要是为了好看
 */
public class QuickSort implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		quickSort(arr,0,n-1);
	}

	private<T extends Comparable<T>> void quickSort(T[] arr, int l, int r) {
		//这里的优化可以按照归并排序的优化
		if(l>=r){
			//这里的判断同归并排序
			return;
		}
		int p = partition2(arr,l,r);
		quickSort(arr, l, p-1);
		quickSort(arr, p+1, r);
	}
	//这里是重点,精髓所在
	@SuppressWarnings("unused")
	private<T extends Comparable<T>> int partition(T[] arr, int l, int r) {
		//默认以第一个值作为要放到正确位置的值
		//可以使用随机数选择随机一个位置并与第一个做交换来使效率趋近于平均值
		T v =arr[l];
		int j =l;
		for(int i=l+1;i<=r;i++){
			if(Utils.aLb(arr[i], v)){
				j++;
				Utils.swap(arr, i, j);
			}
		}
		//循环结束的时候 第j个元素左边的数值都小于等于arr[j]
		//右边的元素都大于等于arr[j]
		Utils.swap(arr, l, j);
		return j;
	}
	//使用双端指针来减少总体交换次数
	private<T extends Comparable<T>> int partition2(T[] arr, int l, int r){
		//需要被放置在正确位置的数据
		T v = arr[l];
		//i左指针,j右指针
		int i =l+1,j=r;
		while(true){
			//当左指针的位置小于等于右指针的位置并且左指针的元素小于要放到正确位置的元素
			while(i<=r&&Utils.aLb(arr[i], v))
				i++;//左指针向右移动一个单位
			//这里j的范围是[i,j],原因是[l+1,i-1]的元素已经都小于v了
			while(j>=i&&Utils.aRb(arr[j], v))
				j--;//右指针向左移动一个单位
			if(i>j){
				break;
			}
			Utils.swap(arr, i, j);//这里做交换的目的是让在左边大于v的和在右边小于v的进行交换
			i++;//如果是最后一次大小交换,i++的结果,即这个时候位置的元素是大于等于v的
			j--;//如果是最后一次大小交换,j--的结果,即这个时候位置的元素是小于等于v的
		}
		Utils.swap(arr, l, j);
		return j;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,23,24,1,23,435,12,3,2,1,3,2};
		new QuickSort().sort(arr, arr.length);
		Utils.printArr(arr, "快速排序");
	}
}
