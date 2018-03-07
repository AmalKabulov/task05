package by.epam.parser.entity;

public abstract class BaseEntity {

    private String id;

    public BaseEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //TODO equals and hashcode for abstract class??
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BaseEntity that = (BaseEntity) o;
//        return Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id);
//    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }

}



