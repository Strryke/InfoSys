package week5.singleton;

public class LogFile {
    // reference variable to store logfile object
    private static LogFile instance = null;

    // attribute
    private String log = "";

    // private Constructor = Other class cannot instantiate!

    private LogFile() {}

    public static LogFile getInstance() {
        if (instance == null) {
            instance = new LogFile();
        }
        return instance;
    }

    public void INFO(String msg) {
        log += "\n" + msg;
    }

}

//class Singleton {
//    private static Singleton instance = null;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//
//        return instance;
//    }
//}
