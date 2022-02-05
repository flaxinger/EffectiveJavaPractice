import java.util.*;
import java.lang.*;
import java.io.*;

// Child Class와 equals를 사용해야만 한다면
// 아래와 같이 Child 클래스에서 뷰(view)를 제공하는 방식이 안전하다.
// --> 리스코프 치환 원칙을 따르면서 상속 클래스에 대한 올바른 equals 함수를 짜는 것은 불가능하다.
class Item10_1{

    public static class Parent{
        
        private int intOne;

        public Parent(int intOne){
            this.intOne = intOne;
        }

        @Override
        public boolean equals(Object o){
            if(o == this)
                return true;
            if(!(o instanceof Parent))
                return false;
            Parent comp = (Parent)o;
            return comp.intOne == intOne;
        }
    }

    public static class Child{

        private Parent parent;
        private int intTwo;


        public Parent asParent(){
            return this.parent;
        }

        public Child(int intOne, int intTwo){
            parent = new Parent(intOne);
            this.intTwo = intTwo;
        }
    }


    public static void main (String[] args) throws java.lang.Exception{
        
        Parent parent = new Parent(1);
        Child child = new Child(1, 2);

        System.out.println(parent.equals(child));
        System.out.println(child.asParent().equals(parent));

    }   
}