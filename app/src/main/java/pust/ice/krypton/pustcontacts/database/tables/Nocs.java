package pust.ice.krypton.pustcontacts.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "nocs")
public class Nocs {

    @PrimaryKey
    private int id;
    @NonNull
    private String name;
    private String designation;
    private String department;
    private String file;
    @ColumnInfo(name = "updated_at")
    private String updated_at;

    public Nocs(int id, @NonNull String name, String designation, String department, String file, String updated_at) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.department = department;
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
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
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
