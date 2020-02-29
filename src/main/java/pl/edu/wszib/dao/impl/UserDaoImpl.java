package pl.edu.wszib.dao.impl;


import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private Map<Long, User> userMap;
    private static Long id = 1L;

    public UserDaoImpl() {
        this.userMap = new HashMap<>();
        prepareUserList();
    }



    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() < 1) {
            user.setId(id);
            id++;
        }
        userMap.put(user.getId(), user);
    }

    @Override
    public void removeUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    private void prepareUserList() {
        User user = new User();
        user.setLogin("Użytkownik 1");
        user.setEmail("user1@wszib.edu.pl");
        user.setAge(55);
        user.setCountry("Chiny");
        user.setActive(true);
        saveUser(user);

        User user2 = new User();
        user2.setLogin("Użytkownik 2");
        user2.setEmail("user2@wszib.edu.pl");
        user2.setAge(54);
        user2.setCountry("Japonia");
        user2.setActive(true);
        saveUser(user2);

        User user3 = new User();
        user3.setLogin("Użytkownik 3");
        user3.setEmail("user3@wszib.edu.pl");
        user3.setAge(23);
        user3.setCountry("USA");
        user3.setActive(false);
        saveUser(user3);
    }
}
