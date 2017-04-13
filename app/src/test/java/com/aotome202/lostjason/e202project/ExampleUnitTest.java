package com.aotome202.lostjason.e202project;

import android.os.SystemClock;

import com.aotome202.lostjason.e202project.assist.Logshow;

import org.junit.Test;

import java.io.Console;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    boolean isrun=true;
    @Test
    public void addition_isCorrect() throws Exception {
   int a=100;
        for (int i = 0; i <10 ; i++) {
            get(a);
            System.out.println(a);
        }
        System.out.println(a);
    }
    public static  void get(int a){
        a-=10;
    }
}