package za.ac.cput.factory;

import za.ac.cput.domain.ContactType;
import za.ac.cput.util.Helper;

public class ContactTypeFactory {

    public static ContactType createContactType(String contactId) {
        if (Helper.isNullorEmpty(contactId)) {
            return null;
        }

        return new ContactType.Builder()
                .setContactId(contactId)
                .build();
    }

    public static class Builder {
        private String contactId;

        public Builder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public ContactType build() {
            return new ContactType(this);
        }
    }
}
