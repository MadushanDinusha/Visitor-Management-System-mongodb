package visitor.manage.build;

import org.tanukisoftware.wrapper.WrapperListener;

public class VisitorManageStarter implements WrapperListener {

    public static void main(String[] args) {
        VisitorManageConfig visitorManageApp = new VisitorManageConfig();
        visitorManageApp.init();
    }

    @Override
    public Integer start(String[] strings) {
        return null;
    }

    @Override
    public int stop(int i) {
        return 0;
    }

    @Override
    public void controlEvent(int i) {

    }
}
