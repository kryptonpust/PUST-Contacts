package pust.ice.krypton.pustcontacts.api.Ainterface.Objects;

import java.util.List;

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
import pust.ice.krypton.pustcontacts.database.tables.RegentBoard;
import pust.ice.krypton.pustcontacts.database.tables.Residence;
import pust.ice.krypton.pustcontacts.database.tables.ResultNotices;
import pust.ice.krypton.pustcontacts.database.tables.Teachers;

public class FetchObject {
    private List<Admin> admin;
    private List<DeanChairman> dc;
    private List<Departments> departments;
    private List<Faculties> faculties;
    private List<Menus> menu;
    private List<Officers> officers;
    private List<Offices> offices;
    private List<Residence> residence;
    private List<Teachers> teachers;
    private List<AcademicCouncil> ac;
    private List<FinanceCommittee> fc;
    private List<RegentBoard> rb;
    private List<Notices> not;
    private List<Nocs> noc;
    private List<ResultNotices> rnot;

    public FetchObject(List<Admin> admin, List<DeanChairman> dc, List<Departments> departments, List<Faculties> faculties, List<Menus> menu, List<Officers> officers, List<Offices> offices, List<Residence> residence, List<Teachers> teachers, List<AcademicCouncil> ac, List<FinanceCommittee> fc, List<RegentBoard> rb, List<Notices> not, List<Nocs> noc, List<ResultNotices> rnot) {
        this.admin = admin;
        this.dc = dc;
        this.departments = departments;
        this.faculties = faculties;
        this.menu = menu;
        this.officers = officers;
        this.offices = offices;
        this.residence = residence;
        this.teachers = teachers;
        this.ac = ac;
        this.fc = fc;
        this.rb = rb;
        this.not = not;
        this.noc = noc;
        this.rnot = rnot;
    }

    public List<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(List<Admin> admin) {
        this.admin = admin;
    }

    public List<DeanChairman> getDc() {
        return dc;
    }

    public void setDc(List<DeanChairman> dc) {
        this.dc = dc;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }

    public List<Faculties> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculties> faculties) {
        this.faculties = faculties;
    }

    public List<Menus> getMenu() {
        return menu;
    }

    public void setMenu(List<Menus> menu) {
        this.menu = menu;
    }

    public List<Officers> getOfficers() {
        return officers;
    }

    public void setOfficers(List<Officers> officers) {
        this.officers = officers;
    }

    public List<Offices> getOffices() {
        return offices;
    }

    public void setOffices(List<Offices> offices) {
        this.offices = offices;
    }

    public List<Residence> getResidence() {
        return residence;
    }

    public void setResidence(List<Residence> residence) {
        this.residence = residence;
    }

    public List<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
    }

    public List<AcademicCouncil> getAc() {
        return ac;
    }

    public void setAc(List<AcademicCouncil> ac) {
        this.ac = ac;
    }

    public List<FinanceCommittee> getFc() {
        return fc;
    }

    public void setFc(List<FinanceCommittee> fc) {
        this.fc = fc;
    }

    public List<RegentBoard> getRb() {
        return rb;
    }

    public void setRb(List<RegentBoard> rb) {
        this.rb = rb;
    }

    public List<Notices> getNot() {
        return not;
    }

    public void setNot(List<Notices> not) {
        this.not = not;
    }

    public List<Nocs> getNoc() {
        return noc;
    }

    public void setNoc(List<Nocs> noc) {
        this.noc = noc;
    }

    public List<ResultNotices> getRnot() {
        return rnot;
    }

    public void setRnot(List<ResultNotices> rnot) {
        this.rnot = rnot;
    }
}
