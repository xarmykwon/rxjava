package com.lionkwon.jxjava;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FirstExample {

	public void emit() {
		Observable.just("hello", "Rxjava21", "Rxjava22", "Rxjava23", "hello", "Rxjava21", "Rxjava22", "Rxjava23",
				"hello", "Rxjava21").subscribe(System.out::println);

		// Observable.just("bring", "man", 1, 2, 3, 4, 5, 6)
		// .subscribeOn(Schedulers.computation())
		// .subscribe(data->System.out.println(Thread.currentThread().getName()+":"+data));

		Observable<Object> source = Observable.just("bring", "man", 1, 2, 3);
		Disposable disposable = source.subscribe(data -> {
			System.out.println("onNext ->" + data);
		}, e -> System.out.println("Error ->" + e), () -> System.out.println("onNext ->"));
		if (disposable.isDisposed()) {
			System.out.println("isDisposed true");
		} else {
			System.out.println("isDisposed false");
		}

		// Observable.just("brin2", "ma2", 11, 22, 33, 44, 55, 66)
		// .subscribeOn(Schedulers.computation()) //
		// .observeOn(Schedulers.newThread())
		// .subscribe(data->System.out.println(Thread.currentThread().getName()+":"+data));

		// hello.
		Observable<String> source_create = Observable.create((ObservableEmitter<String> emitter) -> {
			emitter.onNext("12");
			emitter.onNext("123");
			emitter.onNext("1234");
			emitter.onComplete();
		});
		source_create.subscribe(d -> {
			System.out.println("onNext ->" + d);
		});
		
		source_create.subscribe(new Consumer<String>() {
				public void accept(String t) throws Exception {
					System.out.println("onNext ->" + t);
				};
		});
	}

	public static void main(String args[]) {
		FirstExample demo = new FirstExample();
		demo.emit();

	}
}
