package ru.tayviscon.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Observable{
    private String news;
    private List<Observer> channels = new ArrayList<>();

    public void setNews(String news) {
        this.news = news;
        newsHasBennUpdated();
    }


    @Override
    public void addObserver(Observer observer) {
        channels.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        channels.remove(observer);
    }

    @Override
    public void notifyObservers() {
        channels.forEach(observer -> observer.update(news));
    }

    private void newsHasBennUpdated() {
        notifyObservers();
    }
}
