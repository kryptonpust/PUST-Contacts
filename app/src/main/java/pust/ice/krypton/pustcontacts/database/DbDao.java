package pust.ice.krypton.pustcontacts.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import pust.ice.krypton.pustcontacts.api.Ainterface.Objects.Info;
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
import pust.ice.krypton.pustcontacts.database.tables.Publications;
import pust.ice.krypton.pustcontacts.database.tables.RegentBoard;
import pust.ice.krypton.pustcontacts.database.tables.Residence;
import pust.ice.krypton.pustcontacts.database.tables.ResultNotices;
import pust.ice.krypton.pustcontacts.database.tables.Teachers;
import pust.ice.krypton.pustcontacts.pojo.OfficerPojo;

@Dao
public interface DbDao {

    //add
    @Insert(onConflict = 1)
    void addDc(DeanChairman deanChairman);

    @Insert(onConflict = 1)
    void addadmin(Admin admin);

    @Insert(onConflict = 1)
    void adddepartment(Departments departments);

    @Insert(onConflict = 1)
    void addfaculty(Faculties faculties);

    @Insert(onConflict = 1)
    void addmenu(Menus menus);

    @Insert(onConflict = 1)
    void addoffice(Offices offices);

    @Insert(onConflict = 1)
    void addofficers(Officers officers);

    @Insert(onConflict = 1)
    void addresidence(Residence residence);

    @Insert(onConflict = 1)
    void addteacher(Teachers teachers);

    @Insert(onConflict = 1)
    void addAc(AcademicCouncil i);

    @Insert(onConflict = 1)
    void addFc(FinanceCommittee i);

    @Insert(onConflict = 1)
    void addRb(RegentBoard i);

    @Insert(onConflict = 1)
    void addPublication(Publications p);

    @Insert(onConflict = 1)
    void addnot(Notices i);

    @Insert(onConflict = 1)
    void addnoc(Nocs i);

    @Insert(onConflict = 1)
    void addrnot(ResultNotices i);


    //delete

    @Query("DELETE FROM admin WHERE `id`=:i")
    void deleteadminbyid(Integer i);

    @Query("DELETE FROM dean_chairmen WHERE `id`=:i")
    void deletedcbyid(Integer i);

    @Query("DELETE FROM departments WHERE `dept_id`=:i")
    void deletedepartmentbyid(Integer i);

    @Query("DELETE FROM faculties WHERE `faculty_id`=:i")
    void deletefacultybyid(Integer i);

    @Query("DELETE FROM menus WHERE `menu_id`=:i")
    void deletemenubyid(Integer i);

    @Query("DELETE FROM offices WHERE `office_id`=:i")
    void deleteofficebyid(Integer i);

    @Query("DELETE FROM officers WHERE `officer_id`=:i")
    void deleteofficerbyid(Integer i);

    @Query("DELETE FROM residence WHERE `res_id`=:i")
    void deleteresidencebyid(Integer i);

    @Query("DELETE FROM teachers WHERE `teacher_id`=:i")
    void deleteteacherbyid(Integer i);

    @Query("DELETE FROM academic_council WHERE `id`=:i")
    void deleteacbyid(Integer i);

    @Query("DELETE FROM finance_committe WHERE `id`=:i")
    void deletefcbyid(Integer i);

    @Query("DELETE FROM regent_board WHERE `id`=:i")
    void deleteRbbyid(Integer i);

    @Query("DELETE FROM publications")
    void deleteAllPublications();

    @Query("DELETE FROM notices WHERE `notice_id`=:i")
    void deletenotbyid(Integer i);

    @Query("DELETE FROM nocs WHERE `id`=:i")
    void deletenocbyid(Integer i);

    @Query("DELETE FROM resultnotices WHERE `id`=:i")
    void deleternotbyid(Integer i);

    //get local
    @Query("SELECT `id`,`updated_at` from admin")
    List<Info> getlocaladmin();

    @Query("SELECT `id`,`updated_at` from dean_chairmen")
    List<Info> getlocaldc();

    @Query("SELECT `dept_id` as `id`,`updated_at` from departments")
    List<Info> getlocaldepartments();

    @Query("SELECT `faculty_id` as `id`,`updated_at` from faculties")
    List<Info> getlocalfaculties();

