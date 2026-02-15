package dev.observerPattern;

import dev.observerPattern.Observable.IphoneObservableImpl;
import dev.observerPattern.Observable.StocksObservable;
import dev.observerPattern.Observer.EmailAlertObserverImpl;
import dev.observerPattern.Observer.MobileAlertObservableImpl;
import dev.observerPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver  obj1 = new EmailAlertObserverImpl("abc@gmail.com", iphoneStockObservable);

        NotificationAlertObserver  obj2 = new EmailAlertObserverImpl("def@gmail.com", iphoneStockObservable);
        NotificationAlertObserver  obj3 = new MobileAlertObservableImpl("+91-8768767438", iphoneStockObservable);

        iphoneStockObservable.registerObserver(obj1);
        iphoneStockObservable.registerObserver(obj2);
        iphoneStockObservable.registerObserver(obj3);

        iphoneStockObservable.setStockPrice(1000);
    }
}
