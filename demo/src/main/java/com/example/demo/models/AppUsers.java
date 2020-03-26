package com.example.demo.models;

import javax.persistence.*;
@Entity
@Table(name = "appusers")
public class AppUsers {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public int id;
        @Column(name = "firstname")
        public String firstName;
        @Column(name = "lastname")
        public String lastName;
        @Column(name = "age")
        public String Age;
        @Column(name = "height")
        public String Height;
        @Column(name = "weight")
        public String Weight;
        @Column(name = "job")
        public String Job;
        @Column(name = "interest")
        public String Interest;
        public AppUsers() {
        }

        public AppUsers(String firstName, String lastName, String Age, String Height,String Weight, String Job, String Interest) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.Age= Age;
            this.Height = Height;
            this.Weight = Weight;
            this.Job = Job;
            this.Interest = Interest;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAge() {
            return Age;
        }

        public void setAge(String Age) {
            this.Age = Age;
        }

        public String getHeight() {
            return Height;
        }

        public void setHeight(String Height) {
            this.Height = Height;
        }

        public String getWeight() {
            return Weight;
        }

        public void setWeight(String Weight) {
            this.Weight = Weight;
        }

        public String getJob() {
            return Job;
        }

        public void setJob(String Job) {
            this.Job = Job;
        }

        public String getInterest() {
            return Interest;
        }

        public void setInterest(String Interest) {
            this.Interest = Interest;
        }

}


