# 1.lambda

lambda允许把函数作为方法的入参。精简了代码量

## lambda格式

```java
无参：()-{doSomething}
单个参数：(param)->{doSomething} 或 param->{doSomething}
俩个参数：(param1,param2)->{doSomething}
```

## lambda示例

```java
// 1.7之前线程创建
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("线程创建");

    }
}).start();

// 1.8使用lambda线程创建
// 无参
new Thread(() -> System.out.println("线程创建-lambda")).start();

// 单个参数
Function<Integer, String> function = integer -> integer.toString();
Function<Integer, String> function1 = (integer) -> integer.toString();


// 俩个参数
Map<Integer, String> map = new HashMap<>(6);
map.put(1, "name");
map.put(2, "age");
map.put(3, "sex");
map.forEach((key, value) -> System.out.println("key:" + key + "----value:" + value));
```

# 函数式接口

## Function

### 简介

function：函数接口，主要用于不同类型转换；经典的使用场景就是Stream中的map方法。
Function<T, R>  泛型T代表的是的要转换的入参；R泛型是要输出的返参

### 方法及代码示例

####  apply（核心方法）

  ```java
R apply(T t)：具体执行逻辑将入参泛型T转化为泛型R
  示例：
  Function<String,Integer> strToInt = Integer::parseInt;
  Integer apply = strToInt.apply("18");
  System.out.println(apply);
  ```

#### andThen

  ```java
default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)  ：apply方法的扩展，执行顺序-先执行Function本身的apply方法，后执行andThen里面的apply方法
  ```

#### compose

  ```java
default <V> Function<V, R> compose(Function<? super V, ? extends T> before)：apply方法的扩展，执行顺序和andThen相反-先执行compose里面的apply方法，后执行Function本身的apply方法
  ```

#### andThen和compose方法比较

  ```java
  Function<Integer, Integer> multiply10 = i -> {
      System.out.println("apply--i * 10;i=" + i);
      return i * 10;
  };
  Function<Integer, Integer> multiply100 = i -> {
      System.out.println("apply--i * 100;i=" + i);
      return i * 100;
  };
  System.out.println("andThen:start--------------------andThen:start");
  System.out.println(multiply10
          .andThen(multiply100)
          .apply(10));
  System.out.println("andThen:end--------------------compose:start");
  System.out.println(multiply10
          .compose(multiply100)
          .apply(10));
  ```

  

#### identity:返回自身

  ```java
  List<User> list = new ArrayList<>();
  list.add(new User("李四", 20));
  list.add(new User("李四", 20));
  list.add(new User("李四1", 20));
  list.add(new User("李四2", 20));
  list.add(new User("李四3", 23));
  list.add(new User("李四4", 24));
  HashMap<User, List<User>> collect = list.stream()
          .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.toList()));
  collect.forEach((k, v) -> System.out.println("identity---" + k + "+" + v));
  Map<Integer, List<User>> collect1 = list.stream()
          .collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
  collect1.forEach((k, v) -> System.out.println("------------------" + k + "+" + v));
  ```

### BiFunction

#### 简介

Function接口的增强版，用法和Function用途一样，只不过入参有俩个变为了三个，其他功能都是类似的

### BinaryOperator

#### 简介

BiFunction的增强版，功能主要和二元运算符相似,主要有俩个方法，maxBy（取俩者最大值）和minBy（取俩者最小值）

#### 代码示例

```
// 取最大值
System.out.println(BinaryOperator.maxBy(Integer::compareTo).apply(1, 2));
// 取最小值
System.out.println(BinaryOperator.minBy(Integer::compareTo).apply(1, 2));
```

### DoubleBinaryOperator

#### 简介

BinaryOperator增强版，只对double类型的数据进行操作,参数个数为俩个

#### 代码示例

```java
// 相加
DoubleBinaryOperator doubleBinaryOperator = Double::sum;
System.out.println(doubleBinaryOperator.applyAsDouble(10D, 20D));
// 	相除
DoubleBinaryOperator doubleBinaryOperator1 = (left, right) -> left / right;
System.out.println(doubleBinaryOperator1.applyAsDouble(100D, 20D));
```



