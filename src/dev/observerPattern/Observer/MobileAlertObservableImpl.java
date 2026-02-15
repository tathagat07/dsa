package dev.observerPattern.Observer;

import dev.observerPattern.Observable.StocksObservable;

public class MobileAlertObservableImpl implements NotificationAlertObserver
{
    String mobileNumber;
    StocksObservable observable;

    public MobileAlertObservableImpl(String mobileNumber,StocksObservable observable) {
        this.mobileNumber = mobileNumber;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMobileAlert(mobileNumber, "Hurry up! New Stock is available");
    }

    private void sendMobileAlert(String mobileNumber, String msg) {
        System.out.println("Sending mobile alert to: " + mobileNumber);

    }
}
