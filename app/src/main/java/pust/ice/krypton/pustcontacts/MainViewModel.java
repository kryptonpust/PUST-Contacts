package pust.ice.krypton.pustcontacts;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pust.ice.krypton.pustcontacts.database.ContactsDB;
import pust.ice.krypton.pustcontacts.database.DbDao;
import pust.ice.krypton.pustcontacts.database.tables.Departments;
import pust.ice.krypton.pustcontacts.database.tables.Faculties;
import pust.ice.krypton.pustcontacts.database.tables.Menus;
import pust.ice.krypton.pustcontacts.database.tables.Nocs;
import pust.ice.krypton.pustcontacts.database.tables.Notices;
import pust.ice.krypton.pustcontacts.database.tables.Offices;
import pust.ice.krypton.pustcontacts.database.tables.Publications;
import pust.ice.krypton.pustcontacts.database.tables.ResultNotices;
import pust.ice.krypton.pustcontacts.database.tables.Teachers;
import pust.ice.krypton.pustcontacts.pojo.OfficerPojo;

public class MainViewModel extends AndroidViewModel {
    private DbDao dbDao;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.dbDao = ContactsDB.getINSTANCE(application).databaseDao();
    }

    public LiveData<List<Menus>> getmenus() {
        return this.dbDao.getmenus();
    }

    public LiveData<List<Offices>> getOffices() {
        return this.dbDao.getoffices();
    }

    public LiveData<List<OfficerPojo>> getOfficeTeachers(String str) {
        return this.dbDao.getOfficeteachers(str);
    }

    public LiveData<List<OfficerPojo>> getOfficeOfficers(String str) {
        return this.dbDao.getOfficeOfficers(str);
    }

    public LiveData<List<OfficerPojo>> getResidenceTeacher(String str) {
        return this.dbDao.getResidenceTeachers(str);
    }

    public LiveData<List<Faculties>> getFaculties() {
        return this.dbDao.getFaculties();
    }

    public LiveData<List<Departments>> getDepartment(int i) {
        return this.dbDao.getDepartment_by_faculty_id(i);
    }

    public LiveData<List<OfficerPojo>> getDepartmentTeachers(String str) {
        return this.dbDao.getDeptTeacher(str);
    }

    public LiveData<List<OfficerPojo>> getFacultyByCode(String str) {
        return this.dbDao.getFacultyByCode(str);
    }

    public LiveData<List<OfficerPojo>> getAllDean() {
        return this.dbDao.getAllDean();
    }

    public LiveData<List<OfficerPojo>> getAllChairman() {
        return this.dbDao.getAllChairman();
    }

    public LiveData<List<OfficerPojo>> getsearchresult() {
        return this.dbDao.search();
    }

    public LiveData<List<OfficerPojo>> getAcMembers() {
        return dbDao.getaclist();
    }

    public LiveData<List<OfficerPojo>> getFcMembers() {
        return dbDao.getfclist();
    }

    public LiveData<List<OfficerPojo>> getDeptOfficers(String string2) {
        return dbDao.getDeptOfficers(string2);
    }

    public LiveData<List<OfficerPojo>> getRbMembers() {
        return dbDao.getrblist();
    }

    public LiveData<Teachers> getdetails(String id) {
        return dbDao.getdetails(id);
    }

    public LiveData<List<Publications>> getbookpublications(String user_id) {
        return dbDao.getpublication(user_id);
    }

    public LiveData<List<Notices>> getAllNotices(String general) {
        return dbDao.getAllNotices(general);
    }

    public LiveData<List<Nocs>> getAllNoc() {
        return dbDao.getAllNocs();
    }

    public LiveData<List<ResultNotices>> getallRNOT() {
        return dbDao.getAllResultNotices();
    }
}