    @Query("SELECT `menu_id` as `id`,`updated_at` from menus")
    List<Info> getlocalmenu();

    @Query("SELECT `officer_id` as `id`,`updated_at` from officers")
    List<Info> getlocalofficers();

    @Query("SELECT `office_id` as `id`,`updated_at` from offices")
    List<Info> getlocaloffices();

    @Query("SELECT `res_id` as `id`,`updated_at` from residence")
    List<Info> getlocalresidence();

    @Query("SELECT `teacher_id` as `id`,`updated_at` from teachers")
    List<Info> getlocalteachers();

    @Query("SELECT `id`,`updated_at` from academic_council")
    List<Info> getlocalac();

    @Query("SELECT `id`,`updated_at` from finance_committe")
    List<Info> getlocalfc();

    @Query("SELECT `id`,`updated_at` FROM regent_board")
    List<Info> getlocalrb();

    @Query("SELECT notice_id as id,updated_at FROM notices")
    List<Info> getlocalnot();

    @Query("SELECT id,updated_at FROM nocs")
    List<Info> getlocalnoc();

    @Query("SELECT id,updated_at FROM resultnotices")
    List<Info> getlocalrnot();

    @Query("SELECT * FROM menus")
    LiveData<List<Menus>> getmenus();

    @Query("SELECT * FROM offices")
    LiveData<List<Offices>> getoffices();


    @Query("SELECT * FROM publications WHERE PUST_teacher_id=:id")
    LiveData<List<Publications>> getpublication(String id);

    //query

    @Query("SELECT * FROM departments WHERE faculty_id=:id ORDER BY dept_code ASC")
    LiveData<List<Departments>> getDepartment_by_faculty_id(int id);

    @Query("SELECT * FROM faculties")
    LiveData<List<Faculties>> getFaculties();


    @Query("SELECT ('Department of ' ||departments.dept_fname) as faculty,teacher_id as id,designation,teacher_order as `order`,name,`PUST_teacher_id` as user_id,'pust' as university,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir FROM `teachers`\n" +
            "inner join departments on departments.dept_code=teachers.dept_code WHERE teachers.dept_code=:code ORDER BY teacher_order ASC")
    LiveData<List<OfficerPojo>> getDeptTeacher(String code);

    @Query("select bar.* from (SELECT ('Faculty of ' || faculties.faculty_name) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen \n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN faculties ON faculties.dept_code=dean_chairmen.dept_code where dean_chairmen.type='Chairman' ORDER BY dean_chairmen.dept_code) as bar\n" +
            "union all\n" +
            "select foo.* from (SELECT ('Department of ' ||departments.dept_fname) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen\n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN departments ON departments.dept_code=dean_chairmen.dept_code where dean_chairmen.type='Chairman' ORDER BY dean_chairmen.dept_code) as foo")
    LiveData<List<OfficerPojo>> getAllChairman();

    @Query("select bar.* from (SELECT ('Faculty of ' || faculties.faculty_name) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen \n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN faculties ON faculties.dept_code=dean_chairmen.dept_code where dean_chairmen.type='Dean' ORDER BY dean_chairmen.dept_code) as bar\n" +
            "union all\n" +
            "select foo.* from (SELECT ('Department of ' ||departments.dept_fname) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen\n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN departments ON departments.dept_code=dean_chairmen.dept_code where dean_chairmen.type='Dean' ORDER BY dean_chairmen.dept_code) as foo\n")
    LiveData<List<OfficerPojo>> getAllDean();


