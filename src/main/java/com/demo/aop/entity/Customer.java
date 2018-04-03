package com.demo.aop.entity;

public class Customer {
	private String name;  
    private String sex;  
    private int age;  
  
    public Customer() {  
        super();  
        System.out.println("------创建人员-------");  
    }  
  
    public Customer(String name, String sex, int age) {  
        super();  
        this.name = name;  
        this.sex = sex;  
        this.age = age;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getSex() {  
        return sex;  
    }  
  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
}
