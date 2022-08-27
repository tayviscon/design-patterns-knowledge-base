

## [ПАТТЕРН НАБЛЮДАТЕЛЬ] - [JAVA]

### 1. Теория
`Наблюдатель` определяет отношение "один ко многим" между объектами
таким образом, что при изменении состояния одного объекта происходит
автоматическое оповещение и обновление всех зависимых объектов.    
### 2. Наблюдатель в действии
`Наблюдатель` - это поведенческий шаблон проектирования, который
представляет связь между объектами: *наблюдаемыми* и *наблюдателями*.
Наблюдаемый объект - это объект, который уведомляет наблюдателей об
изменениях в его состоянии.

Например, информационное агентство может уведомлять каналы о получении
новостей. Получение новостей - это то, что изменяет состояние информационного
агентства, и это приводит к уведомлению каналов.

### Начнем с интерфейсов:   
* **Интерфейс Наблюдаемого (Субъекта)**  
Используется для регистрации в качестве наблюдателя, а также исключения
из списка.
```java
public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```
* **Интерфейс Наблюдателя**  
Каждый потенциальный наблюдатель должен реализовать интерфейс *Observer*.
Интерфейс содержит единственный метод `update(Object o)`, который вызывается при
изменении состояния субъекта.  
```java
public interface Observer {
    void update(Object o);
}
```
### Давайте определим класс новостного агентства:

```java
public class NewsAgency implements Observable {
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
```
Новостное агентство является наблюдаемым, поэтому и реализует интерфейс `Observable`,
благодаря чему, когда новости обновляются, состояние новостного агентства меняется.
Когда происходит изменение, новостное агентство уведомляет об этом наблюдателей,
вызывая их метод `update(Object o)`.  

Чтобы иметь возможность это сделать, необходимо сохранять ссылки на наблюдателей.
В нашем случае это переменная `channels`.

### Давайте определим класс канала:
```java
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
```
Он имеет метод `update(Object o)`, который вызывается при изменении состояния новостного
агентства.
### Интерфейс `Channel` имеет всего два метода:
```java
public interface Channel extends Observer {
    void showNews();
}
```
* Метод `update(Object o)` унаследованный от интерфейса `Observer`;
* Метод `showNews()` для возможности отображения новостей;
___
Теперь, если мы добавим экземпляр `NewsChannle` в список наблюдателей и изменим состояние
`NewsAgency`, канал отобразит новость:  

**Для начала пишем тестовый код:**
```java
NewsAgency newsAgency = new NewsAgency();
NewsChannel newsChannel = new NewsChannel();
        
newsAgency.addObserver(newsChannel);
newsAgency.setNews("Мы впервые написали паттерн наблюдатель");
```
**Выполняем код и следим за тем, как работает паттерн `Наблюдатель`:**
```
Breaking news: Мы впервые написали паттерн наблюдатель
```