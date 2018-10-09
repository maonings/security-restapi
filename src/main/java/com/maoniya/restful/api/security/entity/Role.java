package com.maoniya.restful.api.security.entity;

import java.io.Serializable;

public class Role implements Serializable {

  private Integer id;
  private String roleName;
  private String roleCode;
  private Boolean enabled;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public String toString() {
    return "Role{" +
            "id=" + id +
            ", roleName='" + roleName + '\'' +
            ", roleCode='" + roleCode + '\'' +
            ", enabled=" + enabled +
            '}';
  }
}
