package pust.ice.krypton.pustcontacts.pojo;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class OfficerPojo implements Serializable {
    @Nullable
    private Integer id;
    private String IP_phone;
    private String PABX_no;
    private String Research_Area;
    private String designation;
    private String email;
    @Nullable
    private String faculty;
    private String images;
    private String mobile_1;
    private String mobile_2;
    private String name;
    private String office_phone;
    private String order;
    private String qualification;
    private String work_email;
    private Integer dir;
    private String user_id;
    private String university;

    public OfficerPojo(@Nullable Integer id,String IP_phone, String PABX_no, String Research_Area, String designation, String email, @Nullable String faculty, String images, String mobile_1, String mobile_2, String name, String office_phone, String order, String qualification, String work_email, Integer dir, String user_id, String university) {
        this.id=id;
        this.IP_phone = IP_phone;
        this.PABX_no = PABX_no;
        this.Research_Area = Research_Area;
        this.designation = designation;
        this.email = email;
        this.faculty = faculty;
        this.images = images;
        this.mobile_1 = mobile_1;
        this.mobile_2 = mobile_2;
        this.name = name;
        this.office_phone = office_phone;
        this.order = order;
        this.qualification = qualification;
        this.work_email = work_email;
        this.dir = dir;
        this.user_id = user_id;
        this.university = university;


    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getResearch_Area() {
        return Research_Area;
    }

    public void setResearch_Area(String research_Area) {
        Research_Area = research_Area;
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

    @Nullable
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(@Nullable String faculty) {
        this.faculty = faculty;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getWork_email() {
        return work_email;
    }

    public void setWork_email(String work_email) {
        this.work_email = work_email;
    }

    public Integer getDir() {
        return dir;
    }

    public void setDir(Integer dir) {
        this.dir = dir;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
