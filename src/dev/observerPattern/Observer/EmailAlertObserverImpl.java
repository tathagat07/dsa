package dev.observerPattern.Observer;

import dev.observerPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    String email;

    StocksObservable stocksObservable;

    public EmailAlertObserverImpl(String email, StocksObservable stocksObservable) {
        this.email = email;
        this.stocksObservable = stocksObservable;

    }

    @Override
    public void update() {
        sendEmail(email,"Hurry up ! new Stock is available");

    }

    private void sendEmail(String email,String msg) {
        System.out.println("Sending email to: " + email);

    }
}
