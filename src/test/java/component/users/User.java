package component.users;

import basic.tools.Constants;

public class User {

    private final String name;
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String country;
    private final String state;
    private final String city;
    private final String zipcode;
    private final String mobileNumber;

    private final String gender;
    private final String dayOfBirth;
    private final String monthOfBirth;
    private final String yearOfBirth;
    private final String company;
    private final String address2;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress2() {
        return address2;
    }

    private User(Builder builder) {

        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.country = builder.country.getDisplayCountry();
        this.state = builder.state;
        this.city = builder.city;
        this.zipcode = builder.zipcode;
        this.mobileNumber = builder.mobileNumber;

        this.gender = builder.gender.getDisplayGender();
        this.dayOfBirth = builder.dayOfBirth;
        this.monthOfBirth = builder.monthOfBirth;
        this.yearOfBirth = builder.yearOfBirth;
        this.company = builder.company;
        this.address2 = builder.address2;
    }

    public static class Builder {

        private String name;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String address;
        private Constants.Country country;
        private String state;
        private String city;
        private String zipcode;
        private String mobileNumber;

        private Constants.Gender gender;
        private String dayOfBirth;
        private String monthOfBirth;
        private String yearOfBirth;
        private String company;
        private String address2;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder dayOfBirth(String dayOfBirth) {
            this.dayOfBirth = dayOfBirth;
            return this;
        }

        public Builder monthOfBirth(String monthOfBirth) {
            this.monthOfBirth = monthOfBirth;
            return this;
        }

        public Builder yearOfBirth(String yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder address2(String address2) {
            this.address2 = address2;
            return this;
        }


        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder zipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder gender(Constants.Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder country(Constants.Country country) {
            this.country = country;
            return this;
        }

        private void requireNotNull(Object value, String fieldName) {
            if (value == null) {
                throw new IllegalStateException("Незаполнено поле " + fieldName);
            }
        }

        public User build() {
            requireNotNull(email, "email");
            requireNotNull(name, "name");
            requireNotNull(password, "password");
            requireNotNull(firstName, "firstName");
            requireNotNull(lastName, "lastName");
            requireNotNull(address, "address");
            requireNotNull(country, "country");
            requireNotNull(state, "state");
            requireNotNull(zipcode, "zipcode");
            requireNotNull(mobileNumber, "mobileNumber");

            return new User(this);
        }
    }
}
