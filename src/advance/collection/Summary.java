package advance.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Summary {
    public static void main(String[] args) {
        // HashMap是数组+链表(1.8优化成数组+链表+红黑树)的组合实现，数组存储数据，链表解决冲突。
        // 每个数组元素Entery（由key，value，next组成）存储一个链表的头结点Node。
        // 当准备添加一个key-value对时，首先通过hash(key)方法计算hash值，然后通过indexFor(hash,length)求该key-value对的存储位置，
        // 计算方法是先用hash&0x7FFFFFFF(16进制最大正整数按位与)后，再对length取模，这就保证每一个key-value对都能存入HashMap中。
        // 没有产生hash冲突前，Node的next是null。当计算出的位置相同时，1.8之前将新的Node插入链表头部，1.8之后，这个链表只让挂7个元素，
        // 超过七个就会转成一个红黑树进行处理，当红黑树下挂的节点小于等于6的时候，系统会把红黑树转成链表，新的Node插入链表的尾部。
        // 线程不安全，继承自AbstractMap类，key可有一个为null，value可有多个null。默认容量为16。
        Map<String, String> map = new HashMap<>();
        // Hashtable线程安全，继承自Dictionary类。key和value都不能为null。默认容量为11。
        // HashTable容器使用synchronized来保证线程安全，但在线程竞争激烈的情况下HashTable的效率非常低下。
        // 因为当一个线程访问HashTable的同步方法时，其他线程访问HashTable的同步方法，可能会进入阻塞或轮询状态。
        // 如线程1使用put进行添加元素，线程2不但不能使用put方法添加元素，并且也不能使用get方法来获取元素，所以竞争越激烈效率越低。
        Map<String, String> table = new Hashtable<>();
        // ConcurrentHashMap线程安全，采用分段锁达到高效并发，继承自AbstractMap类。ConcurrentHashMap包含两个静态内部类 HashEntry 和 Segment。
        // HashEntry 用来封装映射表的键 / 值对;Segment 用来充当锁的角色，每个 Segment 对象守护整个散列映射表的若干个桶。
        // 每个桶是由若干个 HashEntry 对象链接起来的链表。一个 ConcurrentHashMap 实例中包含由若干个 Segment 对象组成的数组。
        // 每个Segment守护者一个HashEntry数组里的元素,当对HashEntry数组的数据进行修改时，必须首先获得它对应的Segment锁。
        // put、get不需要跨段，有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁。
        // 这里“按顺序”是很重要的，否则极有可能出现死锁，在ConcurrentHashMap内部，段数组是final的，并且其成员变量实际上也是final的，
        // 但是，仅仅是将数组声明为final的并不保证数组成员也是final的，这需要实现上的保证。这可以确保不会出现死锁，因为获得锁的顺序是固定的。
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        // LinkedHashMap继承自HashMap，所以它的底层仍然是基于拉链式散列结构，在数组+链表/红黑树的结构上，维护了一条双向链表，保持遍历顺序和插入顺序一致的问题。
        // 线程不安全，增删快。允许有null值null键。
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        // TreeMap实现了SortedMap接口，保证了有序性。线程不安全。不允许有null值null键。
        // 默认的排序是根据key值进行升序排序，也可以重写comparator方法来根据value进行排序具体取决于使用的构造方法。
        // 基于红黑树（Red-Black tree）实现，基本操作 containsKey、get、put 和 remove 的时间复杂度是 log(n)。
        Map<String, String> treemap = new TreeMap<>();
        // ArrayList底层结构为数组，线程不安全。查找快，增删慢(除了头尾)。
        List list = new ArrayList();
        // Vector底层结构为数组，线程安全。查找慢，增删快。
        List vector = new Vector();
        // LinkedList底层结构为双向链表，线程不安全。查找慢，增删快(除了头尾)。
        List linkedList = new LinkedList();
        // HashSet底层结构为Hash表。无序，无重复值。
        Set set = new HashSet();
        // LinkedHashSet底层结构为双向链表。有序，无重复值。
        // 继承于HashSet、又基于LinkedHashMap 来实现的
        Set linkedHashSet = new LinkedHashSet();
        // TreeSet底层结构为红黑树。有序，无重复值。效率低。可自定义排序。
        Set treeSet = new TreeSet();
    }
}
