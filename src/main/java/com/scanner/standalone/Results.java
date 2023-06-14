package com.scanner.standalone;

public class Results {
    private String item;
    private String severity;
    private String installDate;
    private String description;
    private String cveid;

    // Constructors, getters and setters
    // ...

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCveid() {
        return cveid;
    }

    public void setCveid(String cveid) {
        this.cveid = cveid;
    }
}
