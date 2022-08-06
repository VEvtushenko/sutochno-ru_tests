package ru.sutochno.base.domain.adverticement;

import com.github.javafaker.Faker;

public class Description {

    private String publicName;
    private String privateName;
    private String description;
    private String sideResourcesAdvertisements;

    public Description(Faker faker) {
        this.publicName = "Pretty house in " + faker.hitchhikersGuideToTheGalaxy().location();
        this.privateName = "Advertisement by  " + faker.hitchhikersGuideToTheGalaxy().character();
        this.description = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
        this.sideResourcesAdvertisements = faker.company().url();
    }

    public Description(String publicName, String privateName, String description, String sideResourcesAdvertisements) {
        this.publicName = publicName;
        this.privateName = privateName;
        this.description = description;
        this.sideResourcesAdvertisements = sideResourcesAdvertisements;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
