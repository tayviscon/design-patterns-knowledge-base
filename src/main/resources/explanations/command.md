## [ПАТТЕРН КОМАНДА] - [JAVA]
### 1. Теория
`Команда` инкапсулирует запрос в виде объекта, делая возможной параметризацию клиентских 
объектов с другими запросами, организацию очереди или регистрацию запросов, а также поддержку отмены операции.
### 2. Команда в действии
В классической реализации паттерн `Command` требует реализации четырёх компонентов:
* Клиента
* Команды
* Получателя
* Вызывающего

Давайте предположим, что хотим разработать приложение для текстовых файлов и реализуем базовые
функциональные возможности, необходимые для выполнения некоторых операций, связанных с текстовыми
файлами, таких как открытие, запись, чтение, сохранение и т. д.
### 2.1 Классы команды
Команда - это объект, роль которого заключается в хранении всей информации, необходимой для 
выполнения действия, включая вызываемый метод, аргументы метода и объекта (известный как получатель),
который реализует метод.

Таким образом, создадим простой командный уровень, который включает в себя всего один интерфейс и две реализации:
```java
@FunctionalInterface
public interface TextFileOperation {
    String execute();
}
```
```java
public class OpenTextFileOperation implements TextFileOperation {
    private TextFile textFile;
    @Override
    public String execute() {
        return textFile.open();
    }
}
```
```java
public class SaveTextFileOperation implements TextFileOperation {
    private TextFile textFile;
    @Override
    public String execute() {
        return textFile.save();
    }
}
```
Функциональность объекта `command` понятна: команды `TextFileOperation` инкапсулируют всю
необходимую информацию для открытия и сохранения текстового файла, включая объект получателя,
методы для вызова и аргументы.

Стоит также отметить, что компонент, который выполняет файловые операции, является получателем.
### 2.2 Классы получателя
Получатель - объект, который выполняет набор взаимосвязанных действий. Это компонент, который 
выполняет фактическое действие при вызове метода `execute()` команды.
```java
public class TextFile {
    private String name;

    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }
}
```
### 2.3 Классы вызывающего
Вызывающий - это объект, который знает, как выполнить данную команду, но не знает, как эта 
команда была реализована. Он знает только интерфейс команды.

В некоторых случаях вызывающий также сохраняет и ставит в очередь команды помимо их выполнения.
Это полезно для реализации некоторых дополнительных функций, таких как запись макросов или функция
отмены и повтора.

```java
public class TextFileOperationExecutor {
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
```
### 2.4 Классы клиента
Клиент - это объект, который управляет процессом выполнения команд, указывая, какие команды следует 
выполнять и на каких этапах процесса их выполнять.
```java
TextFileOperationExecutor textFileOperationExecuto
    = new TextFileOperationExecutor();
textFileOperationExecutor.executeOperation(
    new OpenTextFileOperation(new TextFile("file1.txt"))));
textFileOperationExecutor.executeOperation(
    new SaveTextFileOperation(new TextFile("file2.txt"))));
```