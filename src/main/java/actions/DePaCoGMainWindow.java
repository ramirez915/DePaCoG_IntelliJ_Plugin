package actions;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.uiDesigner.core.AbstractLayout;
import com.intellij.util.ui.GridBag;
import consts.MyConsts;
import designPatterns.AbstractFactory;
import designPatterns.Builder;
import designPatterns.FactoryMethod;
import designPatterns.Template;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/*
this will contain the main window of DePaCoG
will display the selections and allow user to choose
a design pattern to be created
 */
public class DePaCoGMainWindow extends DialogWrapper {

    private String mainPrompt = String.format("***Select a Design Pattern***\n" +
            "%-15d Abstract factory\n%-15d Builder\n%-15d Factory Method\n%-15d Facade %n" +
            "%-15d Chain of Responsibility\n%-15d Mediator\n%-15d Visitor\n%-15d Template %n" +
            "Enter the design pattern number you want, type 0 then enter to quit",1,2,3,4,5,6,7,8);
    private JPanel mainPanel;
    private JTextArea optionsMenu;
    private JTextField userSelection;
    private String selection;
    final static Logger logger = LoggerFactory.getLogger("DePaCoGMainWindow");

    protected DePaCoGMainWindow() {
        // will enable this window to be the parent of other windows made
        super(true);
        mainPanel = new JPanel(new GridBagLayout());
        optionsMenu = new JTextArea(mainPrompt);
        optionsMenu.setEditable(false);
        userSelection = new JTextField();
        init();
        setTitle("Main Selection Window");
    }


    /*
    set the dimensions and items on the main window
     */
    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        GridBag gridBag = new GridBag();
        gridBag.setDefaultInsets(0,0, AbstractLayout.DEFAULT_VGAP,AbstractLayout.DEFAULT_HGAP);
        gridBag.setDefaultWeightX(2);
        gridBag.setDefaultPaddingX(20);
        gridBag.setDefaultPaddingY(20);
        gridBag.setDefaultFill(GridBagConstraints.HORIZONTAL);

        mainPanel.setPreferredSize(new Dimension(300,300));
        mainPanel.add(optionsMenu,gridBag.nextLine().next().weightx(.03));
        mainPanel.add(userSelection,gridBag.nextLine().next().weightx(.03));
        logger.info("Main window created");

        return mainPanel;
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
        selection = userSelection.getText();
        logger.info("User selected {}",selection);

        // run the chosen design pattern                ***** MAYBE DONT HAVE TO DO THIS IN HERE SINCE WANT ANOTHER WINDOW...
//        createSelectedDesignPattern(selection);
    }

    public String getSelection(){return this.selection;}

    /*
    will take in the user input and create the selected design pattern
    1 abstract factory          2 builder   3 factory method    4 Facade
    5 chain of responsibility   6 mediator  7 visitor           8 template
     */
//    protected void createSelectedDesignPattern(String selection){
//        // maps the design pattern to a number
//        HashMap<String,String> desPatMap = new HashMap<>();
//        desPatMap.put("1","Abstract Factory");
//        desPatMap.put("2","Builder");
//        desPatMap.put("3","Factory Method");
//        desPatMap.put("4","Facade");
//        desPatMap.put("5","Chain of Responsibility");
//        desPatMap.put("6","Mediator");
//        desPatMap.put("7","Visitor");
//        desPatMap.put("8","Template");
//
//        // checks that the selected value is within range
//        if(Integer.parseInt(selection) > 8 || Integer.parseInt(selection) < 0){
//            logger.warn("Invalid option **{}** was selected",selection);
//            return;
//        }
//        // checks if the selection is implemented
//        else if(!MyConsts.verifyImplementation(desPatMap.get(selection))){
//            logger.warn("User wanted to create the **{}** design pattern that is not yet implemented",desPatMap.get(selection));
//            return;
//        }
//        try{
//            switch(selection){
//                case "1":
//                    new AbstractFactory().createAbstractFactory();
//                    break;
//                case "2":
//                    new Builder().createBuilder();
//                    break;
//                case "3":
//                    new FactoryMethod().createFactoryMethod();
//                    break;
//                case "4":
//                    break;
//                case "5":
//                    break;
//                case "6":
//                    break;
//                case "7":
//                    break;
//                case "8":
//                    new Template().createTemplate();
//                    break;
//                default:
//                    logger.warn("Selected number {} yields a design pattern in config set to true but not in switch statement",selection);
//            }
//        }catch(Exception e){
//            logger.error("***Unable to create {} design pattern***",desPatMap.get(selection));
//        }
//    }
}