## Predicate

### 简介

断言，主要用作判断。经典的使用场景是stream.filter方法，核心方法为test方法

### 方法及代码示例

#### test(核心方法)

  ```
  // 源码
  boolean test(T t);
  // 示例
  Predicate<String> predicateString = "test"::equals;
  System.out.println(predicateString.test("test"));
  ```

#### and

  ```java
  // 源码
  default Predicate<T> and(Predicate<? super T> other) {
      Objects.requireNonNull(other);
      return (t) -> test(t) && other.test(t);
  }
  //含义：
  //且关系，当predicate的条件和and的条件都满足是返回true
  示例：
  // and 俩个条件相等才会返回true
  System.out.println("and且false--->" + predicateString.and(t -> t.contains("t")).test("test"));
  System.out.println("and且false--->" + predicateString.and(t -> t.contains("t")).test("te"));
  
  ```

#### negate

  ```java
  // 源码
  default Predicate<T> negate() {
      return (t) -> !test(t);
  }
  // 含义 
  // 否定，对原来的predicated条件取反
  // 示例
   Predicate<String> negate = predicateString.negate();
          System.out.println("negate否true--->" + negate.test("tst"));
          System.out.println("negate否false--->" + negate.test("test"));
  
  ```

#### or

  ```java
  // 源码
  default Predicate<T> or(Predicate<? super T> other) {
      Objects.requireNonNull(other);
      return (t) -> test(t) || other.test(t);
  }
  // 含义
  // 或者，当俩个条件有一个成立是就返回true
  Predicate<Integer> predicateInteger1 = i -> i == 5;
  System.out.println("or或者true--->" + predicateInteger.or(predicateInteger1).test(5));
  System.out.println("or或者true--->" + predicateInteger.or(predicateInteger1).test(10));
  ```

#### isEqual

  ```java
  // 源码
  static <T> Predicate<T> isEqual(Object targetRef) {
      return (null == targetRef)
              ? Objects::isNull
              : object -> targetRef.equals(object);
  }
  //含义
  //包含，用法和Object.equals相同，只不过内部做了非空判断
  //示例
  Predicate<String> predicateEqual = Predicate.isEqual("name");
  System.out.println("isEqual包含true--->" + predicateEqual.test("name"));
  System.out.println("isEqual包含false--->" + predicateEqual.test("nme"));
  System.out.println("isEqual包含('')false--->" + predicateEqual.test(""));
  System.out.println("isEqual包含(null)false--->" + predicateEqual.test(null));
  ```



### BiPredicate

#### 简介

Predicate的增强版，入参的Predicate的一个变为了俩个，具体的功能都是类似的

## Supplier

### 简介

方法主要返回指定泛型的对象，无参

### 方法及代码示例

#### get

```
//源码：
T get();
// 含义
给定类型，接口实现的返参格式必须和Supplier的泛型一致
//示例
List<User> list = new ArrayList<>();
list.add(new User("李四", 18));
//对象处理
Supplier<User> supplier = User::new;
Supplier<User> supplierAll = () -> list.get(0);
System.out.println(supplier.get());
System.out.println(supplierAll.get());
```

### BooleanSupplier

#### 简介 

Supplier的增加版，核心方法无参数返回类型为boolean类型的getAsBoolean方法，主要用作判断

#### 方法及代码示例

##### getAsBoolean

```java
public static void main(String[] args) {
    // Supplier 增强版 ，判断条件是否相等，可以理解为if的判断条件
    int age = 10;
    int age1 = 100;
    BooleanSupplier booleanSupplier = () -> age == age1;
    System.out.println(booleanSupplier.getAsBoolean());
    System.out.println(isSuccess("赵四", "王五"));
    System.out.println(isSuccess("赵四1", "赵四1"));
}
public static boolean isSuccess(final String name, final String string) {
    BooleanSupplier booleanSupplier = () -> name.equals(string);
    return booleanSupplier.getAsBoolean();
}
```

