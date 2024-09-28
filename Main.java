import java.util.*;

import MyCalendarII731.MyCalendarII;

public class Main {
        public static void main(String[] args) {
                var cal = new MyCalendarII();
                System.out.println(cal.book(10, 20));
                System.out.println(cal.book(50, 60));
                System.out.println(cal.book(10, 40));
                System.out.println(cal.book(5, 15));
                System.out.println(cal.book(5, 10));
                System.out.println(cal.book(25, 55));
        }
}
