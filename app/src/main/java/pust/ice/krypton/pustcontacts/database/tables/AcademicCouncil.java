package pust.ice.krypton.pustcontacts.database.tables;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "academic_council")
public class AcademicCouncil {

    @PrimaryKey
    private int id;
    private String type;
    private String PUST_id;
    private String name;
    private String designation;
    private String department;
    private String university;
    private String order;
    private String mobile_1;
    private String office_phone;
    private String work_email;
    private String email;
    private String image;
    private String updated_at;

    public AcademicCouncil(int id, String type, String PUST_id, String name, String designation, String department, String university, String order, String mobile_1, String office_phone, String work_email, String email, String image, String updated_at) {
        this.id = id;
        this.type = type;
        this.PUST_id = PUST_id;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.university = university;
        this.order = order;
        this.mobile_1 = mobile_1;
        this.office_phone = office_phone;
        this.work_email = work_email;
        this.email = email;
        this.image = image;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPUST_id() {
        return PUST_id;
    }

    public void setPUST_id(String PUST_id) {
        this.PUST_id = PUST_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMobile_1() {
        return mobile_1;
    }

    public void setMobile_1(String mobile_1) {
        this.mobile_1 = mobile_1;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public String getWork_email() {
        return work_email;
    }

    public void setWork_email(String work_email) {
        this.work_email = work_email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
