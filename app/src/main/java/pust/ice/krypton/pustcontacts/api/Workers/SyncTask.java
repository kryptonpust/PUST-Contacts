package pust.ice.krypton.pustcontacts.api.Workers;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pust.ice.krypton.pustcontacts.api.Ainterface.ApiCall;
import pust.ice.krypton.pustcontacts.api.Ainterface.Objects.CheckObject;
import pust.ice.krypton.pustcontacts.api.Ainterface.Objects.FetchObject;
import pust.ice.krypton.pustcontacts.api.Ainterface.Objects.Info;
import pust.ice.krypton.pustcontacts.api.Api;
import pust.ice.krypton.pustcontacts.database.ContactsDB;
import pust.ice.krypton.pustcontacts.database.DbDao;
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
import pust.ice.krypton.pustcontacts.pojo.Postpojo;
import retrofit2.Response;

public class SyncTask {

    private Context context;
    private DbDao dbDao;
    private ApiCall call;
    private Onprogresslistener listener;

    public SyncTask(Context context) {
        this.dbDao = ContactsDB.getINSTANCE(context).databaseDao();
        this.context = context;
    }

    public void startSync() {
        call = Api.createService(ApiCall.class);
        Response<CheckObject> check = null;
        try {
            check = call.performCheck().execute();
            listener.onProgress(1, "Requesting latest manifest");
            if (check.isSuccessful()) {
                CheckObject object = check.body();
                if (object == null)
                    throw new NullPointerException(); //checking for empty body

                dbDao.deleteAllPublications();

                for (Publications p : object.getAvail_profiles()) {
                    dbDao.addPublication(p);
                }
                //remote data (only id and time)
                List<Info> avail_menu = object.getAvail_menu(),
                        avail_offices = object.getAvail_offices(),
                        avail_officers = object.getAvail_officers(),
                        avail_teachers = object.getAvail_teachers(),
                        avail_residence = object.getAvail_residence(),
                        avail_admin = object.getAvail_admin(),
                        avail_departments = object.getAvail_departments(),
                        avail_faculties = object.getAvail_faculties(),
                        avail_dc = object.getAvail_dc(),
                        avail_ac = object.getAvail_ac(),
                        avail_fc = object.getAvail_fc(),
                        avail_rb = object.getAvail_rb(),
                        avail_not = object.getAvail_not(),
                        avail_noc = object.getAvail_noc(),
                        avail_rnot = object.getAvail_rnot();
                listener.onProgress(2, "Received latest manifest");
                //Local data
                List<Info> local_menu = dbDao.getlocalmenu(),
                        local_offices = dbDao.getlocaloffices(),
                        local_officers = dbDao.getlocalofficers(),
                        local_teachers = dbDao.getlocalteachers(),
                        local_residence = dbDao.getlocalresidence(),
                        local_admin = dbDao.getlocaladmin(),
                        local_departments = dbDao.getlocaldepartments(),
                        local_faculties = dbDao.getlocalfaculties(),
                        local_dc = dbDao.getlocaldc(),
                        local_ac = dbDao.getlocalac(),
                        local_fc = dbDao.getlocalfc(),
                        local_rb = dbDao.getlocalrb(),
                        local_not = dbDao.getlocalnot(),
                        local_noc = dbDao.getlocalnoc(),
                        local_rnot = dbDao.getlocalrnot();
                listener.onProgress(3, "Gathering local data");

                //performing filtering actions
                List<List<Integer>> menu_ids = filterServerandlocal(avail_menu, local_menu),
                        office_ids = filterServerandlocal(avail_offices, local_offices),
                        officers_ids = filterServerandlocal(avail_officers, local_officers),
                        teachers_ids = filterServerandlocal(avail_teachers, local_teachers),
                        residence_ids = filterServerandlocal(avail_residence, local_residence),
                        admin_ids = filterServerandlocal(avail_admin, local_admin),
                        departments_ids = filterServerandlocal(avail_departments, local_departments),
                        faculties_ids = filterServerandlocal(avail_faculties, local_faculties),
                        dc_ids = filterServerandlocal(avail_dc, local_dc),
                        ac_ids = filterServerandlocal(avail_ac, local_ac),
                        fc_ids = filterServerandlocal(avail_fc, local_fc),
                        rb_ids = filterServerandlocal(avail_rb, local_rb),
                        not_ids = filterServerandlocal(avail_not, local_not),
                        noc_ids = filterServerandlocal(avail_noc, local_noc),
                        rnot_ids = filterServerandlocal(avail_rnot, local_rnot);


                listener.onProgress(4, "Purging unnecessary local data");
                //deleting invalid data from local db
                if (!menu_ids.get(1).isEmpty()) {
                    for (Integer i : menu_ids.get(1)) {
                        dbDao.deletemenubyid(i);
                    }
                }
                if (!office_ids.get(1).isEmpty()) {
                    for (Integer i : office_ids.get(1)) {
                        dbDao.deleteofficebyid(i);
                    }
                }
                if (!officers_ids.get(1).isEmpty()) {
                    for (Integer i : officers_ids.get(1)) {
                        dbDao.deleteofficerbyid(i);
                    }
                }
                if (!teachers_ids.get(1).isEmpty()) {
                    for (Integer i : teachers_ids.get(1)) {
                        dbDao.deleteteacherbyid(i);
                    }
                }
                if (!residence_ids.get(1).isEmpty()) {
                    for (Integer i : residence_ids.get(1)) {
                        dbDao.deleteresidencebyid(i);
                    }
                }
                if (!admin_ids.get(1).isEmpty()) {
                    for (Integer i : admin_ids.get(1)) {
                        dbDao.deleteadminbyid(i);
                    }
                }
                if (!departments_ids.get(1).isEmpty()) {
                    for (Integer i : departments_ids.get(1)) {
                        dbDao.deletedepartmentbyid(i);
                    }
                }
                if (!faculties_ids.get(1).isEmpty()) {
                    for (Integer i : faculties_ids.get(1)) {
                        dbDao.deletefacultybyid(i);
                    }
                }
                if (!dc_ids.get(1).isEmpty()) {
                    for (Integer i : dc_ids.get(1)) {
                        dbDao.deletedcbyid(i);
                    }
                }
                if (!ac_ids.get(1).isEmpty()) {
                    for (Integer i : ac_ids.get(1)) {
                        dbDao.deleteacbyid(i);
                    }
                }
                if (!fc_ids.get(1).isEmpty()) {
                    for (Integer i : fc_ids.get(1)) {
                        dbDao.deletefcbyid(i);
                    }
                }
                if (!rb_ids.get(1).isEmpty()) {
                    for (Integer i : rb_ids.get(1)) {
                        dbDao.deleteRbbyid(i);
                    }
                }
                if (!not_ids.get(1).isEmpty()) {
                    for (Integer i : not_ids.get(1)) {
                        dbDao.deletenotbyid(i);
                    }
                }

                if (!noc_ids.get(1).isEmpty()) {
                    for (Integer i : noc_ids.get(1)) {
                        dbDao.deletenocbyid(i);
                    }
                }
                if (!rnot_ids.get(1).isEmpty()) {
                    for (Integer i : rnot_ids.get(1)) {
                        dbDao.deleternotbyid(i);
                    }
                }


                // building actual parameter to pass with post request
                if (menu_ids.get(0).size()
                        + office_ids.get(0).size()
                        + officers_ids.get(0).size()
                        + teachers_ids.get(0).size()
                        + residence_ids.get(0).size()
                        + admin_ids.get(0).size()
                        + departments_ids.get(0).size()
                        + faculties_ids.get(0).size()
                        + dc_ids.get(0).size()
                        + ac_ids.get(0).size()
                        + fc_ids.get(0).size()
                        + rb_ids.get(0).size() != 0) {
                    listener.onProgress(5, "Preparing data for request");
                    String menu_string = "",
                            office_string = "",
                            officers_string = "",
                            teachers_string = "",
                            residence_string = "",
                            admin_string = "",
                            deparments_string = "",
                            faculties_string = "",
                            dc_string = "",
                            ac_string = "",
                            fc_string = "",
                            rb_string = "",
                            not_string="",
                            noc_string="",
                            rnot_string="";

                    if (menu_ids.get(0).size() != 0) {
                        menu_string = formatstring(menu_ids.get(0).toString());
                    }
                    if (office_ids.get(0).size() != 0) {
                        office_string = formatstring(office_ids.get(0).toString());
                    }
                    if (officers_ids.get(0).size() != 0) {
                        officers_string = formatstring(officers_ids.get(0).toString());
                    }
                    if (teachers_ids.get(0).size() != 0) {
                        teachers_string = formatstring(teachers_ids.get(0).toString());
                    }
                    if (residence_ids.get(0).size() != 0) {
                        residence_string = formatstring(residence_ids.get(0).toString());
                    }
                    if (admin_ids.get(0).size() != 0) {
                        admin_string = formatstring(admin_ids.get(0).toString());
                    }
                    if (departments_ids.get(0).size() != 0) {
                        deparments_string = formatstring(departments_ids.get(0).toString());
                    }
                    if (faculties_ids.get(0).size() != 0) {
                        faculties_string = formatstring(faculties_ids.get(0).toString());
                    }
                    if (dc_ids.get(0).size() != 0) {
                        dc_string = formatstring(dc_ids.get(0).toString());
                    }
                    if (ac_ids.get(0).size() != 0) {
                        ac_string = formatstring(ac_ids.get(0).toString());
                    }
                    if (fc_ids.get(0).size() != 0) {
                        fc_string = formatstring(fc_ids.get(0).toString());
                    }
                    if (rb_ids.get(0).size() != 0) {
                        rb_string = formatstring(rb_ids.get(0).toString());
                    }
                    if (not_ids.get(0).size() != 0) {
                        not_string = formatstring(not_ids.get(0).toString());
                    }

                    if (noc_ids.get(0).size() != 0) {
                        noc_string = formatstring(noc_ids.get(0).toString());
                    }


                    if (rnot_ids.get(0).size() != 0) {
                        rnot_string = formatstring(rnot_ids.get(0).toString());
                    }
                    // Performing post request for actual data
                    Postpojo postpojo =
                            new Postpojo(
                                    admin_string,
                                    dc_string,
                                    deparments_string,
                                    faculties_string,
                                    menu_string,
                                    officers_string,
                                    office_string,
                                    residence_string,
                                    teachers_string,
                                    ac_string,
                                    fc_string,
                                    rb_string,
                                    not_string,
                                    noc_string,
                                    rnot_string
                            );
                    listener.onProgress(6, "Request sent");
                    Response<FetchObject> response = call.getupdate(postpojo).execute();


                    if (response.isSuccessful()) {
                        listener.onProgress(7, "Request successful");
                        FetchObject fetchObject = response.body();
                        if (fetchObject == null)
                            throw new NullPointerException(); // checking for empty body

                        listener.onProgress(8, "Populating database");
                        // Populating database with the received data
                        if (fetchObject.getMenu() != null && fetchObject.getMenu().size() != 0) {
                            for (Menus i : fetchObject.getMenu()) {
                                dbDao.addmenu(i);
                            }
                        }
                        if (fetchObject.getOffices() != null && fetchObject.getOffices().size() != 0) {
                            for (Offices i : fetchObject.getOffices()) {
                                dbDao.addoffice(i);
                            }
                        }
                        if (fetchObject.getOfficers() != null && fetchObject.getOfficers().size() != 0) {
                            for (Officers i : fetchObject.getOfficers()) {
                                dbDao.addofficers(i);
                            }
                        }
                        if (fetchObject.getTeachers() != null && fetchObject.getTeachers().size() != 0) {
                            for (Teachers i : fetchObject.getTeachers()) {
                                dbDao.addteacher(i);
                            }
                        }
                        if (fetchObject.getResidence() != null && fetchObject.getResidence().size() != 0) {
                            for (Residence i : fetchObject.getResidence()) {
                                dbDao.addresidence(i);
                            }
                        }
                        if (fetchObject.getAdmin() != null && fetchObject.getAdmin().size() != 0) {
                            for (Admin i : fetchObject.getAdmin()) {
                                dbDao.addadmin(i);
                            }
                        }
                        if (fetchObject.getDepartments() != null && fetchObject.getDepartments().size() != 0) {
                            for (Departments i : fetchObject.getDepartments()) {
                                dbDao.adddepartment(i);
                            }
                        }
                        if (fetchObject.getFaculties() != null && fetchObject.getFaculties().size() != 0) {
                            for (Faculties i : fetchObject.getFaculties()) {
                                dbDao.addfaculty(i);
                            }
                        }
                        if (fetchObject.getDc() != null && fetchObject.getDc().size() != 0) {
                            for (DeanChairman i : fetchObject.getDc()) {
                                dbDao.addDc(i);
                            }
                        }
                        if (fetchObject.getAc() != null && fetchObject.getAc().size() != 0) {
                            for (AcademicCouncil i : fetchObject.getAc()) {
                                dbDao.addAc(i);
                            }
                        }
                        if (fetchObject.getFc() != null && fetchObject.getFc().size() != 0) {
                            for (FinanceCommittee i : fetchObject.getFc()) {
                                dbDao.addFc(i);
                            }
                        }
                        if (fetchObject.getRb() != null && fetchObject.getRb().size() != 0) {
                            for (RegentBoard i : fetchObject.getRb()) {
                                dbDao.addRb(i);
                            }
                        }

                        if (fetchObject.getNot() != null && fetchObject.getNot().size() != 0) {
                            for (Notices i : fetchObject.getNot()) {
                                dbDao.addnot(i);
                            }
                        }
                        if (fetchObject.getNoc() != null && fetchObject.getNoc().size() != 0) {
                            for (Nocs i : fetchObject.getNoc()) {
                                dbDao.addnoc(i);
                            }
                        }
                        if (fetchObject.getRnot() != null && fetchObject.getRnot().size() != 0) {
                            for (ResultNotices i : fetchObject.getRnot()) {
                                dbDao.addrnot(i);
                            }
                        }
                        //Success
                        listener.onProgress(10, "Success");
                    } else {
                        //TODO response failed
                        throw new IOException();
                    }
                } else {
                    //TODO nothing to update, already synced
                    listener.onProgress(10, "Nothing to Sync");
                }
            } else {
                //TODO failed to check version with server
                listener.onError("Empty body from the server");
            }
        } catch (IOException e) {
            // IO exception in network sync
//            e.printStackTrace();
            System.err.println("Io exception in sync process");
            e.printStackTrace();
            listener.onError("IO exception in sync process");
        } catch (NullPointerException e) {
            // Empty body from the server;
            System.err.println("Empty body from the server");
            e.printStackTrace();
            listener.onError("Server Error(-13)");
        } catch (Exception e) {
            listener.onError("Server Error(404)");
            e.printStackTrace();
        }
    }

    private String formatstring(String str) {
        return str.substring(1, str.length() - 1).replaceAll("\\s+", "");
    }

    private List<List<Integer>> filterServerandlocal(@NonNull List<Info> list, @NonNull List<Info> list2) {
        @SuppressLint("UseSparseArrays")
        HashMap<Integer, String> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (Info info : list) {
            hashMap.put(info.getId(), info.getUpdated_at());
        }
        for (Info info2 : list2) {
            if (hashMap.containsKey(info2.getId())) {
                if (!(hashMap.get(info2.getId())).equals(info2.getUpdated_at())) {
                    arrayList.add(info2.getId());
                }
                hashMap.remove(info2.getId());
            } else {
                arrayList2.add(info2.getId());
            }
        }
        arrayList.addAll(hashMap.keySet());
        ArrayList<List<Integer>> arrayList3 = new ArrayList<>();
        arrayList3.add(arrayList);
        arrayList3.add(arrayList2);
        return arrayList3;
    }

    public void setListener(Onprogresslistener onprogresslistener) {
        this.listener = onprogresslistener;
    }

    public interface Onprogresslistener {
        void onProgress(int progress, String message);

        void onError(String err);

    }
}
