package pust.ice.krypton.pustcontacts.database.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teachers")
public class Teachers {
    private String IP_phone;
    private String PABX_no;
    private String PUST_teacher_id;
    private String Research_Area;
    private String dept_code;
    private String designation;
    private String email;
    private String images;
    private String mobile_1;
    private String mobile_2;
    private String name;
    private String office_phone;
    private String qualification;
    @ColumnInfo(name = "teacher_id")
    @PrimaryKey
    private int teacher_id;
    private int teacher_order;
    private String updated_at;
    private String work_email;
    private String website;
    private String facebook;
    private String twitter;
    private String linkedin;
    private String skype;
    private String researchgate;
    private String gscholar;
    private String orcid;


    private int dir=1;

    public Teachers() {
        this.dir = 1;
    }


    public Teachers(String IP_phone, String PABX_no, String PUST_teacher_id, String Research_Area, String dept_code, String designation, String email, String images, String mobile_1, String mobile_2, String name, String office_phone, String qualification, int teacher_id, int teacher_order, String updated_at, String work_email, String website, String facebook, String twitter, String linkedin, String skype, String researchgate, String gscholar, String orcid, Integer dir) {
        this.IP_phone = IP_phone;
        this.PABX_no = PABX_no;
        this.PUST_teacher_id = PUST_teacher_id;
        this.Research_Area = Research_Area;
        this.dept_code = dept_code;
        this.designation = designation;
        this.email = email;
        this.images = images;
        this.mobile_1 = mobile_1;
        this.mobile_2 = mobile_2;
        this.name = name;
        this.office_phone = office_phone;
        this.qualification = qualification;
        this.teacher_id = teacher_id;
        this.teacher_order = teacher_order;
        this.updated_at = updated_at;
        this.work_email = work_email;
        this.website = website;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedin = linkedin;
        this.skype = skype;
        this.researchgate = researchgate;
        this.gscholar = gscholar;
        this.orcid = orcid;
        this.dir = 1;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getTeacher_order() {
        return teacher_order;
    }

    public void setTeacher_order(int teacher_order) {
        this.teacher_order = teacher_order;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getResearchgate() {
        return researchgate;
    }

    public void setResearchgate(String researchgate) {
        this.researchgate = researchgate;
    }

    public String getGscholar() {
        return gscholar;
    }

    public void setGscholar(String gscholar) {
        this.gscholar = gscholar;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
