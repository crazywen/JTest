package xx.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTest<T> {

	private T t;

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return this.t;
	}

	public <K> void getK(K k) {
		System.out.println(k);
		return;
	}

	public <V extends Number> V getNumber(V v) {
		System.out.println(v);
		return v;
	}

	public List<?> getList(List<? extends Number> list) {
		// list.add(new Float(1.1));
		// list.add(new Integer(888));
		System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		GenericTest<?> te = new GenericTest<String>();
		te.setT(null);
		GenericTest<String> t = new GenericTest<String>();
		t.setT("test");
		
		t.getK("yyyyyyyy");
		t.getK(2);
		t.getK(t);
		
		System.out.println(t.getT());
		t.getNumber(new Integer(999));
		List<Double> list = new ArrayList<Double>();
		list.add(2d);
		List<?> source = te.getList(list);
		// source.add(5);
		System.out.println(source);
		
		Map map = new HashMap();		
	}

}
