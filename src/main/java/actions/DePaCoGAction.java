package actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.freedesktop.dbus.messages.Message;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DePaCoGAction extends com.intellij.openapi.actionSystem.AnAction {
    final static Logger logger = LoggerFactory.getLogger("DePaCoGAction");

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        DePaCoGMainWindow mainWindow = new DePaCoGMainWindow();
        String selectedDesPat = "";
        // when user makes selection
        if(mainWindow.showAndGet()){
            selectedDesPat = mainWindow.getSelection();
            //open next window here***


        }
//        String s = Messages.showInputDialog(e.getProject(),"Enter class name", "Class name dialog", Messages.getQuestionIcon());
//        System.out.println("user input "+ s);

//        Messages.showMessageDialog("Main project","This is a test message",Messages.getInformationIcon());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
    }
}
