package com.lionkwon.jxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class FirstExample {

	public void emit() {
		Observable.just(
				"hello", "Rxjava21", "Rxjava22", "Rxjava23",
				"hello", "Rxjava21", "Rxjava22", "Rxjava23",
				"hello", "Rxjava21")
		.subscribe(System.out::println);
		
		
		Observable.just("bring", "man", 1, 2, 3, 4, 5, 6)
		.subscribeOn(Schedulers.computation())
		.subscribe(data->System.out.println(Thread.currentThread().getName()+":"+data));
		
		Observable.just("brin2", "ma2", 1, 2, 3, 4, 5, 6)
		.subscribeOn(Schedulers.computation()) //
		.observeOn(Schedulers.newThread())
		.subscribe(data->System.out.println(Thread.currentThread().getName()+":"+data));
	}
	
		
	public static void main(String args[]) {
		FirstExample demo = new FirstExample();
		demo.emit();
		
	}
}
