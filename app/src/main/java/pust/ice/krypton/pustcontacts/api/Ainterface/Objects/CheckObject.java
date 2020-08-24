package pust.ice.krypton.pustcontacts.api.Ainterface.Objects;

import java.util.List;

import pust.ice.krypton.pustcontacts.database.tables.Publications;

public class CheckObject {
    private List<Info> avail_admin;
    private List<Info> avail_dc;
    private List<Info> avail_departments;
    private List<Info> avail_faculties;
    private List<Info> avail_menu;
    private List<Info> avail_officers;
    private List<Info> avail_offices;
    private List<Info> avail_residence;
    private List<Info> avail_teachers;
    private List<Info> avail_ac;
    private List<Info> avail_fc;
    private List<Info> avail_rb;
    private List<Publications> avail_profiles;
    private List<Info> avail_not;
    private List<Info> avail_noc;
    private List<Info> avail_rnot;

    public CheckObject(List<Info> avail_admin, List<Info> avail_dc, List<Info> avail_departments, List<Info> avail_faculties, List<Info> avail_menu, List<Info> avail_officers, List<Info> avail_offices, List<Info> avail_residence, List<Info> avail_teachers, List<Info> avail_ac, List<Info> avail_fc, List<Info> avail_rb, List<Publications> avail_profiles, List<Info> avail_not, List<Info> avail_noc, List<Info> avail_rnot) {
        this.avail_admin = avail_admin;
        this.avail_dc = avail_dc;
        this.avail_departments = avail_departments;
        this.avail_faculties = avail_faculties;
        this.avail_menu = avail_menu;
        this.avail_officers = avail_officers;
        this.avail_offices = avail_offices;
        this.avail_residence = avail_residence;
        this.avail_teachers = avail_teachers;
        this.avail_ac = avail_ac;
        this.avail_fc = avail_fc;
        this.avail_rb = avail_rb;
        this.avail_profiles = avail_profiles;
        this.avail_not = avail_not;
        this.avail_noc = avail_noc;
        this.avail_rnot = avail_rnot;
    }

    public List<Info> getAvail_admin() {
        return avail_admin;
    }

    public void setAvail_admin(List<Info> avail_admin) {
        this.avail_admin = avail_admin;
    }

    public List<Info> getAvail_dc() {
        return avail_dc;
    }

    public void setAvail_dc(List<Info> avail_dc) {
        this.avail_dc = avail_dc;
    }

    public List<Info> getAvail_departments() {
        return avail_departments;
    }

    public void setAvail_departments(List<Info> avail_departments) {
        this.avail_departments = avail_departments;
    }

    public List<Info> getAvail_faculties() {
        return avail_faculties;
    }

    public void setAvail_faculties(List<Info> avail_faculties) {
        this.avail_faculties = avail_faculties;
    }

    public List<Info> getAvail_menu() {
        return avail_menu;
    }

    public void setAvail_menu(List<Info> avail_menu) {
        this.avail_menu = avail_menu;
    }

    public List<Info> getAvail_officers() {
        return avail_officers;
    }

    public void setAvail_officers(List<Info> avail_officers) {
        this.avail_officers = avail_officers;
    }

    public List<Info> getAvail_offices() {
        return avail_offices;
    }

    public void setAvail_offices(List<Info> avail_offices) {
        this.avail_offices = avail_offices;
    }

    public List<Info> getAvail_residence() {
        return avail_residence;
    }

    public void setAvail_residence(List<Info> avail_residence) {
        this.avail_residence = avail_residence;
    }

    public List<Info> getAvail_teachers() {
        return avail_teachers;
    }

    public void setAvail_teachers(List<Info> avail_teachers) {
        this.avail_teachers = avail_teachers;
    }

    public List<Info> getAvail_ac() {
        return avail_ac;
    }

    public void setAvail_ac(List<Info> avail_ac) {
        this.avail_ac = avail_ac;
    }

    public List<Info> getAvail_fc() {
        return avail_fc;
    }

    public void setAvail_fc(List<Info> avail_fc) {
        this.avail_fc = avail_fc;
    }

    public List<Info> getAvail_rb() {
        return avail_rb;
    }

    public void setAvail_rb(List<Info> avail_rb) {
        this.avail_rb = avail_rb;
    }

    public List<Publications> getAvail_profiles() {
        return avail_profiles;
    }

    public void setAvail_profiles(List<Publications> avail_profiles) {
        this.avail_profiles = avail_profiles;
    }

    public List<Info> getAvail_not() {
        return avail_not;
    }

    public void setAvail_not(List<Info> avail_not) {
        this.avail_not = avail_not;
    }

    public List<Info> getAvail_noc() {
        return avail_noc;
    }

    public void setAvail_noc(List<Info> avail_noc) {
        this.avail_noc = avail_noc;
    }

    public List<Info> getAvail_rnot() {
        return avail_rnot;
    }

    public void setAvail_rnot(List<Info> avail_rnot) {
        this.avail_rnot = avail_rnot;
    }
}
