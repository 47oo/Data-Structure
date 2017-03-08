package com.sort.advance.quick;

import com.sort.base.ISort;
import com.sort.util.Utils;
/**
 * ���˵�鲢�����ȶԲ��ֽ�������,Ȼ������������(����->����)
 * ��ô������������ȴ�����ȷ��ĳ��Ԫ�ص�ȷ��λ��,Ȼ���ʣ�ಿ��������˲���
 * (����->����)
 * @author 47
 * ��������,Ϊʲô������ֱ����α����,��,��Ҫ��Ϊ�˺ÿ�
 */
public class QuickSort implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		quickSort(arr,0,n-1);
	}

	private<T extends Comparable<T>> void quickSort(T[] arr, int l, int r) {
		//������Ż����԰��չ鲢������Ż�
		if(l>=r){
			//������ж�ͬ�鲢����
			return;
		}
		int p = partition2(arr,l,r);
		quickSort(arr, l, p-1);
		quickSort(arr, p+1, r);
	}
	//�������ص�,��������
	@SuppressWarnings("unused")
	private<T extends Comparable<T>> int partition(T[] arr, int l, int r) {
		//Ĭ���Ե�һ��ֵ��ΪҪ�ŵ���ȷλ�õ�ֵ
		//����ʹ�������ѡ�����һ��λ�ò����һ����������ʹЧ��������ƽ��ֵ
		T v =arr[l];
		int j =l;
		for(int i=l+1;i<=r;i++){
			if(Utils.aLb(arr[i], v)){
				j++;
				Utils.swap(arr, i, j);
			}
		}
		//ѭ��������ʱ�� ��j��Ԫ����ߵ���ֵ��С�ڵ���arr[j]
		//�ұߵ�Ԫ�ض����ڵ���arr[j]
		Utils.swap(arr, l, j);
		return j;
	}
	//ʹ��˫��ָ�����������彻������
	private<T extends Comparable<T>> int partition2(T[] arr, int l, int r){
		//��Ҫ����������ȷλ�õ�����
		T v = arr[l];
		//i��ָ��,j��ָ��
		int i =l+1,j=r;
		while(true){
			//����ָ���λ��С�ڵ�����ָ���λ�ò�����ָ���Ԫ��С��Ҫ�ŵ���ȷλ�õ�Ԫ��
			while(i<=r&&Utils.aLb(arr[i], v))
				i++;//��ָ�������ƶ�һ����λ
			//����j�ķ�Χ��[i,j],ԭ����[l+1,i-1]��Ԫ���Ѿ���С��v��
			while(j>=i&&Utils.aRb(arr[j], v))
				j--;//��ָ�������ƶ�һ����λ
			if(i>j){
				break;
			}
			Utils.swap(arr, i, j);//������������Ŀ����������ߴ���v�ĺ����ұ�С��v�Ľ��н���
			i++;//��������һ�δ�С����,i++�Ľ��,�����ʱ��λ�õ�Ԫ���Ǵ��ڵ���v��
			j--;//��������һ�δ�С����,j--�Ľ��,�����ʱ��λ�õ�Ԫ����С�ڵ���v��
		}
		Utils.swap(arr, l, j);
		return j;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,23,24,1,23,435,12,3,2,1,3,2};
		new QuickSort().sort(arr, arr.length);
		Utils.printArr(arr, "��������");
	}
}
