package org.group28springproject.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean("dog")
    public Dog getDog() {return new Dog();}

    @Bean("parrot-kesha")
    public Parrot getParrot() {return new Parrot();}

    @Bean
    public Cat getCat(Parrot parrot){
        Cat cat = new Cat();
        cat.setName(parrot.getName() + " - killer ");
        return cat;
    }

}
