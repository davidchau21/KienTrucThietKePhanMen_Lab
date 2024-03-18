package tuan_1_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tuan_1_api.models.User;
import tuan_1_api.repositories.UserRepository;

@SpringBootApplication
public class Tuan1ApiApplication {
    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tuan1ApiApplication.class, args);
    }
//    @Bean
    CommandLineRunner commandLineRunner(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                for (int i=1; i<=10; i++){
                    userRepository.save(new User(i, "User" + i));
                }
            }
        };
    }
}
