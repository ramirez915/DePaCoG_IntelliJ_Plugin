import designPatterns.Container;
import designPatterns.FactoryMethod;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/*
Abstract class name, variable amount, variable types,
abstract function amount,regular function amount, name of subclass
 */
public class FactoryMethodTest {
    private String[] inputArr;
    private FactoryMethod factoryMethod;

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Before
    public void setUp(){
        //**Arrange**
        String tmpDirPath = tmpFolder.getRoot().getAbsolutePath();
        String input = "Burger,2,String,int,3,2,Hamburger,Cheeseburger,Veggieburger";
        inputArr = input.split(",");
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(inputArr));

        //**Act**
        factoryMethod = new FactoryMethod(parameters,tmpDirPath);
        factoryMethod.createFactoryMethod();
    }

    /*
    factory methods way of getting the subclasses
    and checking that they have the correct amount
    of overridden abstract functions
     */
    @Test
    public void factoryMethodNewAcquireSubclasses(){
        //**Assert**
        int subclassesStart = 6;
        for(Container c: factoryMethod.getSubClassList()){
            assertEquals(inputArr[subclassesStart],c.name);
            assertEquals(Integer.parseInt(inputArr[4]),c.functionAmount);
            subclassesStart++;
        }
    }

    /*
    checks that the correct number of files were created
    using factory method design pattern (should be 5)
     */
    @Test
    public void factoryMethodCorrectFileAmount(){
        AbstractFactoryTest.correctNumFilesTest(5,"Burger",tmpFolder);
    }

}