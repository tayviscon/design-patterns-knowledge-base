## [ПАТТЕРН ШАБЛОННЫЙ МЕТОД] - [JAVA]

### 1. Теория
`Шаблонный Метод` определяет "скелет" алгоритма в методе, оставляя определение реализации 
некоторых шагов субклассам. Субклассы могут переопределять некоторые части алгоритма без 
изменения его структуры.
### 2. Шаблонный метод в действии
Чтобы продемонстрировать, как работает паттерн `Шаблонный Метод` давайте создадим простой
пример, представляющий алгоритм заваривания напитков содержащих кофеин.  

Учитывая определение шаблона, структура алгоритма будет определена в базовом классе, который
определяет шаблонный метод `prepareRecipe()`:
```java
public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void brew();
    protected abstract void addCondiments();
    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void pourInCup(){
        System.out.println("pouring in Cap");
    }

}
```
Класс `CaffeineBeverage` отвечает за описание шагов, необходимых для заваривания напитка,
путем объявления методов добавления и настройки различных компонентов.  

Стоит также обратить внимание, что метод `prepareRecipe()` объявлен как окончательный, чтобы 
предотвратить его переопределение.

Так как базовый класс уже задан, давайте используем его, создав два подкласса. Один, который
готовит кофе, а другой - чай: 
```java
public class Coffee extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
```
```java
public class Tea extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}

```
Как мы видим, нам не нужно было беспокоиться обо всем процессе сборки, а только о предоставлении
реализаций для отдельных методов.
