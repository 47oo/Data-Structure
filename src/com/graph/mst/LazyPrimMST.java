package com.graph.mst;

import java.util.ArrayList;
import java.util.List;

import com.graph.advance.Edge;
import com.graph.advance.IGraph;
import com.graph.advance.Iterator;
import com.heap.base.MinHeap;
/**
 * prim �㷨 ����ķ�㷨
 * @author 47
 *
 * @param <T>
 */
public class LazyPrimMST<T extends Comparable<T>> {
	//��ͼת��Ϊ����
	private IGraph<Edge<T>> ig;
	//С���� ����λ���庮heap�����������,�����ŵ��Ǳߵĳ���,Ҳ����˵�����Ǳ���
	private MinHeap<Edge<T>> mh;
	//���ڱ�Ƕ����Ƿ񱻷��ʹ�
	private boolean[] marked;
	//������ֱ�Ӿ��ǳ�ʼ����
	private List<Edge<T>> mst = new ArrayList<>();
	//���صıߵĳ���
	private String mstWeight="";
	//�����еĶ��㶼����һ�ν����ͱ�ʾ��С�������Ѿ�����
	private void visit(int v){
		if(!marked[v]){
			marked[v] = true;
			Iterator<Edge<T>> it = ig.iterator(v);
			while(it.hasNext()){
				Edge<T> e = it.next();
				//ֻ�е� a----b �������㶼�����,����ȷ���������Ѿ���С����������
				if(!marked[e.other(v)]){ 
					mh.add(e);
				}
			}
		}
	}
	private void lazy(int v){
		visit(v);
		while(!mh.isEmpty()){
			Edge<T> e = mh.removeMin();
			//���ڴ����α߼� a--a,Ĭ������
			if(marked[e.a()]==marked[e.b()]){
				continue;
			}
			mst.add(e);
			if(!marked[e.a()]){
				visit(e.a());
			}else{
				visit(e.b());
			}
		}
		for(int i=0;i<mst.size();i++){
			mstWeight+= mst.get(i).weight()+" ";
		}
		mstWeight.trim();
	}
	public LazyPrimMST(IGraph<Edge<T>> ig,MinHeap<Edge<T>> mh){
		this.ig = ig;
		this.mh = mh;
		marked = new boolean[ig.V()];
		//����ֱ����Ĭ�ϵĶ���0��ʼ
		lazy(0);
		
	}
	public List<Edge<T>> mstEdges(){
		return mst;
	}
	public String result(){
		return mstWeight;
	}
}
