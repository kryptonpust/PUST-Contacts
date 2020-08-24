package pust.ice.krypton.pustcontacts.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "departments")
public class Departments {
    private String dept_code;
    private String dept_fname;
    @PrimaryKey
    private int dept_id;
    private String dept_sname;
    private String faculty_id;
    private String updated_at;

    public Departments(String dept_code, String dept_fname, int dept_id, String dept_sname, String faculty_id, String updated_at) {
        this.dept_code = dept_code;
        this.dept_fname = dept_fname;
        this.dept_id = dept_id;
        this.dept_sname = dept_sname;
        this.faculty_id = faculty_id;
        this.updated_at = updated_at;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDept_fname() {
        return dept_fname;
    }

    public void setDept_fname(String dept_fname) {
        this.dept_fname = dept_fname;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_sname() {
        return dept_sname;
    }

    public void setDept_sname(String dept_sname) {
        this.dept_sname = dept_sname;
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
