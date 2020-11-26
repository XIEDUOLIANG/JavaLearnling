package io;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * 遍历指定文件夹下的所有文件
 *
 * @author XieDuoLiang
 * @date 2020/9/30 上午10:47
 */
public class TraverseFiles {

    public static void main(String[] args) {

        File f = new File("/Users/xieduoliang/安装包");
        Long timeBefore = System.currentTimeMillis();
        String memory = (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024/1024+"mb";
        System.out.println("JVM内存占用："+((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024/1024)+"mb");
        //printlnFiles(f,0);
        printlnFiles(f);
        System.out.println("之前JVM内存占用："+memory);
        System.out.println("之后JVM内存占用："+((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024/1024)+"mb");
        Long timeAfter = System.currentTimeMillis();
        System.out.println("执行时间："+(((double)timeAfter-(double)timeBefore)/(double)1000)+"s");
    }

    /**
     * 递归
     * */
    public static void printlnFiles(File file,int deep){

        StringBuilder deepStr = new StringBuilder();
        deepStr.append("--".repeat(Math.max(0, deep)));

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            System.out.println(deepStr+"文件夹{"+file.getName()+"}");
            if (Objects.nonNull(files)) {
                if(files.length == 0){
                    System.out.println(deepStr+"空");
                } else {
                    for (File f: files) {
                        printlnFiles(f,deep+1);
                    }
                }
            }
        }
        else if (file.isFile()) {
            System.out.println(deepStr+"文件{"+file.getName()+"}");
        } else {
            System.out.println(deepStr+"未知类型");
        }
    }

    /**
     * 栈
     * 1.将files数组压入栈
     * 2.取栈的头部继续获取files，又压入栈
     * */
    public static void printlnFiles(File file){

        Stack<File> fileStack = new Stack<>();
        Stack<Integer> deepStack = new Stack<>();
        int deep = 0;
        File[] files = file.listFiles();
        if (Objects.nonNull(files)){
            for (File f:files) {
                fileStack.push(f);
                deepStack.push(deep);
            }

            while (!fileStack.isEmpty()){
                File deepFile = fileStack.pop();
                deep = deepStack.pop();
                StringBuilder deepStr = new StringBuilder();
                deepStr.append("--".repeat(Math.max(0,deep)));
                if(deepFile.isDirectory()){
                    System.out.println(deepStr+"文件夹{"+deepFile.getName()+"}");
                    File[] deepFiles = deepFile.listFiles();
                    if(Objects.nonNull(deepFiles)){
                        deep++;
                        for (File f:deepFiles) {
                            fileStack.push(f);
                            deepStack.push(deep);
                        }
                    }
                }
                else if(deepFile.isFile()){
                    System.out.println(deepStr+"文件{"+deepFile.getName()+"}");
                }else {
                    System.out.println(deepStr+"未知类型");
                }
            }
        }

    }
}
