## [ПАТТЕРН ФАБРИЧНЫЙ МЕТОД] - [JAVA]

### 1. Теория
`Фабричный метод` определяет интерфейс создания объекта, но позволяет субклассам выбрать
класс создаваемого экземпляра. Таким образом, Фабричный Метод делегирует операцию создания
экземпляра субклассам.
### 2. Фабричный Метод в действии
Давайте представим ситуацию, когда у нас есть пиццерия, у которой существуют региональные
версии, различающиеся стилем пиццы: у нью-йорскиой пиццы тонкая основа, у чикагской - толстая и т. д.
При этом, метод `orderPizza()` класса `PizzaStore` уже содержит проверенную систему оформления
заказов, и вы хотите, чтобы во всех пиццериях эта процедура оставалась одинаковой.  

Для этого каждому методу субклассу PizzaStore будет разрешено самостоятельно определить 
свой метод `createPizza()`.
```java
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    protected abstract Pizza createPizza(String type);
}
```
Таким образом, `фабричный метод` отвечает за создание объектов и инкапсулирует эту операцию 
в субклассе:
```java
public class NYStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else {
            return null;
        }
    }
}
```
```java
public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else {
            return null;
        }
    }
}
```
### НЕ хватает только одного: ПИЦЦЫ!
Начнем с абстрактного класса `Pizza`, который станет суперклассом для конкретных реализаций
классов пиццы.
```java
public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();


    protected void prepare() {
        System.out.println("Preparing " +  name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
        toppings.forEach(topping -> System.out.println("    -" + topping));
    }

    protected void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    protected void cut() {
        System.out.println("Cutting pizza into diagonal slices");
    }

    protected void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

}
```
Осталось только определить конкретные субклассы:
```java
public class ChicagoStyleCheesePizza extends Pizza{
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    protected void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
```
```java
public class NYStyleCheesePizza extends Pizza{
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
```
___
### Сколько можно ждать, несите пиццу!
Давайте сформируем заказ:
```java
PizzaStore nyStore = new NYStylePizzaStore();
PizzaStore chicagoStore = new ChicagoStylePizzaStore();

nyStore.orderPizza("cheese");
System.out.println("First ordered pizza is cooked\n");

chicagoStore.orderPizza("clam");
System.out.println("Second ordered pizza is cooked\n");
```
Ваш заказ готов:
```
Preparing NY Style Sauce and Cheese Pizza
Tossing dough...
Adding sauce...
Adding toppings:
    -Grated Reggiano Cheese
Bake for 25 minutes at 350
Cutting pizza into diagonal slices
Place pizza in official PizzaStore box
First ordered pizza is cooked

Preparing Chicago Style Deep Dish Cheese Pizza
Tossing dough...
Adding sauce...
Adding toppings:
    -Shredded Mozzarella Cheese
    -Special Calm Pizza topping
Bake for 25 minutes at 350
Cutting the pizza into square slices
Place pizza in official PizzaStore box
Second ordered pizza is cooked
```
