package pust.ice.krypton.pustcontacts.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dean_chairmen")
public class DeanChairman {
    private String IP_phone;
    private String PABX_no;
    private String PUST_teacher_id;
    private String dept_code;
    private String designation;
    private String email;
    @PrimaryKey

    private int id;
    private String office_phone;
    private String type;
    private String updated_at;
    private String work_email;

    public DeanChairman(String IP_phone, String PABX_no, String PUST_teacher_id, String dept_code, String designation, String email, int id, String office_phone, String type, String updated_at, String work_email) {
        this.IP_phone = IP_phone;
        this.PABX_no = PABX_no;
        this.PUST_teacher_id = PUST_teacher_id;
        this.dept_code = dept_code;
        this.designation = designation;
        this.email = email;
        this.id = id;
        this.office_phone = office_phone;
        this.type = type;
        this.updated_at = updated_at;
        this.work_email = work_email;
    }

    public String getIP_phone() {
        return IP_phone;
    }

    public void setIP_phone(String IP_phone) {
        this.IP_phone = IP_phone;
    }

    public String getPABX_no() {
        return PABX_no;
    }

    public void setPABX_no(String PABX_no) {
        this.PABX_no = PABX_no;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getWork_email() {
        return work_email;
    }

    public void setWork_email(String work_email) {
        this.work_email = work_email;
    }
}
