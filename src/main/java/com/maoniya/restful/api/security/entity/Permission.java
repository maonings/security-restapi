package com.maoniya.restful.api.security.entity;

import java.io.Serializable;

public class Permission implements Serializable {

  private Integer id;
  private Integer menuId;
  private Boolean createPerm;
  private Boolean deletePerm;
  private Boolean updatePerm;
  private Boolean selectPerm;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMenuId() {
    return menuId;
  }

  public void setMenuId(Integer menuId) {
    this.menuId = menuId;
  }

  public Boolean getCreatePerm() {
    return createPerm;
  }

  public void setCreatePerm(Boolean createPerm) {
    this.createPerm = createPerm;
  }

  public Boolean getDeletePerm() {
    return deletePerm;
  }

  public void setDeletePerm(Boolean deletePerm) {
    this.deletePerm = deletePerm;
  }

  public Boolean getUpdatePerm() {
    return updatePerm;
  }

  public void setUpdatePerm(Boolean updatePerm) {
    this.updatePerm = updatePerm;
  }

  public Boolean getSelectPerm() {
    return selectPerm;
  }

  public void setSelectPerm(Boolean selectPerm) {
    this.selectPerm = selectPerm;
  }

  @Override
  public String toString() {
    return "Permission{" +
            "id=" + id +
            ", menuId=" + menuId +
            ", createPerm=" + createPerm +
            ", deletePerm=" + deletePerm +
            ", updatePerm=" + updatePerm +
            ", selectPerm=" + selectPerm +
            '}';
  }
}
