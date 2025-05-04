package com.sohrabi.dataclass;

public class userDataClass {
    private String name;
    private String family;
    private String age;
    private String number;
    private String codeID;
    private String city;

    public userDataClass(String name, String family, String age, String number, String codeID, String city) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.number = number;
        this.codeID = codeID;
        this.city = city;
    }

    @Override
    public String toString() {
        return "userDataClass{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age='" + age + '\'' +
                ", number='" + number + '\'' +
                ", codeID='" + codeID + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCodeID() {
        return codeID;
    }

    public void setCodeID(String codeID) {
        this.codeID = codeID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
