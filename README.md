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

# Stream

## Function

### 简介

function：函数接口，主要用于不同类型转换；经典的使用场景就是Stream中的map方法。
Function<T, R>  泛型T代表的是的要转换的入参；R泛型是要输出的返参

### 方法

- apply（核心方法）

  ```java
  R apply(T t)：具体执行逻辑将入参泛型T转化为泛型R
  示例：
  Function<String,Integer> strToInt = Integer::parseInt;
  Integer apply = strToInt.apply("18");
  System.out.println(apply);
  ```

- andThen

  ```java
  default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)  ：apply方法的扩展，执行顺序-先执行Function本身的apply方法，后执行andThen里面的apply方法
  ```

- compose

  ```java
  default <V> Function<V, R> compose(Function<? super V, ? extends T> before)：apply方法的扩展，执行顺序和andThen相反-先执行compose里面的apply方法，后执行Function本身的apply方法
  ```

- andThen和compose方法比较

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

  

- identity:返回自身

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

## BiFunction

### 简介

Function接口的增强版，用法和Function用途一样，只不过入参有俩个变为了三个，其他功能都是类似的



## Predicate

### 简介

断言，主要用作判断。经典的使用场景是stream.filter方法，核心方法为test方法

### 方法

- test(核心方法)

  ```
  // 源码
  boolean test(T t);
  // 示例
  Predicate<String> predicateString = "test"::equals;
  System.out.println(predicateString.test("test"));
  ```

- and

  ```
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

- negate

  ```
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

- or

  ```
  // 源码
  default Predicate<T> or(Predicate<? super T> other) {
      Objects.requireNonNull(other);
      return (t) -> test(t) || other.test(t);
  }
  // 含义
  // 或者，当俩个条件有一个成立是就返回true
  ```

- isEqual

  ```
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



## BiPredicate

### 简介

Predicate的增强版，入参的Predicate的一个变为了俩个，具体的功能都是类似的

## Supplier

### 简介

方法主要返回指定泛型的对象，无参

### 方法

- get

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

## Consumer

### 简介

Consumer 消费者，无返回类型

### 方法

- accept

  ```
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

  ```
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

## BiConsumer

### 简介

Consumer的增强版，入参由Consumer的一个变为了俩个，

最经典的用例就是Map.foreach方法