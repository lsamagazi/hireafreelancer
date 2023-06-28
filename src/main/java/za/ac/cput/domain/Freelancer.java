package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Freelancer {
    private String freelancerId;
    private String firstName;
    private String lastName;

    @Id
    private String city;
    public double hourlyRate;
    protected Freelancer(){}

    public Freelancer(Builder builder) {
        this.freelancerId = builder.freelancerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.city = builder.city;
        this.hourlyRate = (double) builder.hourlyRate;
    }

    public String getFreelancerId() {
        return freelancerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Freelancer freelancer)) return false;
        return Objects.equals(firstName, freelancer.firstName) && Objects.equals(lastName, freelancer.lastName) && Objects.equals(freelancerId, freelancer.freelancerId) && Objects.equals(city, freelancer.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freelancerId, firstName, lastName, city, hourlyRate);
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "freelancerId='" + freelancerId + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", hourlyRate='" + hourlyRate + '\'' +
                '}';
    }
    public static class Builder{
        public String freelancerId;
        private String firstName;
        private String lastName;
        private String city;
        public Object hourlyRate;



        public Builder setFreelancerId(String freelancerId) {
            this.freelancerId = freelancerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }
        public Builder copy(Freelancer freelancer){
            this.freelancerId =  freelancer.freelancerId;
            this.firstName =  freelancer.firstName;
            this.lastName =  freelancer.lastName;
            this.city= freelancer.city;
            this.hourlyRate = freelancer.hourlyRate;
            return this;
        }
        public Freelancer build(){
            return new Freelancer(this);
        }
    }
}
