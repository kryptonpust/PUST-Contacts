package pust.ice.krypton.pustcontacts.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "resultnotices")
public class ResultNotices {

    @PrimaryKey
    private int id;
    @NonNull
    private String title;
    private String dept_code;
    private String semester;
    private String session;
    private String published_date;
    private String type;
    private String file;
    @ColumnInfo(name = "updated_at")
    private String updated_at;

    public ResultNotices(int id, @NonNull String title, String dept_code, String semester, String session, String published_date, String type, String file, String updated_at) {
        this.id = id;
        this.title = title;
        this.dept_code = dept_code;
        this.semester = semester;
        this.session = session;
        this.published_date = published_date;
        this.type = type;
        this.file = file;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
