package com.arhohuttunen.coffeeshop;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTests {

    ApplicationModules modules = ApplicationModules.of(CoffeeShopApplication.class);

    @Test
    public void applicationModules() {
        modules.forEach(System.out::println);
        modules.verify();
    }

    @Test
    void writeDocumentationSnippets() {
        new Documenter(modules)
                .writeAggregatingDocument()
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }
}
