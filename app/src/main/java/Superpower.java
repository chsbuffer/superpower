import android.os.IUserManager;
import android.os.ServiceManager;
import android.util.Log;

public class Superpower {
    public final static String TAG = "SUPERPOWER";

    private static void waitSystemService(String name) {
        while (android.os.ServiceManager.getService(name) == null) {
            try {
                Log.i(TAG, "service " + name + " is not started, wait 1s.");
                //noinspection BusyWait
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.i(TAG, Log.getStackTraceString(e));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);

        waitSystemService("user");

        var binder = ServiceManager.getService("user");
        var um = IUserManager.Stub.asInterface(binder);

        um.setUserRestriction("no_install_unknown_sources_globally", false, 0);

        int retry = 0;
        while (!um.hasUserRestriction("no_install_unknown_sources_globally", 0) && ++retry < 20) {
            Log.i(TAG, "UserRestrictionModifier not started, wait 1s.");
            Thread.sleep(1000);
        }

        um.setUserRestriction("no_install_unknown_sources_globally", false, 0);
        Log.i(TAG, "install restriction for user " + 0 + " removed");
    }
}