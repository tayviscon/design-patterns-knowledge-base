## [ПАТТЕРН СТРАТЕГИЯ] - [JAVA]

### 1. Теория
`Стратегия` позволяет нам изменять повеление алгоритма во время выполнения.
Как правило, мы начинаем с интерфейса, который используется для применения
алгоритма, а затем реализуем его несколько раз для каждого возможного алгоритма.
### 2. Стратегия в действии
Давайте представим ситуацию, когда нам необходимо применять различные виды
скидок в зависимости от того, какой сейчас праздник.  

Для начала создадим интерфейс `Discounter`, который будет реализован каждой 
из наших стратегий:
```java
public interface Discounter {
    BigDecimal applyDiscounter(BigDecimal amount);
}
```
Затем напишем два класса `EasterDiscounter` и `ChristmasDiscounter`, которые
будут реализовывать наш интерфейс `Discounter` давай скидку в 50% и 10% соответственно:
```java
public class EasterDiscounter implements Discounter {
    @Override
    public BigDecimal applyDiscounter(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}
```
```java
public class ChristmasDiscounter implements Discounter {
    @Override
    public BigDecimal applyDiscounter(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.9));
    }
}
```
Давайте проверим `стратегию` на тесте:
```java
Discounter easterDiscounter = new EasterDiscounter();

BigDecimal discountedValue = easterDiscounter
  .applyDiscount(BigDecimal.valueOf(100));

assertThat(discountedValue)
  .isEqualByComparingTo(BigDecimal.valueOf(50));
```
___
Стоит также отметить, что данное решение работает весьма хорошо, однако проблема в том,
что создание конкретного класса для каждой стратегии может быть затруднительной задачей.
В качестве альтернативы можно использовать анонимные внутренние типы, однако это по прежнему
многословно и не намного удобнее, чем предыдущее решение.
```java
Discounter easterDiscounter = new Discounter() {
    @Override
    public BigDecimal applyDiscount(final BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
};
```
### 3. Дополнительно
* #### 3.1 Использование Java 8
Начиная с Java 8 были введены лямбда выражения, которые сделали анонимные внутренние типы
менее избыточными, что позволяет создавать стратегии намного проще и чище.

Давайте создадим экземпляр `EasterDiscounter` используя лямбда выражения:
```java
Discounter easterDiscounter = amount -> amount.multiply(BigDecimal.valueOf(0.5));
```
Когда мы хотим определить множество `Discounters`, мы можем статически объявить их все в 
одном месте. Java 8 даже позволяет нам определять статические методы в интерфейсах, если
мы этого захотим:
```java
public interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);

    static Discounter christmasDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.9));
    }

    static Discounter newYearDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.8));
    }

    static Discounter easterDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.5));
    }
}
```