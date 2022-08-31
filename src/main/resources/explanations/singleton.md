## [ПАТТЕРН ОДИНОЧКА] - [JAVA]
### 1. Теория
`Одиночка` гарантирует, что класс имеет только один экземпляр, и предоставляет глобальную
точку доступа к этому экземпляру.
### 2. Одиночка в действии

### 2.1 Одиночка на основе класса
Самый популярный подход в реализации `Singleton` заключается в создании обычного класса и 
проверки того, что он имеет:

* Приватный конструктор;
* Статическое поле, содержащее его единственный экземпляр;
* Статический фабричный метод для получения экземпляра.
```java
public final class ClassBasedSingleton {
    private static ClassBasedSingleton INSTANCE;
    private String info = "Initial info class";

    private ClassBasedSingleton() {
    }

    public static ClassBasedSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ClassBasedSingleton();
        }

        return INSTANCE;
    }
}
```
Однако стоит отметить, что такой подход может быть проблематичным в сценариях многопоточности.
Проще говоря, это может привести к более чем одному экземпляру, нарушая основной принцип шаблона.
### 2.2 Одиночка на основе перечисления
Данный подход гарантирует обеспечения сериализации и потокобезопасности, на основе реализации
самого `Enum`, которая внутренне гарантирует, что доступен только один экземпляр:
```java
public enum EnumBasedSingleton {
    INSTANCE("Initial class info");
    private String info;

    private EnumBasedSingleton(String info) {
        this.info = info;
    }

    public EnumBasedSingleton getInstance() {
        return INSTANCE;
    }
}
```