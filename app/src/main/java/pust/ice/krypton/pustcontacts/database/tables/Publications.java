package pust.ice.krypton.pustcontacts.database.tables;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "publications")
public class Publications {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String PUST_teacher_id;
    private String field;
    private int total;

    public Publications(int id, String PUST_teacher_id, String field, int total) {
        this.id = id;
        this.PUST_teacher_id = PUST_teacher_id;
        this.field = field;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPUST_teacher_id() {
        return PUST_teacher_id;
    }

    public void setPUST_teacher_id(String PUST_teacher_id) {
        this.PUST_teacher_id = PUST_teacher_id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
