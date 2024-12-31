package br.com.rhribeiro25.infrastructure.messaging.entities;

public class DepartmentMsgEntity {

    private String name;

    public DepartmentMsgEntity() {}

    private DepartmentMsgEntity(Builder builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Builder {

        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentMsgEntity build() {
            return new DepartmentMsgEntity(this);
        }
    }
}
