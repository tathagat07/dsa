package dev.observerPattern.Observable;

import dev.observerPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable{
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void registerObserver(NotificationAlertObserver observer) {
        if (observer != null) {
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        observerList.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void setStockPrice(int newStockAdded) {

     if(stockCount == 0) {

         notifyObservers();
     }
        stockCount = stockCount + newStockAdded;
    }

    @Override
    public int getStockPrice() {
        return stockCount;
    }
}
