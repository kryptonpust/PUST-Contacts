package pust.ice.krypton.pustcontacts.database.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "offices")
public class Offices {
    @ColumnInfo(name = "dept_code")
    private String dept_code;
    @ColumnInfo(name = "office_id")
    @PrimaryKey
    private int office_id;
    @ColumnInfo(name = "office_name")
    private String office_name;
    @ColumnInfo(name = "updated_at")
    private String updated_at;

    public Offices(String dept_code, int office_id, String office_name, String updated_at) {
        this.dept_code = dept_code;
        this.office_id = office_id;
        this.office_name = office_name;
        this.updated_at = updated_at;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public int getOffice_id() {
        return office_id;
    }

    public void setOffice_id(int office_id) {
        this.office_id = office_id;
    }

    public String getOffice_name() {
        return office_name;
    }

    public void setOffice_name(String office_name) {
        this.office_name = office_name;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
