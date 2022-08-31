### [ПАТТЕРН АБСТРАКТНАЯ ФАБРИКА] - [JAVA]
### 1. Теория
`Абстрактная фабрика` предоставляет интерфейс создания взаимосвязанных или взаимозависимых
объектов без указания их конкретных классов.
### 2. Абстрактная фабрика в действии

Представим, что у нас есть сеть пиццерий, в которых процесс приготовления одинаковый, однако
ингредиенты могут отличаться: В Нью-Йорке пиццу готовят с тонкой корочкой, а в Чикаго предпочитают 
пиццу с толстой.

Начнем с того, что определим все ингредиенты которые могут изменяться в зависимости от локализации
в виде интерфейсов, а их реализации в виде конкретных классов:
* `Pepperoni` - {`SlicedPepperoni`}
* `Veggeies` - {`BlackOlives`, `Eggplant`, `Garlic`, `Mushroom`, `Onion`, `RedPepper`}
* `Cheese` - {`MozzarellaCheese`, `ParmesanCheese`, `ReggianoCheese`}
* `Clams` - {`FreshClams`, `FrozenCalms`}
* `Dough` - {`ThickCrustDough`, `ThincrustDough`}
* `Sause` - {`MarinaraSauce`, `PlumTomateSauce`}  
Теперь нам необходимо понять, какие ингредиенты использовать в зависимости от локализации.
В этом нам поможет Фабрика, давайте же определим интерфейс абстрактной фабрики:
```java
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClams();
}
```
Реализации данной фабрики определяют перечень ингредиентов, которые используются для приготовления:
```java
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
```
```java
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new BlackOlives(), new Spinach(), new Eggplant()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
```
Модель абстрактной пиццы представляет собой перечень ингредиентов и знает какие ингредиенты 
использовать благодаря фабрике ингредиентов, а также методы для её приготовления:
```java
public abstract class Pizza {

    protected final PizzaIngredientFactory pizzaIngredientFactory;

    public Pizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] veggies;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clams;


    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```
Конкретные же реализации данного абстрактного класса настраивают непосредственно саму 
пиццу и методы её приготовления, упаковки, нарезания и т. д.

Непосредственно для самого заказа мы используем абстрактный класс `PizzaStore`, использующий
фабричный метод `Pizza createPizza(String type)`, а метод `Pizza orderPizza(String type)`
позволяет обеспечить общий алгоритм приготовления пиццы:
```java
public abstract class PizzaStore {
    protected  abstract Pizza createPizza(String item);

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        System.out.println("--- Making a" + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
```