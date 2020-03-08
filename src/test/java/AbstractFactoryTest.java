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
    private String input;
    private String tmpDirPath;
    private String[] inputArr;
    private ArrayList<String> parameters;
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
        tmpDirPath = tmpFolder.getRoot().getAbsolutePath();
        //parameters for an abstract factory as received in action
        input = "Phone,3,Galaxy,iPhone,Xiaomi";
        inputArr = input.split(",");
        parameters = new ArrayList<>(Arrays.asList(inputArr));

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
     */
    @Test
    public void abstractFactoryCorrectNumFilesTest(){
        //**Assert**
        //now check that the correct number of files were generated
        //start by getting the new directory file to get children
        File newDir = new File(tmpFolder.getRoot().getAbsolutePath() + "/Phone");
        assertEquals("Incorrect number of files created",9,newDir.list().length);
    }
}