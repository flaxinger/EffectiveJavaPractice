import java.util.*;
import java.lang.*;
import java.io.*;
import com.google.auto.value.AutoValue;

/**
 * Java AutoValue example 
 * Compile cmd: cls && javac -cp auto-value-1.5.2.jar Item10_2.java && java Item10_2
 */
class Item10_2{

    @AutoValue    
    public static abstract class Parent{

        abstract int intOne();

        public static Parent CreateParent(int intOne){
            return new AutoValue_Item10_2_Parent(intOne);
        }

    }

    @AutoValue
    public static abstract class Child{

        abstract Parent parent();
        abstract int intTwo();

        public static Child CreateChild(Parent intOne, int intTwo){
            return new AutoValue_Item10_2_Child(intOne, intTwo);
        }

    }


    public static void main (String[] args) throws java.lang.Exception{
        
        Parent parent = Parent.CreateParent(1);
        Child child = Child.CreateChild(parent, 2);
        Child childSame = Child.CreateChild(Parent.CreateParent(1), 2);

        // true, true
        System.out.println(parent.equals(child.parent()));
        System.out.println(child.parent().equals(parent));


        // true
        System.out.println(child.equals(childSame));
    }   
}