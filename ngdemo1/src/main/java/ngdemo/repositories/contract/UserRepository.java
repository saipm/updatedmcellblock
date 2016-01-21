package ngdemo.repositories.contract;

import ngdemo.domain.User;

public interface UserRepository extends Repository<User> {
    User create(User user);

    User update(User user);

    void remove(String id);

    int getNumberOfUsers();
}
