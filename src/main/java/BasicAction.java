import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.util.ui.UIUtil;
import org.freedesktop.dbus.messages.Message;
import org.jetbrains.annotations.NotNull;

public class BasicAction extends com.intellij.openapi.actionSystem.AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        String s = Messages.showInputDialog(e.getProject(),"Enter class name", "Class name dialog", Messages.getQuestionIcon());
        System.out.println("user input "+ s);

//        Messages.showMessageDialog("Main project","This is a test message",Messages.getInformationIcon());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
    }
}
