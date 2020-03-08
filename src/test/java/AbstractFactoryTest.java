import designPatterns.AbstractFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/*
used junit 4 in order to be able to use the temp folder capability
functions from hw1 were modified in order to work as a plugin
 */

public class AbstractFactoryTest {
    private String[] inputArr;
    private AbstractFactory abstractFactory;
    /*
    creates a temp directory to store generated files in
    this guarantees the files and directory are deleted
     */
    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Before
    public void init(){
        //**Arrange**
        //get the path of the temp directory
        String tmpDirPath = tmpFolder.getRoot().getAbsolutePath();
        //parameters for an abstract factory as received in action
        String input = "Phone,3,Galaxy,iPhone,Xiaomi";
        inputArr = input.split(",");
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(inputArr));

        //**Act**
        //create factory to then check the inputs
        abstractFactory = new AbstractFactory(parameters,tmpDirPath);
        abstractFactory.createAbstractFactory();
    }

    /*
    testing the new way of acquiring user input to see if the sub classes
    from input are used correctly
     */
    @Test
    public void abstractFactoryNewAcquireSubclassesTest(){
        //**Assert**
        //compare the subclasses names in the abstract factory with the ones given
        int subclassPos = 2;
        for(int i = 0; i < abstractFactory.getSubClassList().size(); i++){
            String currSubclass = abstractFactory.getSubClassList().get(i).name;
            assertEquals(inputArr[subclassPos],currSubclass);
            subclassPos++;
        }
    }

    /*
    checks that the correct number of
    files are made. this design pattern should have 9
    but will allow other test to use this
     */
    @Test
    public void abstractFactoryCorrectNumFilesTest(){
        //**Assert**
        //now check that the correct number of files were generated
        //start by getting the new directory file to get children
        correctNumFilesTest(9,"Phone",tmpFolder);
    }

    /*
     will be used to check the correct number of file created
     public static so that it can be used throughout on other tests
     without an instance of this class
     */
    public static void correctNumFilesTest(int correctNumber,String directoryName,TemporaryFolder tmpFolder){
        File newDir = new File(tmpFolder.getRoot().getAbsolutePath() + "/" + directoryName);
        assertEquals("Incorrect number of files created",correctNumber,newDir.list().length);
    }
}