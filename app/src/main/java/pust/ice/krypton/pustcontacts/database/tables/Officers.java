package pust.ice.krypton.pustcontacts.database.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "officers")
public class Officers {
    private String IP_phone;
    private String PABX_no;
    private String PUST_officer_id;
    private String Research_Area;
    private String dept_code;
    private String designation;
    private String email;
    private String images;
    private String mobile_1;
    private String mobile_2;
    private String name;
    private String office_phone;
    @ColumnInfo(name = "officer_id")
    @PrimaryKey
    private int officer_id;
    private int officer_order;
    private String qualification;
    private String updated_at;
    private String work_email;

    private int dir=0;

    public Officers() {
        this.dir = 0;
    }

    public Officers(String IP_phone, String PABX_no, String PUST_officer_id, String Research_Area, String dept_code, String designation, String email, String images, String mobile_1, String mobile_2, String name, String office_phone, int officer_id, int officer_order, String qualification, String updated_at, String work_email) {
        this.IP_phone = IP_phone;
        this.PABX_no = PABX_no;
        this.PUST_officer_id = PUST_officer_id;
        this.Research_Area = Research_Area;
        this.dept_code = dept_code;
        this.designation = designation;
        this.email = email;
        this.images = images;
        this.mobile_1 = mobile_1;
        this.mobile_2 = mobile_2;
        this.name = name;
        this.office_phone = office_phone;
        this.officer_id = officer_id;
        this.officer_order = officer_order;
        this.qualification = qualification;
        this.updated_at = updated_at;
        this.work_email = work_email;
        this.dir = 0;
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

    public String getPUST_officer_id() {
        return PUST_officer_id;
    }

    public void setPUST_officer_id(String PUST_officer_id) {
        this.PUST_officer_id = PUST_officer_id;
    }

    public String getResearch_Area() {
        return Research_Area;
    }

    public void setResearch_Area(String research_Area) {
        Research_Area = research_Area;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getMobile_1() {
        return mobile_1;
    }

    public void setMobile_1(String mobile_1) {
        this.mobile_1 = mobile_1;
    }

    public String getMobile_2() {
        return mobile_2;
    }

    public void setMobile_2(String mobile_2) {
        this.mobile_2 = mobile_2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public int getOfficer_id() {
        return officer_id;
    }

    public void setOfficer_id(int officer_id) {
        this.officer_id = officer_id;
    }

    public int getOfficer_order() {
        return officer_order;
    }

    public void setOfficer_order(int officer_order) {
        this.officer_order = officer_order;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
