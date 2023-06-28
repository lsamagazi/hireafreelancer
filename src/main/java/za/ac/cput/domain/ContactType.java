package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import za.ac.cput.factory.ContactTypeFactory;

import java.util.Objects;

@Entity
public class ContactType {
    @Id
    private String contactId;
    private boolean email;
    private boolean phone;
    private boolean mobile;

    public ContactType() {
    }

    public ContactType(Builder builder) {
        this.contactId = builder.contactId;
        this.email = builder.email;
        this.phone = builder.phone;
        this.mobile = builder.mobile;
    }

    public ContactType(ContactTypeFactory.Builder builder) {
    }

    public String getContactId() {
        return contactId;
    }

    public boolean Email() {
        return email;
    }

    public boolean Phone() {
        return phone;
    }

    public boolean Mobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactType)) return false;
        ContactType that = (ContactType) o;
        return email == that.email && phone == that.phone && mobile == that.mobile && Objects.equals(contactId, that.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, email, phone, mobile);
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "contactId='" + contactId + '\'' +
                ", email=" + email +
                ", phone=" + phone +
                ", mobile=" + mobile +
                '}';
    }

    public static class Builder {
        private String contactId;
        private boolean email;
        private boolean phone;
        private boolean mobile;

        public Builder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder setEmail(boolean isEmail) {
            this.email = email;
            return this;
        }

        public Builder setPhone(boolean isPhone) {
            this.phone = phone;
            return this;
        }

        public Builder setMobile(boolean isMobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder copy(ContactType contactType) {
            this.contactId = contactType.contactId;
            this.email = contactType.email;
            this.phone = contactType.phone;
            this.mobile = contactType.mobile;
            return this;
        }

        public ContactType build() {
            return new ContactType(this);
        }


    }
}
