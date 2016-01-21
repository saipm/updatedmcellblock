package ngdemo.repositories.impl.mock;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.google.inject.Singleton;
import ngdemo.domain.NullUser;
import ngdemo.domain.User;
import ngdemo.repositories.contract.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserMockRepositoryImpl extends GenericMockRepository<User> implements UserRepository {

    private List<User> users = new ArrayList<User>();

    public UserMockRepositoryImpl() {
        this.users = this.createUsers();
    }

    public User getById1(String id) {
        for (User u : this.users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return new NullUser();
    }

    public List<User> getAll() {
        return this.users;
    }

     
 /*   public User create(User user) {
        user.setId(getCurrentMaxId() + 1);
        this.users.add(user);
        return user;
    }*/

     
    public User update(User user) {
        User byId = this.getById1(user.getId());
        byId.setName(user.getName());
      //  byId.setLastName(user.getLastName());
        return byId;
    }

     
    public void remove(int id) {
        User byId = this.getById(id);
        this.users.remove(byId);
    }

     
    public int getNumberOfUsers() {
        return this.users.size();
    }

    private List<User> createUsers() {
        int numberOfUsers = 10;
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User();
            user.setId(i + "1");
            user.setName("Foo" + (i + 1));
           // user.setLastName("Bar" + (i + 1));
            this.users.add(user);
        }
        return this.users;
    }

 /*   private int getCurrentMaxId() {
        Ordering<User> ordering = new Ordering<User>() {
             
            public int compare(User left, User right) {
                return Ints.compare(left.getId(), right.getId());
            }
        };
        return ordering.max(this.users).getId();
    }*/

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
