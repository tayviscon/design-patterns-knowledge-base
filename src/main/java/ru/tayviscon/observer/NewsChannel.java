package ru.tayviscon.observer;

public class NewsChannel implements Channel{
    private String news;
    @Override
    public void update(Object o) {
        this.news = (String) o;
        showNews();
    }

    @Override
    public void showNews() {
        System.out.println("Breaking news: " + news);
    }
}
