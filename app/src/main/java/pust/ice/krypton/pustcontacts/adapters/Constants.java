package pust.ice.krypton.pustcontacts.adapters;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import pust.ice.krypton.pustcontacts.BuildConfig;
import pust.ice.krypton.pustcontacts.api.Api;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class Constants {
    public static final String[] ACADEMIC_LIST = {"Faculty", "Departments", "All Dean", "All Chairman"};
    public static final String DATA_KEY = "data_key";
    public static final String DEPT_CODE = "dept_code";
    public static final String[] FACILITIES_LIST = {"Library", "Transport", "Residence", "Medical", "BTCL & PABX"};
    public static final String FACULTY_id = "faculty_id";
    public static final String ORIGIN_KEY = "aasdadf";
    public static final String[] RESIDENCE_LIST = {"BSMRH", "SSH"};
    public static final String[] GOVERNANCE_LIST = {"Academic Council", "Finance Committee", "Regent Board"};
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private static final String[] IMAGE_DIR = {"administrators", "teachers","governence"};
    public static final String[] NOTICE_LIST = {"General Notice", "Job Notice","Press Release","NOC","Result Notice"};

    //    public static String geturl(String str) {
//        if (str.startsWith("PUST_2") || str.startsWith("PUST_ 2")) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(Api.URL);
//            sb.append("includes/images/administrators/");
//            sb.append(str);
//            return sb.toString();
//        }
//        StringBuilder sb2 = new StringBuilder();
//        sb2.append(Api.URL);
//        sb2.append("includes/images/teachers/");
//        sb2.append(str);
//        return sb2.toString();
//    }
    public static String geturl(String str, int token) {
        if(0 <= token && token < IMAGE_DIR.length) {
            return (BuildConfig.URL + "includes/images/" + IMAGE_DIR[token] + "/" + str).trim();
        }
        return (BuildConfig.URL + "includes/images/man2.jpg").trim();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public enum ORIGIN {
        NULL,
        GOVERNANCE,
        G_ACADEMIC_COUNCIL,
        G_FINACE_COMMITTEE,
        G_REGENT_BOARD,
        ADMINISTRATION,
        ACADEMIC,
        FACALITIES,
        AC_DEPARTMENTS,
        AC_DEPARTMENT,
        AC_FACULTIES,
        AC_FACULTY,
        ALL_DEAN,
        ALL_CHAIRMAN,
        OFFICES,
        FC_RESIDENCE,
        FC_HALL,
        FC_BTCL,
        NOTICES,
        GENERAL,
        JOB,
        PRESS,
        NOC,
        RESULT
    }

}
