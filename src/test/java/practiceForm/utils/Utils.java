package practiceForm.utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;


public class Utils {
    public Faker faker = new Faker(new Locale("en"));

    public String userName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = getRandomGender(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = getMonth(),
            year = String.valueOf(faker.number().numberBetween(1950, 2010)),
            subject = getSubjects(),
            hobbies = getHobby(),
            file = getFileName(),
            currentAddress = faker.address().streetAddress(),
            city = getCityRandom(),
            state = getStateByCity(city);

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

    public String getHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};

        return faker.options().option(hobby);
    }

    public String getSubjects() {
        String[] subjects = {"English", "Physics", "Arts"};

        return faker.options().option(subjects);
    }

    public String getCityRandom() {
        String[] state = {"Delhi", "Agra", "Karnal", "Gurgaon",
                "Lucknow", "Panipat", "Jaipur", "Jaiselmer"};

        return faker.options().option(state);
    }

    public String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");

        return cityAndState.get(value);
    }

    public String getFileName() {
        return "msk.jpg";
    }

    public String getMonth() {
        String[] month = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};

        return faker.options().option(month);
    }

}