package dev.observerPattern.Observable;

import dev.observerPattern.Observer.NotificationAlertObserver;

public interface StocksObservable {
     public void registerObserver(NotificationAlertObserver observer);

     public void removeObserver(NotificationAlertObserver observer);

     public void notifyObservers();

     public void setStockPrice(int newStockAdded);

     public int getStockPrice();
}
