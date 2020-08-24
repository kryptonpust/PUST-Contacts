package pust.ice.krypton.pustcontacts.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "faculties")
public class Faculties {
    private String dept_code;
    @PrimaryKey
    private int faculty_id;
    private String faculty_name;
    private String updated_at;

    public Faculties(String dept_code, int faculty_id, String faculty_name, String updated_at) {
        this.dept_code = dept_code;
        this.faculty_id = faculty_id;
        this.faculty_name = faculty_name;
        this.updated_at = updated_at;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
