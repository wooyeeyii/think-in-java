/**
 * 该例子展示了匿名内部类怎样通过创建特定的、一次性的类来解决问题
 * 优点：将解决特定问题的代码隔离、聚拢于一点
 * 缺点：不易阅读，谨慎使用
 */

package com.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {

    public static void main(String[] args) {
        File path = new File("./src/com/chapter14/dynamicproxy");
        String[] list;
        if (0 == args.length) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(""); //args[0]

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

}
