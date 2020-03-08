import designPatterns.Builder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/*
class name, mandatory attribute amount, optional attribute amount,
mandatory attribute types, optional attribute types
 */
public class BuilderTest {
    private String[] inputArr;
    private Builder builder;

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Before
    public void setUp(){
        //**Arrange**
        String tmpDirPath = tmpFolder.getRoot().getAbsolutePath();
        String input = "Car,3,2,String,String,int,String,int";
        inputArr = input.split(",");
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(inputArr));

        //**Act**
        //create factory to then check the inputs
        builder = new Builder(parameters,tmpDirPath);
        builder.createBuilder();
    }

    /*
    test the new way of getting the parameters for builder
     */
    @Test
    public void builderNewAcquireInfo(){
        //**Assert
        //check that the builder has the correct number of attributes
        assertEquals(Integer.parseInt(inputArr[1]),builder.getMandatoryAttributeAmount());
        assertEquals(Integer.parseInt(inputArr[2]),builder.getOptionalAttributeAmount());
    }

    /*
    test the assignment of the attribute types
     */
    @Test
    public void builderCorrectTypes(){
        int startMandatory = 3;
        int startOptional = startMandatory + Integer.parseInt(inputArr[1]);
        for(String type: builder.getMandatoryAttributeTypes()){
            assertEquals(inputArr[startMandatory],type);
            startMandatory++;
        }

        for(String type: builder.getOptionalAttributeTypes()){
            assertEquals(inputArr[startOptional],type);
            startOptional++;
        }
    }
}