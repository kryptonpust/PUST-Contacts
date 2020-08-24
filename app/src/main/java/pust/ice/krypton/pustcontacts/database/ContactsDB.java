package pust.ice.krypton.pustcontacts.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import pust.ice.krypton.pustcontacts.database.tables.AcademicCouncil;
import pust.ice.krypton.pustcontacts.database.tables.Admin;
import pust.ice.krypton.pustcontacts.database.tables.DeanChairman;
import pust.ice.krypton.pustcontacts.database.tables.Departments;
import pust.ice.krypton.pustcontacts.database.tables.Faculties;
import pust.ice.krypton.pustcontacts.database.tables.FinanceCommittee;
import pust.ice.krypton.pustcontacts.database.tables.Menus;
import pust.ice.krypton.pustcontacts.database.tables.Nocs;
import pust.ice.krypton.pustcontacts.database.tables.Notices;
import pust.ice.krypton.pustcontacts.database.tables.Officers;
import pust.ice.krypton.pustcontacts.database.tables.Offices;
import pust.ice.krypton.pustcontacts.database.tables.Publications;
import pust.ice.krypton.pustcontacts.database.tables.RegentBoard;
import pust.ice.krypton.pustcontacts.database.tables.Residence;
import pust.ice.krypton.pustcontacts.database.tables.ResultNotices;
import pust.ice.krypton.pustcontacts.database.tables.Teachers;

@Database(entities = {Admin.class, Menus.class, Officers.class, Offices.class, Residence.class, Teachers.class, Departments.class, Faculties.class, DeanChairman.class, AcademicCouncil.class, FinanceCommittee.class, RegentBoard.class, Publications.class, Notices.class, Nocs.class, ResultNotices.class}, exportSchema = false, version = 3)
public abstract class ContactsDB extends RoomDatabase {
    private static ContactsDB INSTANCE;

    public static ContactsDB getINSTANCE(Context context) {
        if (INSTANCE == null) {
            synchronized (ContactsDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ContactsDB.class, "contacts").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DbDao databaseDao();
}
