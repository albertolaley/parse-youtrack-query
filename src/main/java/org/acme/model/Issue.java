package org.acme.model;

public class Issue {
  String resolved;
  String summary;
  String created;

  public String getResolved() {
    return resolved;
  }

  public void setResolved(String resolved) {
    this.resolved = resolved;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }
}
