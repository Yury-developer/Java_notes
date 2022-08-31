# Асимптотическая сложность алгоритмов

---

**Будем выделять асимптотики:**

* **@cpu** — **Вычислительнуая асимптотика** _(временная сложность)_ — сколько операций потребуется совершить компьютеру;
* **@ram** — **Пространственная асимптотика** _(пространственная сложность)_, т.е.  — сколько памяти потребуется для работы нашего алгоритма;


---

<img src="resources/Asymptotics/Asymptotics001.jpg" width="411">

## O(1) — константная сложность
**Константная.** _Константное время нахождение результата, не зависит от входных данных._
```
public class Class1 {

    // CPU: O(1)
    // RAM: O(1)
    public static int multiplication(int a, int b) {
        return a * b;
    }
}
```

## O(log(n)) — Логарифмический
**Логарифмическая.** _Обычно используется логарифм от **2**, если не указано иное. 
Алгоритм с производительностью **O(log (N))** делит количество рассматриваемых им элементов 
на фиксированный коэффициент при каждом шаге.
К алгоритмам с такой сложностью относятся алгоритмы типа **“Разделяй и Властвуй”** (Divide and Conquer)
Пример — **бинарный поиск**. Если массив отсортирован, мы можем проверить, есть ли 
в нём какое-то конкретное значение, методом деления пополам. Проверим средний элемент, если он 
больше искомого, то отбросим вторую половину массива — там его точно нет. Если же меньше, то 
наоборот — отбросим начальную половину. И так будем продолжать делить пополам, 
в итоге проверим **log n** элементов._
```
public class Class2 {

    // CPU: O(1)
    // RAM: O(1)
    
}
```

