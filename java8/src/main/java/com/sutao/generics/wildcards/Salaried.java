package com.sutao.generics.wildcards;

public class Salaried extends Employee {
  public static final double DEFAULT_SQLARY = 120000;
  private double salary = DEFAULT_SQLARY;


  public Salaried(String name) {
    this(name, DEFAULT_SQLARY);
  }

  public Salaried(String name, double salary) {
    super(name);
    this.salary = salary;
  }

  private double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return String.format("Salaried{name=%s, salary=%s} %s", getName(), getSalary(), super.getName());
  }
}
