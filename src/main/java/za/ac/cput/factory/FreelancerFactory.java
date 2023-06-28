package za.ac.cput.factory;

import za.ac.cput.domain.Freelancer;
import za.ac.cput.util.Helper;

public class FreelancerFactory {

    public static Freelancer createFreelancer(String firstName, String lastName, String city, double hourlyRate) {
        if (Helper.isNullorEmpty(firstName) || Helper.isNullorEmpty(lastName)) {
            return null;
        }

        String freelancerId = Helper.generateId();

        return new Freelancer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCity(city)
                .setHourlyRate(hourlyRate)
                .build();
    }

    public static class FreelancerBuilder extends Freelancer.Builder {
        public FreelancerBuilder() {
            super();
        }
    }
}



