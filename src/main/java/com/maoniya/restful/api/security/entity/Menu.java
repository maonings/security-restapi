package com.maoniya.restful.api.security.entity;

import java.io.Serializable;

public class Menu implements Serializable {

  private Integer id;
  private String name;
  private String icon;
  private String url;
  private Integer pid;
  private Integer sort;
  private Boolean islink;
  private String description;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public Boolean getIslink() {
    return islink;
  }

  public void setIslink(Boolean islink) {
    this.islink = islink;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Menu{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", icon='" + icon + '\'' +
            ", url='" + url + '\'' +
            ", pid=" + pid +
            ", sort=" + sort +
            ", islink=" + islink +
            ", description='" + description + '\'' +
            '}';
  }
}
