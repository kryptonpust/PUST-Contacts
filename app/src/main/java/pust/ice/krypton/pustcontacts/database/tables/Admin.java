package pust.ice.krypton.pustcontacts.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "admin")
public class Admin {
    private String PUST_teacher_id;
    private String dept_code;
    private String designation;
    @PrimaryKey

    private int id;
    private int order;
    private String updated_at;

    public Admin(String PUST_teacher_id, String dept_code, String designation, int id, int order, String updated_at) {
        this.PUST_teacher_id = PUST_teacher_id;
        this.dept_code = dept_code;
        this.designation = designation;
        this.id = id;
        this.order = order;
        this.updated_at = updated_at;
    }

    public String getPUST_teacher_id() {
        return PUST_teacher_id;
    }

    public void setPUST_teacher_id(String PUST_teacher_id) {
        this.PUST_teacher_id = PUST_teacher_id;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
