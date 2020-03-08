import designPatterns.Container;
import designPatterns.Template;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/*
Main Abstract class name,abstract function total,regular function total,
amount of absolute processes,number of functions in each process,name of subclasses
 */
public class TemplateTest {
    private String inputArr[];
    private Template template;

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Before
    public void setUp(){
        //**Arrange**
        //get the path of the temp directory
        String tmpDirPath = tmpFolder.getRoot().getAbsolutePath();
        //parameters for an abstract factory as received in action
        String input = "Table,2,1,3,4,2,2,GlassTable,WoodenTable,MetalTable";
        inputArr = input.split(",");
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(inputArr));

        //**Act**
        template = new Template(parameters,tmpDirPath);
        template.createTemplate();
    }

    /*
    tests the new way of creating the subclasses for template
     */
    @Test
    public void templateNewSubclassesCreation(){
        int subclassesStart = 3 + Integer.parseInt(inputArr[3]) + 1;
        for(Container c: template.getSubClassList()){
            assertEquals(inputArr[subclassesStart],c.name);
            assertEquals(Integer.parseInt(inputArr[1]),c.functionAmount);
            subclassesStart++;
        }
    }

    /*
    checks if the correct number of files were created for template (4)
     */
    @Test
    public void templateCorrectFileNum(){
        AbstractFactoryTest.correctNumFilesTest(4,"Table",tmpFolder);
    }

}