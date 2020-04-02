package com.santosh.entities;

import com.santosh.constants.KidFrindlyStatus;

public abstract class Bookmark {
private long id;
private String title;
private String profileUrl;
private String kidFriendlyStatus=KidFrindlyStatus.UNKNOWN;
private User kidFriendyMarkedBy;
private User sharedBy;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getProfileUrl() {
	return profileUrl;
}
public void setProfileUrl(String profileUrl) {
	this.profileUrl = profileUrl;
}
public abstract  boolean isKidfriendlyEligible() ;
public String getKidFriendlyStatus() {
	return kidFriendlyStatus;
}
public void setKidFriendlyStatus(String kidFriendlyStatus) {
	this.kidFriendlyStatus = kidFriendlyStatus;
}
public User getKidFriendyMarkedBy() {
	return kidFriendyMarkedBy;
}
public void setKidFriendyMarkedBy(User kidFriendyMarkedBy) {
	this.kidFriendyMarkedBy = kidFriendyMarkedBy;
}
public User getSharedBy() {
	return sharedBy;
}
public void setSharedBy(User sharedBy) {
	this.sharedBy = sharedBy;
}

}
