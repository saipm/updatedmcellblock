package ngdemo.repositories.impl.mock;

import ngdemo.domain.User;
import ngdemo.repositories.contract.DummyRepository;

public class DummyMockRepositoryImpl extends GenericMockRepository<User> implements DummyRepository {

    
    public User getDefaultUser() {
        User user = new User();
        user.setName("JonFromREST");
       // user.setLastName("DoeFromREST");
        return user;
    }

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
