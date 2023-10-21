package com.configuration;

public class Config {

    //public static String jsonData = "[{"name" : "Bob", "age" : 20, "gender": "male"},{"name": "George", "age" : 42, "gender": "male"}, {"name":"Sara", "age" : 42, "gender": "female"}, {"name": "Conor", "age" : 40, "gender": "male"}, {"name":"Jennifer", "age" : 42, "gender": "female"}]";
    public static String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\n" +
            "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\n" +
            "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";

    private static String name;
    private static int age;
    private static String gender;

    public Config(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public  int getAge() {
        return age;
    }

    public  String getGender() {
        return gender;
    }


}
