package io.murad.exam.portal;

import io.murad.exam.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.murad.exam.portal.repository")
public class ExamPortalApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ExamPortalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//        User user = new User();
//        user.setFirstName("Murad");
//        user.setLastName("Hossain");
//        user.setUsername("murad");
//        user.setPassword(passwordEncoder.encode("admin"));
//        user.setEmail("murad@gmail.com");
//
//        Role roleAdmin = new Role();
//        roleAdmin.setRoleName("ADMIN");
//
//        Set<UserRole> userRoleSet = new HashSet<>();
//        UserRole userRole = new UserRole();
//
//        userRole.setRole(roleAdmin);
//        userRole.setUser(user);
//
//        userRoleSet.add(userRole);
//        User createAdmin = userService.createUser(user, userRoleSet);


    }
}