    @Query("SELECT ('Faculty of ' || faculties.faculty_name) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen\n" +
            "            INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "            INNER JOIN faculties ON faculties.dept_code=dean_chairmen.dept_code WHERE faculties.dept_code=:code")
    LiveData<List<OfficerPojo>> getFacultyByCode(String code);

    @Query("SELECT ('Department of ' ||departments.dept_fname) as faculty,officer_id as id,designation,officer_order as `order`,name,`officer_id` as user_id,'pust' as university,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir FROM officers\n" +
            "INNER join departments ON departments.dept_code=officers.dept_code WHERE officers.dept_code=:s ORDER BY officers.officer_order ASC")
    LiveData<List<OfficerPojo>> getDeptOfficers(String s);

    @Query("SELECT offices.office_name as faculty,officer_id as id,designation,officer_order as `order`,name,`officer_id` as user_id,'pust' as university,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir FROM officers\n" +
            "INNER join offices ON offices.dept_code=officers.dept_code WHERE officers.dept_code=:s ORDER BY officers.officer_order ASC")
    LiveData<List<OfficerPojo>> getOfficeOfficers(String s);

    @Query("SELECT offices.office_name as faculty,teacher_id as id,admin.designation,admin.`order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,teachers.office_phone,teachers.IP_phone,teachers.PABX_no,teachers.email,teachers.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM admin \n" +
            "INNER JOIN `teachers` ON teachers.PUST_teacher_id=admin.PUST_teacher_id \n" +
            "INNER JOIN offices ON offices.dept_code=admin.dept_code WHERE admin.dept_code=:s ORDER BY `order` ASC ")
    LiveData<List<OfficerPojo>> getOfficeteachers(String s);

    @Query("SELECT offices.office_name as faculty,teacher_id as id,position as designation,`order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,teachers.office_phone,teachers.IP_phone,teachers.PABX_no,teachers.email,teachers.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM residence \n" +
            "INNER JOIN `teachers` ON teachers.PUST_teacher_id=residence.PUST_teacher_id \n" +
            "INNER JOIN offices ON offices.dept_code=residence.hallName WHERE residence.hallName=:s ORDER BY `order` ASC ")
    LiveData<List<OfficerPojo>> getResidenceTeachers(String s);


    //searching query
    @Query("SELECT * FROM ( SELECT offices.office_name as faculty,teacher_id as id,admin.designation,admin.`order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,teachers.office_phone,teachers.IP_phone,teachers.PABX_no,teachers.email,teachers.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM admin \n" +
            "INNER JOIN `teachers` ON teachers.PUST_teacher_id=admin.PUST_teacher_id\n" +
            "INNER JOIN offices ON offices.dept_code=admin.dept_code\n" +
            "UNION ALL\n" +
            "SELECT offices.office_name as faculty,officer_id as id,designation,officer_order as `order`,name,`officer_id` as user_id,'pust' as university,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir FROM officers\n" +
            "INNER JOIN offices ON offices.dept_code=officers.dept_code\n" +
            "UNION ALL\n" +
            "SELECT offices.office_name as faculty,teacher_id as id,position as designation,`order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,teachers.office_phone,teachers.IP_phone,teachers.PABX_no,teachers.email,teachers.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM residence \n" +
            "INNER JOIN `teachers` ON teachers.PUST_teacher_id=residence.PUST_teacher_id\n" +
            "INNER JOIN offices ON offices.dept_code=residence.hallName\n" +
            "UNION ALL\n" +
            "SELECT ('Department of ' ||departments.dept_fname) as faculty,teacher_id as id,designation,teacher_order as `order`,name,teachers.PUST_teacher_id as user_id,'pust' as university,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir FROM teachers\n" +
            "INNER JOIN departments ON departments.dept_code=teachers.dept_code\n" +
            "UNION ALL\n" +
            "select bar.* from (SELECT ('Faculty of ' || faculties.faculty_name) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen \n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN faculties ON faculties.dept_code=dean_chairmen.dept_code where dean_chairmen.type='Dean' ORDER BY dean_chairmen.dept_code) as bar\n" +
            "union all\n" +
            "select foo.* from (SELECT ('Department of ' ||departments.dept_fname) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen\n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN departments ON departments.dept_code=dean_chairmen.dept_code where dean_chairmen.type='Dean' ORDER BY dean_chairmen.dept_code) as foo\n" +
            "UNION ALL\n" +
            "select bar1.* from (SELECT ('Faculty of ' || faculties.faculty_name) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen \n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN faculties ON faculties.dept_code=dean_chairmen.dept_code where dean_chairmen.type='Chairman' ORDER BY dean_chairmen.dept_code) as bar1\n" +
            "union all\n" +
            "select foo1.* from (SELECT ('Department of ' ||departments.dept_fname) as faculty,teacher_id as id,dean_chairmen.designation,teachers.teacher_order as `order`,teachers.name,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen\n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN departments ON departments.dept_code=dean_chairmen.dept_code where dean_chairmen.type='Chairman' ORDER BY dean_chairmen.dept_code) as foo1) foo ORDER BY `name` ASC ")
    LiveData<List<OfficerPojo>> search();


    @Query("select data1.* from (SELECT 'Pabna University of Science and Technology,Pabna' as faculty,officer_id as id,designation,null as user_id,'pust' as university,officer_order as `order`,name,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir from officers where dept_code='O01' and officer_order=0 order by `order`) as data1\n" +
            "union all\n" +
            "select data2.* from (SELECT 'Pabna University of Science and Technology,Pabna' as faculty,officer_id as id,designation,null as user_id,'pust' as university,officer_order as `order`,name,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir from officers where dept_code='O02' and officer_order=0 order by `order`) as data2\n" +
            "union all\n" +
            "select data3.* from (select department as faculty,id,designation,null as user_id,university,`order`,name,null as qualification,mobile_1,null as mobile_2,office_phone,null as IP_phone,null as PABX_no,work_email,email,null as Research_Area,image as images,'2' as dir from academic_council where type='Chancellor' order by `order`) as data3\n" +
            "union all\n" +
            "select data4.* from (SELECT ('Faculty of ' || faculties.faculty_name) as faculty,teacher_id as id,dean_chairmen.designation,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.teacher_order as `order`,teachers.name,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen \n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN faculties ON faculties.dept_code=dean_chairmen.dept_code order by `order`) as data4\n" +
            "UNION ALL \n" +
            "select data5.* from (SELECT ('Department of ' ||departments.dept_fname) as faculty,teacher_id as id,dean_chairmen.designation,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.teacher_order as `order`,teachers.name,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen \n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN departments ON departments.dept_code=dean_chairmen.dept_code order by `order`) as data5\n" +
            "union all\n" +
            "select data6.* from (SELECT ('Department of ' || departments.dept_fname) as faculty,teacher_id as id,teachers.designation,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.teacher_order as `order`,teachers.name,teachers.qualification,teachers.mobile_1,teachers.mobile_2,teachers.office_phone,teachers.IP_phone,teachers.PABX_no,teachers.email,teachers.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM teachers \n" +
            "INNER JOIN departments ON departments.dept_code=teachers.dept_code\n" +
            "INNER JOIN academic_council ON academic_council.PUST_id=teachers.PUST_teacher_id order by `order`) as data6")
    LiveData<List<OfficerPojo>> getaclist();

    @Query("select data1.* from (SELECT 'Pabna University of Science and Technology,Pabna' as faculty,officer_id as id,designation,null as user_id,'pust' as university,officer_order as `order`,name,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir from officers where dept_code='O01' and officer_order=0 order by `order`) as data1\n" +
            "union all\n" +
            "select data2.* from (SELECT 'Pabna University of Science and Technology,Pabna' as faculty,officer_id as id,designation,null as user_id,'pust' as university,officer_order as `order`,name,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir from officers where dept_code='O02' and officer_order=0 order by `order`) as data2\n" +
            "union all\n" +
            "select data3.* from (SELECT 'Pabna University of Science and Technology,Pabna' as faculty,officer_id as id,designation,null as user_id,'pust' as university,officer_order as `order`,name,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir from officers where dept_code='O03' and officer_order=0 order by `order`) as data3\n" +
            "union all\n" +
            "select data4.* from (SELECT 'Pabna University of Science and Technology,Pabna' as faculty,officer_id as id,designation,null as user_id,'pust' as university,officer_order as `order`,name,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir from officers where dept_code='O04' and officer_order=0 order by `order`) as data4\n" +
            "union all\n" +
            "select data6.* from (select department as faculty,id,designation,null as user_id,university,`order`,name,null as qualification,mobile_1,null as mobile_2,office_phone,null as IP_phone,null as PABX_no,work_email,email,null as Research_Area,image as images,'2' as dir from finance_committe where type='Others' order by `order`) as data6\n" +
            "union all\n" +
            "select data5.* from (SELECT ('Department of ' || departments.dept_fname) as faculty,teacher_id as id,teachers.designation,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.teacher_order as `order`,teachers.name,teachers.qualification,teachers.mobile_1,teachers.mobile_2,teachers.office_phone,teachers.IP_phone,teachers.PABX_no,teachers.email,teachers.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM teachers \n" +
            "INNER JOIN departments ON departments.dept_code=teachers.dept_code\n" +
            "INNER JOIN finance_committe ON finance_committe.PUST_id=teachers.PUST_teacher_id order by `order`) as data5\n")
    LiveData<List<OfficerPojo>> getfclist();


    @Query("select data1.* from (SELECT 'Pabna University of Science and Technology,Pabna' as faculty,officer_id as id,designation,null as user_id,'pust' as university,officer_order as `order`,name,qualification,mobile_1,mobile_2,office_phone,IP_phone,PABX_no,email,work_email,Research_Area,images,dir from officers where dept_code='O01' and officer_order=0 order by `order`) as data1\n" +
            "union all\n" +
            "select data2.* from (SELECT ('Faculty of ' || faculties.faculty_name) as faculty,teacher_id as id,dean_chairmen.designation,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.teacher_order as `order`,teachers.name,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir \n" +
            "FROM dean_chairmen \n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN faculties ON faculties.dept_code=dean_chairmen.dept_code\n" +
            "INNER JOIN regent_board ON regent_board.PUST_id=dean_chairmen.PUST_teacher_id where regent_board.type='DC' order by `order`) as data2\n" +
            "UNION ALL\n" +
            "select data3.* from (SELECT ('Department of ' ||departments.dept_fname) as faculty,teacher_id as id,dean_chairmen.designation,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.teacher_order as `order`,teachers.name,teachers.qualification,teachers.mobile_1,teachers.mobile_2,dean_chairmen.office_phone,dean_chairmen.IP_phone,dean_chairmen.PABX_no,teachers.email,dean_chairmen.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM dean_chairmen\n" +
            "INNER JOIN teachers ON teachers.PUST_teacher_id=dean_chairmen.PUST_teacher_id\n" +
            "INNER JOIN departments ON departments.dept_code=dean_chairmen.dept_code \n" +
            "INNER JOIN regent_board ON regent_board.PUST_id=dean_chairmen.PUST_teacher_id where regent_board.type='DC' order by `order`) as data3\n" +
            "union all\n" +
            "select data4.* from (SELECT ('Department of ' || departments.dept_fname) as faculty,teacher_id as id,teachers.designation,teachers.PUST_teacher_id as user_id,'pust' as university,teachers.teacher_order as `order`,teachers.name,teachers.qualification,teachers.mobile_1,teachers.mobile_2,teachers.office_phone,teachers.IP_phone,teachers.PABX_no,teachers.email,teachers.work_email,teachers.Research_Area,teachers.images,teachers.dir FROM teachers \n" +
            "INNER JOIN departments ON departments.dept_code=teachers.dept_code\n" +
            "INNER JOIN regent_board ON regent_board.PUST_id=teachers.PUST_teacher_id where regent_board.type='Teacher' order by `order`) data4\n" +
            "union all\n" +
            "select data5.* from (SELECT offices.office_name as faculty,officer_id as id,officers.designation,officers.PUST_officer_id as user_id,'pust' as university,officers.officer_order as `order`,officers.name,officers.qualification,officers.mobile_1,officers.mobile_2,officers.office_phone,officers.IP_phone,officers.PABX_no,officers.email,officers.work_email,officers.Research_Area,officers.images,dir FROM officers\n" +
            "INNER join offices ON offices.dept_code=officers.dept_code\n" +
            "inner join regent_board ON regent_board.PUST_id=officers.PUST_officer_id where regent_board.type='Officer' order by `order`) data5\n" +
            "union all\n" +
            "select data6.* from (select department as faculty,id,designation,null as user_id,university,`order`,name,null as qualification,mobile_1,null as mobile_2,office_phone,null as IP_phone,null as PABX_no,work_email,email,null as Research_Area,image as images,'2' as dir from regent_board where type='Others' order by `order`) as data6\n" +
            "\n" +
            "\n")
    LiveData<List<OfficerPojo>> getrblist();

    @Query("SELECT * from teachers WHERE PUST_teacher_id=:query")
    LiveData<Teachers> getdetails(String query);


    @Query("SELECT * from notices WHERE type like :filter ORDER BY notice_id DESC")
    LiveData<List<Notices>> getAllNotices(String filter);

    @Query("SELECT * from nocs ORDER BY id DESC")
    LiveData<List<Nocs>> getAllNocs();

    @Query("SELECT * from resultnotices ORDER BY id DESC")
    LiveData<List<ResultNotices>> getAllResultNotices();

}
