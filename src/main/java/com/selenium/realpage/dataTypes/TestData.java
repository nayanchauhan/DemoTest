package com.selenium.realpage.dataTypes;

public class TestData {
    public String testId;
    public String userName;
    public String password;
    public String firstName;
    public String lastName;
    public Integer age;
    public String emailAddress;
    public Address address;
    public PhoneNumber phoneNumber;
    public String loginAssert;

    public class Address {

        public String streetAddress;
        public String city;
        public String postCode;
        public String state;
        public String country;
        public String county;

    }

    public class PhoneNumber {

        public String home;
        public String mob;
    }
}
