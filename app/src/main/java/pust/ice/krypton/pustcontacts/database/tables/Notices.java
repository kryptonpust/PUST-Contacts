package pust.ice.krypton.pustcontacts.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "notices")
public class Notices {
    @PrimaryKey
    private int notice_id;
    @NonNull
    private String title;
    private String dept_code;
    private String link;
    private String expired;
    private String type;
    private String file;
    @ColumnInfo(name = "updated_at")
    private String updated_at;

    public Notices(int notice_id, @NonNull String title, String dept_code, String link, String expired, String type, String file, String updated_at) {
        this.notice_id = notice_id;
        this.title = title;
        this.dept_code = dept_code;
        this.link = link;
        this.expired = expired;
        this.type = type;
        this.file = file;
        this.updated_at = updated_at;
    }


    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
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
