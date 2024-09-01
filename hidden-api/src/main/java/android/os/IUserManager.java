package android.os;

public interface IUserManager extends IInterface {

    void setUserRestriction(String key, boolean value, int userId);
    boolean hasUserRestriction(String key, int userId);

    abstract class Stub extends Binder implements IUserManager {

        public static IUserManager asInterface(IBinder obj) {
            throw new RuntimeException("STUB");
        }
    }
}