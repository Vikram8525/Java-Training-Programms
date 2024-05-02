package com.chainsys.jfs.databaseconnection;

public class ConnectivityPojo {
    private int id;
    private String name;
    private int classHeld;
    private int classAttended;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassHeld() {
        return classHeld;
    }

    public void setClassHeld(int classHeld) {
        this.classHeld = classHeld;
    }

    public int getClassAttended() {
        return classAttended;
    }

    public void setClassAttended(int classAttended) {
        this.classAttended = classAttended;
    }

	public ConnectivityPojo() {
	}

	@Override
	public String toString() {
		return "ConnectivityPojo [id=" + id + ", name=" + name + ", classHeld=" + classHeld + ", classAttended="
				+ classAttended + "]";
	}
	
}
