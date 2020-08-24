package pust.ice.krypton.pustcontacts.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menus")
public class Menus {
    @ColumnInfo(name = "menu_id")
    @PrimaryKey
    private int menu_id;
    @ColumnInfo(name = "menu_title")
    @NonNull
    private String menu_title;
    @ColumnInfo(name = "updated_at")
    private String updated_at;


    public Menus(int menu_id, @NonNull String menu_title, String updated_at) {
        this.menu_id = menu_id;
        this.menu_title = menu_title;
        this.updated_at = updated_at;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    @NonNull
    public String getMenu_title() {
        return menu_title;
    }

    public void setMenu_title(@NonNull String menu_title) {
        this.menu_title = menu_title;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
