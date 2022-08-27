## [ПАТТЕРН ДЕКОРАТОР] - [JAVA]

### 1. Теория
`Декоратор` динамически наделяет объект новыми возможностями и является гибкой
альтернативой субклассированию в области расширения функциональности.
### 2. Декоратор в действии
`Декоратор` можно использовать для статического или динамического прикрепления
дополнительных обязанностей к объекту. Декоратор предоставляет улучшенный
интерфейс к исходному объекту.

В реализации данного паттерна мы предпочитаем композицию наследованию - так что
мы можем уменьшить накладные расходы на повторное создание подклассов для каждого
элемента оформления. Рекурсия, связанная с этим дизайном, может быть использована
для украшения нашего объекта столько раз, сколько нам потребуется.

Предположим, у нас есть объект напитка, и мы хотим добавлять в него различные 
пищевые добавки. Добавка не меняет сам объект, а просто "улучшает" его новыми 
элементами, такими как Соя, Молоко, Сахар и т. д.:

Для начала создадим абстрактный класс `Beverage`, стоит также отметить, что он
может быть заменен на интерфейс:
```java
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
```
Давайте реализуем абстрактный класс `CondimentDecorator` для пищевых добавок,
но при этом учтем:
- [X] Объекты должны быть взаимозаменяемыми с *Beverage*, поэтому расширяем класс *Beverage*;
- [X] Внутренний объект *Beverage*, который будет "заворачивать" в каждый *Decorator*. Стоит обратить внимание: мы используем подтип *Beverage*, чтобы декоратор мог быть оберткой для любого напитка;
- [X] Все декораторы должны заново реализовывать метод `getDescription()`;
```java
public abstract class CondimentDecorator extends Beverage {
    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    protected Beverage beverage;

    public abstract String getDescription();

}
```
### Реализуем некоторые напитки:
- [X] Все классы конкретных напитков расширяют `Beverage`;
```java
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    public double cost() {
        return 3.45;
    }
}
```
```java
public class Espresso extends Beverage{

    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 5.21;
    }
}
```
```java
public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "HouseBlend";
    }

    public double cost() {
        return 1.32;
    }
}
```
Теперь давайте создадим какие-нибудь декоративные элементы. Эти декораторы 
расширяют наш абстрактный класс `CondimentDecorator` и изменяют его методы
`cost()` и `getDescription()` в соответствии с нашими требованиями:

```java
public class Milk extends CondimentDecorator{

    public Milk(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 1.92;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
```
```java
public class Mocha extends CondimentDecorator{

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return beverage.cost() + 0.12;
    }
}
```
```java
public class Soy extends CondimentDecorator{

    public Soy(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 0.54;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
```
___
**Давайте приготовим кофе:**
```java
Beverage espresso = new Milk(new Mocha( new Soy(new Espresso())));
System.out.println(espresso.getDescription() + " $" + espresso.cost());

Beverage darkRoast = new Milk(new DarkRoast());
System.out.println(darkRoast.getDescription() + " $" + darkRoast.cost());
```
**Получим свой заказ:**
```
Espresso, Soy, Mocha, Milk $7.79
DarkRoast, Milk $5.37
```