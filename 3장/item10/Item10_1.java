import java.util.*;
import java.lang.*;
import java.io.*;

// Child Class�� equals�� ����ؾ߸� �Ѵٸ�
// �Ʒ��� ���� Child Ŭ�������� ��(view)�� �����ϴ� ����� �����ϴ�.
// --> �������� ġȯ ��Ģ�� �����鼭 ��� Ŭ������ ���� �ùٸ� equals �Լ��� ¥�� ���� �Ұ����ϴ�.
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