## Consumer

### 简介

Consumer 消费者，无返回类型

### 方法

- accept

  ```java
  // 源码
  void accept(T t);
  // 含义
  // 对入参进行操作，输出，修改值
  List<User> list = new ArrayList<>();
  list.add(new User("李四", 18));
  list.add(new User("王五", 19));
  list.add(new User("赵大", 20));
  list.add(new User("钱二", 30));
  Consumer<List<User>> consumer = System.out::println;
  consumer.accept(list);
  // 未加强
  Consumer<List<User>> consumerSet = t -> t.forEach(t1 -> {
      if (t1.getName().equals("李四")) {
          t1.setName("李四未加强");
      }
  });
  consumerSet.accept(list);
  System.out.println("1--------------------------->");
  consumer.accept(list);
  // 加强
  Predicate<User> userPredicate = t -> t.getName().equals("李四未加强");
  Consumer<User> changeAge = t1 -> {
      if (userPredicate.test(t1))
          t1.setName("李四加强");
  };
  Consumer<List<User>> consumerSet1 = t -> t.forEach(changeAge);
  consumerSet1.accept(list);
  System.out.println("2--------------------------->");
  consumer.accept(list);
  ```

- andThen

  ```java
  // 源码
  default Consumer<T> andThen(Consumer<? super T> after) {
      Objects.requireNonNull(after);
      return (T t) -> { accept(t); after.accept(t); };
  }
  // 含义
  // 执行Consumer.accep后在执行andThen的accept方法
  // 示例
  Predicate<User> userPredicate = t -> t.getName().equals("李四未加强");
  Consumer<User> changeAge = t1 -> {
      if (userPredicate.test(t1)) {
          System.out.println("userPredicate李四加强--->");
          t1.setName("李四加强");
      }else {
          System.out.println("userPredicate李四加强No--->");
      }
  };
  Consumer<List<User>> consumerSet1 = t -> t.forEach(changeAge);
  consumerSet1.accept(list);
  System.out.println("2--------------------------->");
  consumer.accept(list);
  // andThen
  System.out.println("andThen--------------------------->");
  Consumer<List<User>> consumerSetNew = t -> t.forEach(t1 -> {
      if (t1.getName().equals("李四加强")) {
          System.out.println("consumerSetNew---------------");
          t1.setName("李四andThen");
      }
  });
  consumerSet1.andThen(System.out::println).andThen(consumerSetNew).accept(list);
  ```

### DoubleConsumer

#### 简介

DoubleConsumer为consumer增强版，参数为double无返回类型

#### 方法及代码示例

##### accept核心方法

```java
 List<String> list = new ArrayList<>();
 DoubleConsumer doubleConsumer = (param) -> list.add(String.valueOf(param * 10D));
 doubleConsumer.accept(10D);
 System.out.println("accept---->" + list);
```

##### andThen

```java
// 先执行accept方法在执行andThen方法
doubleConsumer.andThen((t) -> list.add(String.valueOf(t + 10)))
        .accept(10D);
System.out.println("andThen---->" + list);
```



### BiConsumer

#### 简介

Consumer的增强版，入参由Consumer的一个变为了俩个，

#### 方法及代码示例

##### accept

最经典的用例就是Map.foreach方法

```java

//代码示例
BiConsumer<Integer, Integer> integerBiConsumer = (v1, v2) -> System.out.println(v1 + v2);
integerBiConsumer.accept(10, 20);
Map<Integer, String> map = new HashMap<>(10);
map.put(10, "20");
map.put(11, "20");
map.put(13, "20");
map.forEach((key, value) -> {
    System.out.println(key + "---" + value);
});
```

##### andThen

```java
// 先执行accept方法在执行andThen方法
integerBiConsumer.andThen((v1, v2) -> System.out.println(v1 * v2)).accept(10, 20);
```

