package ru.rsatu.pojo;

import javax.persistence.*;

@Entity // для связи класса с БД
@Table(name = "tabl_group")
public class Group {

    @Id
    Long id;
    private String namegroup;

    public Long getId() {
        return id;
    }

    public String getNamegroup() {
        return namegroup;
    }

    public void setNamegroup(String namegroup) {
        this.namegroup = namegroup;
    }

    public Group() {
    }
}
