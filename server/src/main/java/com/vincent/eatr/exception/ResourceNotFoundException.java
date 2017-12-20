package com.vincent.eatr.exception;

public class ResourceNotFoundException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1791564636123821405L;
  private Long resourceId;

  public ResourceNotFoundException(Long resourceId, String message) {
    super(message);
    this.setResourceId(resourceId);
  }

  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }
}
