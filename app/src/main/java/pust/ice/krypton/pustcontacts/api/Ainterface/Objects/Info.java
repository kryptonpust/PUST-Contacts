package pust.ice.krypton.pustcontacts.api.Ainterface.Objects;

public class Info {

    private int id;
    private String updated_at;

    public Info(int id, String updated_at) {
        this.id = id;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public class ProfileInfo{
        private String PUST_teacher_id;
        private String field;
        private int total;

        public ProfileInfo(String PUST_teacher_id, String field, int total) {
            this.PUST_teacher_id = PUST_teacher_id;
            this.field = field;
            this.total = total;
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
}
