package advance.common;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Common {
    public static void main(String[] args) {
        // 字符串是final类型，存储在方法区的常量池。
        String i = "";
        // hashCode返回int类型。
        i.hashCode();
        // equals比较方法字符串每个字符的地址值，或自定义比较方式。
        // "=="比较基本类型大小，或引用类型地址值。
        boolean b = i.equals("");

    }
}
