import java.awt.event.ActionListener;

public interface ILaunchPage {
    void setActionListener(ActionListener listener);
    void showMainPage();
    void showSecondaryPage();
    void showPreviousPage();
}
