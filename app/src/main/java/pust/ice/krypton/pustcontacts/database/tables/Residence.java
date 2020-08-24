package pust.ice.krypton.pustcontacts.database.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "residence")
public class Residence {
    private String PUST_teacher_id;
    private String hallName;
    private int order;
    private String position;
    @ColumnInfo(name = "res_id")
    @PrimaryKey
    private int res_id;
    private String updated_at;

    public Residence(String PUST_teacher_id, String hallName, int order, String position, int res_id, String updated_at) {
        this.PUST_teacher_id = PUST_teacher_id;
        this.hallName = hallName;
        this.order = order;
        this.position = position;
        this.res_id = res_id;
        this.updated_at = updated_at;
    }

    public String getPUST_teacher_id() {
        return PUST_teacher_id;
    }

    public void setPUST_teacher_id(String PUST_teacher_id) {
        this.PUST_teacher_id = PUST_teacher_id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