## O(sqrt(n)) — Корень
**Корень из n.** _На каждой итерации мы перепрыгиваем на шаг, равный **sqrt(N)**. Алгоритмы с производительностью **O(sqrt (N))**, где **sqrt** — функция извлечения квадратного корня, не являются общими.
Эта функция возрастает очень медленно, хотя и несколько быстрее, чем **log (N)**._
```
import java.util.ArrayList;
import java.util.List;
public class Class3 {

    // CPU: O(sqrt(x));
    // RAM: O(1);
    // Написать функцию, которая принимает число X (1 <= X <= 10^16). Возвращает массив  
    //    содержащий все уникальные простые делители в порядке возрастания. 
    //    (X является простым, если оно не делится ни на какое число до sqrt(X) (включительно));
    public static long[] calcPrimeNumbers(long x) {
        long[] results;
        if (x > 1) {
            final long maxValue = (long) Math.sqrt(x) + 1;
            long divider = 2L;
            List<Long> resultsList = new ArrayList();

            while (divider <= maxValue) {
                if (x % divider == 0 ) {
                    resultsList.add(divider);
                    while (x % divider == 0) {
                        x /= divider;
                    }
                }
                divider++;
            }
            if (x != 1) { resultsList.add(x); }
            results = resultsList.stream().mapToLong(Long::longValue).toArray();
        } else { results = new long[0]; }
        return results;
    }
}
```
[Ещё примеры](https://proglib.io/p/6-search-algorithms-java)

## O(n) — линейная
Алгоритм FindLargest (см. пункт «Правило 1» подраздела «Асимптотическая сложность алгоритма» в разделе «Свойство алгоритма» текущей главы) имеет производительность O(N).
Функция N возрастает быстрее, чем log (N) и sqrt (N), но все же не так быстро, поэтому большинство подобных алгоритмов демонстрирует на практике хорошую производительность.
```
public class Class4 {

    // CPU: O(n)
    // RAM: O(1)
    public static int sum(int a) {
        int sum = 0;
        for (int i = 0; i < a; i++) {
            sum++;
        }
        return sum;
    }
}
```

## O(n * log n) — Линеарифметический _(квазилинейная сложность)_
_Означает, что удвоение размера входных данных увеличит время выполнения чуть более, чем вдвое.
Т. е. время выполнения растет пропорционально **n log n** входных данных.
Примеры алгоритмов с такой сложностью: **Сортировка слиянием** или множеством n элементов._
```
public class Class5 {

    // CPU: O(n * log n)
    // RAM: O(1)
    public static void sum(int n) {
      for (int i = 1; i <= n; i++){
        for(int j = 1; j < n; j = j * 2) {
          System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
        }
      }
    }
}
```

## O(n^2) — квадратичная _(Алгоритмы с полиномиальным временем)_
_Означает, что удвоение размера входных данных увеличивает время выполнения в 4 раза. 
Такую сложность имеет, например, алгоритм **сортировки вставками**. В канонической реализации 
он представляет из себя два вложенных цикла: один, чтобы проходить по всему массиву, а второй, 
чтобы находить место очередному элементу в уже отсортированной части. Таким образом, количество 
операций будет зависеть от размера массива как **n * n**, т. е. **n^2** Если алгоритм имеет 
квадратичную сложность, то это повод пересмотреть необходимость использования данного алгоритма._
```
public class Class6 {

    // CPU: O(n^2)
    // RAM: O(1)
    public static void sum(int n) {
      for (int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
          System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
        }
      }
    }
}
```

## O(n^3) — кубическая
_Равстет еще быстрее, чем квадратичная_
```
public class Class7 {

    // CPU: O(n^3)
    // RAM: O(1)
    public static void sum(int n) {
      for (int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
          for(int k = 1; k <= n; k++) {
            System.out.println("Hey - I'm busy looking at: " + i + " , " + j + " and " + k);
          }
        }
      }
    }
}
```

## O(2^n) — экспоненциальная _(Алгоритмы с экспоненциальным временем)_
Теперь мы вступаем на опасную территорию; эти алгоритмы растут пропорционально 
некоторому коэффициенту, экспоненциальному размеру входных данных.
```
public class Class8 {

    // CPU: O(2^n)
    // RAM: O(1)
    public static void sum(int n) {
      for (int i = 1; i <= Math.pow(2, n); i++){
        System.out.println("Hey - I'm busy looking at: " + i);
      }
    }
    
    // Рекурсивный рассчет числа Фибоначи
    // CPU: O(2^n)
    // RAM: O(1)
    public static int getFibonachi(int n) {
      if (n < 2) {
        return n;
      }
      return getFibonachi(n - 1) + getFibonachi(n - 2)
    }
}
```

## O(n!) — факториальная
В большинстве случаев это настолько плохо, насколько это возможно. Время выполнения этого класса алгоритмов 
пропорционально факториалу входного размера. Классическим примером этого является решение 
**проблемы коммивояжера** с использованием метода _грубой силы_ для ее решения.
```
public class Class9 {

    // CPU: O(n!)
    // RAM: O(1)
    public static void sum(int n) {
      for (int i = 1; i <= factorial(n); i++){
        System.out.println("Hey - I'm busy looking at: " + i);
      }
    }
}
```


---
**Выводы:**
1. **Big O**   показывает **тамп роста функции**. Следовательно, **мы не учитываем константы и "неважную" сложность.**;
2. Последовательные действия - **сложение**;  Вложенные действия - **умножение**.;
3. Для алгоритма, где **на каждой итерации берется половина элементов** - сложность будет включать   **O (log N)**;

---
**Шпаргалка.** _Небольшие подсказки, которые помогут определить сложность алгоритма._
  + Получение элемента коллекции это **O(1)**. Будь то получение по индексу в массиве, или по ключу в словаре в нотации Big O это будет O(1).
  + Перебор коллекции это **O(n)**.
  + Вложенные циклы по той же коллекции это **O(n2)**.
  + Разделяй и властвуй (Divide and Conquer) всегда **O(log n)**.
  + Итерации которые используют “Разделяй и властвуй” (Divide and Conquer) это **O(n log n)**.

---
**Полезные ссылки**
  + [**Оценка сложности алгоритма**. _25-мин. видео. Доступно (и с примерами) основы анализа сложности алгоритмов.;_](https://youtu.be/ZRdOb4yR0kk)
  + [**Big O** - _статья на хабре о Big O.;_](https://habr.com/ru/post/444594/)
  + [**Знай сложности алгоритмов** - _статья о врем. вып. и о расх. памяти большинства алгоритмов.;_](https://habr.com/ru/post/188010/)
  + [**сам источник.**](https://bimlibik.github.io/posts/complexity-of-algorithms/)

---
golang algorithms
### Асимптотическая сложность
* Асимптотическая сложность (производительность) определяется функцией, которая указывает, насколько ухудшается работа алгоритма с усложнением поставленной задачи. Такую функцию записывают в круглых скобках, предваряя прописной буквой О.
* Существуют пять основных правил для расчета асимптотической сложности алгоритма.
    1. Если для математической функции  f алгоритму необходимо выполнить определенные действия f(N) раз, то для этого ему понадобится сделать O(f(N)) шагов.
    2. Если алгоритм выполняет одну операцию, состоящую из O(f(N)) шагов, а затем вторую операцию, включающую O(g(N)) шагов, то общая производительность алгоритма для функций f и g составит O(f(N) + g(N)).
    3. Если алгоритму необходимо сделать O(f(N)+g(N)) шагов и область значений N функции f(N) больше, чем у g(N), то асимптотическую сложность можно упростить до выражения O(f(N)).
    4. Если алгоритму внутри каждого шага O(f(N)) одной операции приходится выполнять еще O(g(N)) шагов другой операции, то общая производительность алгоритма составит O(f(N) u g(N)).
    5. Постоянными множителями(константами)можно пренебречь.Если C является константой, то O(C u f(N)) или O(f(C u N)) можно записать как O(f(N)).

* Правило 1
  Если для математической функции f алгоритму необходимо выполнить определенные действия f(N) раз, то для этого ему понадобится сделать O(f(N)) шагов.
    + Рассмотрим псевдокод с алгоритмом по нахождению наибольшего целого числа в массиве.
        ```
          Integer: FindLargest(Integer: array[])
           Integer: largest = array[0]
           For i = 1 To <наибольший индекс>
                   If (array[i] > largest) Then largest = array[i]
           Next i
            Return largest
        End FindLargest
        ```
    + В качестве входного параметра алгоритм FindLargest использует массив целых чисел, результат возвращается в виде одного целого числа. В самом начале переменной largest присваивается значение первого элемента массива. Затем алгоритм перебирает оставшиеся элементы и сравнивает значение каждого из них с largest. Если он находит большую величину, то приравнивает largest к ней и по окончании цикла возвращает наибольшее найденное значение.
      Алгоритм проверяет каждый из N элементов массива всего один раз, поэтому его производительность составляет O(N).

* Правило 2
    + Если алгоритм выполняет одну операцию, состоящую из O(f(N)) шагов, а затем вторую, требующую O(g(N)) шагов, то общая производительность алгоритма для функций f и g будет O(f(N) + g(N)).
    + Вернемся к алгоритму FindLargest. На этот раз обратите внимание, что несколько строк в действительности не включены в цикл. В следующем псевдокоде в комментариях справа приведен порядок времени выполнения все тех же шагов.
        ```
        Integer: FindLargest(Integer: array[])
           Integer: largest = array[0]            // O(1)
           For i = 1 To <наибльший индекс>        // O(N)
                   If (array[i] > largest) Then largest = array[i]
           Next i
           Return largest                         // O(1)
        End FindLargest
        ```
    + Итак, приведенный алгоритм выполняет один шаг отладки перед циклом и еще один после него. Каждый из них имеет производительность O(1) (это однократное действие), поэтому общее время работы алгоритма составит O(1 + N + 1). Если использовать обычную алгебру и преобразовать выражение, то получится O(2 + N).

* Правило 3
    + Если алгоритму необходимо сделать O(f(N) + g(N)) шагов и область значений N функции f(N) больше, чем у g(N), то асимптотическую сложность можно упростить до выражения O(f(N)).
    + В предыдущем примере мы выяснили, что время работы алгоритма FindLargest определяется выражением O(2 + N). Если параметр N начнет возрастать, его значение превысит постоянную величину 2 и предыдущее выражение можно будет упростить до O(N).
    + Игнорирование меньших функций позволяет пренебречь небольшими задачами отладки и очистки, чтобы сосредоточить внимание на асимптотическом поведении алгоритма, которое обнаруживается при усложнении задачи. Другими словами, время, затраченное алгоритмом на построение простых структур данных перед выполнением объемного вычисления, является несущественным по сравнению с длительностью основных расчетов.
* Правило 4
    + Если алгоритму внутри каждого шага O(f(N)) одной операции приходится выполнять еще O(g(N)) шагов другой операции, то общая производительность алгоритма составит O(f(N) u g(N)).
    + Рассмотрим алгоритм, который определяет, содержатся ли в массиве повторяющиеся элементы. (Стоит отметить, что это не самый эффективный способ обнаружения дубликатов.)
        ```
        Boolean: ContainsDuplicates(Integer: array[])
           // Цикл по всем элементам массива.
           For i = 0 To <наибольший индекс>
              For j = 0 To <наибольший индекс>
              // Проверяем, являются ли два элемента дубликатами. If (i != j) Then
                  If (i != j) Then
                      If (array[i] == array[j]) Then Return True
                  End If
              Next j
           Next i
          // Если мы дошли до этой строки, то дубликатов нет.
          Return False
      End ContainsDuplicates
      ```
    + Алгоритм содержит два цикла, один из которых является вложенным. Внешний цикл перебирает все элементы массива N, выполняя O(N) шагов. Внутри каждого такого шага внутренний цикл повторно пересматривает все N элементов массива, совершая те же O(N) шагов. Следовательно, общая производительность алгоритма составит O(N u N) = O(N2).
* Правило 5
    + Постоянными множителями (константами) можно пренебречь. Если C является константой, то O(C u f(N)) или O(f(C u N)) можно записать как O(f(N)).
    + Снова посмотрите на алгоритм ContainsDuplicates из предыдущего примера и обратите внимание на внутренний цикл, который представлен условием If. В рамках этого условия определяется, равны ли друг другу индексы i и j. Если нет — тогда сравниваются величины array[i] и array[j], в случае их совпадения возвращается значение True.
    + Пренебрегая дополнительным шагом в выражении Return (как правило, он выполняется один раз), предположим, что срабатывают оба оператора If (а так и происходит в большинстве случаев), тогда внутренний цикл будет пройден за O(2N) шагов. Следовательно, общая производительность алгоритма составит O(N u 2N) = = O(2N2). Последнее правило позволяет пренебречь коэффициентом 2 и записать производительность алгоритма в виде O(N2).
    + На самом деле мы возвращаемся к сути асимптотической сложности: нужно выяснить, как поведет себя алгоритм, если N начнет возрастать. Предположим, вы увеличите N в два раза, то есть будете оперировать значением 2N. Теперь если подставить фразу в выражение 2N2, получится следующее: 2 u (2N)2 = 2 u 4N2 = 8N2. Это и есть наша величина 2N2, только умноженная на 4. Таким образом, время работы алгоритма увеличится в четыре раза.
    + Теперь давайте оценим производительность алгоритма, используя упрощенное по правилу выражение O(N2). При подстановке в него 2N получим следующее: (2N)2 = 4N2. То есть наша изначальная величина N2 возросла в четыре раза, как и время работы алгоритма.
    + Из всего вышесказанного следует, что независимо от того, будете вы использовать развернутую формулу 2N2 или ограничитесь просто N2, результат останется прежним: увеличение сложности задачи в два раза замедлит работу алгоритма в четыре раза. Таким образом, важной здесь является не константа 2,а тот факт, что время работы увеличивается вместе с увеличением количества вводов N2.
    + ЗАМЕЧАНИЕ
        + Важно помнить, что асимптотическая сложность дает представление о теоретическом поведении алгоритма. Практические результаты могут отличаться. Предположим, производительность алгоритма равна O(N); если не пренебрегать целыми числами, реальное количество выполняемых шагов составит приблизительно 100 000 000 + N. В этом случае, пока N не слишком велико, значение константы лучше учитывать.


### O(1)
    Константное время нахождение результата
### Log (N)
    Алгоритм с производительностью O(log (N)) делит количество рассматриваемых им элементов на фиксированный коэффициент при каждом шаге.
### sqrt (N)
    Алгоритмы с производительностью O(sqrt (N)), где sqrt — функция извлечения квадратного корня, не являются общими и не рассматриваются в данной книге.
    Эта функция возрастает очень медленно, хотя и несколько быстрее, чем log (N).
### N
    Алгоритм FindLargest (см. пункт «Правило 1» подраздела «Асимптотическая сложность алгоритма» в разделе «Свойство алгоритма» текущей главы) имеет производительность O(N).
    Функция N возрастает быстрее, чем log (N) и sqrt (N), но все же не так быстро, поэтому большинство подобных алгоритмов демонстрирует на практике хорошую производительность.
### N log N
    Предположим, что алгоритм перебирает все элементы в поставленной задаче, а затем в отдельном цикле выполняет с элементом какую-то операцию O(log (N)).
    В этом случае производительность алгоритма определяется выражением O(N u log N) или O(N log N).
    Как вариант, задача может выглядеть так: алгоритм выполняет операцию O(log (N)) и на каждом ее шаге что-то делает с каждым элементом.
    Предположим, у вас есть отсортированное дерево, содержащее N элементов (как описано выше) и такой же размерности массив.
    Вам надо узнать, какие из элементов массива присутствуют в дереве.
    Один из способов выяснить это — осуществить циклическое прохождение по величинам массива, задействовав описанный ранее метод поиска по дереву.
    В процессе работы алгоритм проверит N элементов и выполнит log (N) шагов для каждого из них, так что общая производительность будет O(N u log N).
    Для многих алгоритмов сортировки, основанных на сравнении элементов, время работы составляет O(N u log N).
    На самом деле можно доказать, что любой подобный алгоритм проходит как минимум такое количество шагов, что очень удобно для определения асимптотической сложности.
    Однако некоторые алгоритмы являются все же более быстрыми благодаря целым числам, которые игнорируются асимптотическим обозначением.
### N2
    Алгоритм, который изначально перебирает все входные данные, а затем пересматривает их еще раз для каждого единичного значения, имеет производительность O(N2).
    Например, алгоритм ContainsDuplicates (см. пункт «Правило 4» подраздела «Асимптотическая сложность алгоритма» в разделе «Свойство алгоритма» текущей главы) выполняется именно за такое время.
    Возможны и другие степени N, предположим O(N3) или O(N4). Однако они являются значительно более медленными, чем O(N2).
    Говорят, алгоритм имеет многочленное время работы, если оно включает в себя многочлен N: например O(N), O(N2), O(N6) и даже O(N4000).
    В любом случае подобные задачи можно решить. А вот экспоненциальное и факториальное время работы, описанное ниже, возрастает очень быстро, поэтому алгоритмы с указанной производительностью будут применимы только для небольшого количества входных данных.
### 2N
    Экспоненциальные функции, такие как 2N, возрастают молниеносно и поэтому полезны для решения ограниченного круга задач.
    Обычно посредством алгоритмов с подобным временем работы ищется оптимальный набор входных данных.
    В качестве примера рассмотрим следующую задачу. Допустим, у вас есть рюкзак определенной грузоподъемности и набор принадлежностей, каждый из которых имеет свою массу и значение.
    Вам необходимо наполнить рюкзак предметами так, чтобы их общее значение оказалось наибольшим.
    Задача может показаться простой, но все известные алгоритмы для нахождения наилучшего решения потребуют изучить каждую возможную комбинацию предметов.
    Если учесть, что любой предмет способен пребывать только в двух состояниях (находиться в рюкзаке или вне его), то, умножив количество состояний на количество предметов, получим 2 u 2 u ... u 2 = 2N вариантов выбора.
    Иногда нет необходимости проверять все возможные комбинации. Например, если первый предмет заполняет собой рюкзак, то добавлять к нему еще что-то уже не имеет смысла. Однако в большинстве случаев вам не удастся исключить доста- точное количество вариантов, чтобы значительно сузить область поиска.
    При решении задач с экспоненциальным временем работы часто пользуются эвристиками — алгоритмами, которые дают хорошие результаты, но не гарантируют, что они будут наилучшими.
### N!
    Функция N! (читается как «N факториал») рекомендуется для работы с целыми числами больше 0 и определяется формулой N! = 1 u 2 u 3 u ... u N.
    Она возрастает намного быстрее, чем экспоненциальная функция 2N.
    В алгоритмах с факториальным временем работы, как правило, ищется оптимальное распределение входных данных.
    Например, у торгового представителя имеется список городов. Его задача — составить маршрут таким образом, чтобы посетить каждый населенный пункт один раз и вернуться в отправную точку, преодолев минимальное расстояние.
    Если городов немного, то все просто, но если список длинный, задача усложняется на порядок.
    Наиболее очевидный способ решения — перебрать все возможные варианты маршрута. Так, с помощью алгоритма можно выбрать N близлежащих населенных пунктов для первого города. После этого у вас останется N – 1 возможных пунктов, которые еще нужно посетить, затем N – 2 и т. д. Следовательно, общее количество вариантов маршрутов составит N u (N – 1) u u (N – 2) u ... u 1 = N!.