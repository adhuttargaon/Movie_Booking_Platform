package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserServiceImp implements UserService {

	
	

	private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
    

    @Override
    public String check(String emailId, String password) {
    User user = userRepo.findByEmailIdAndPassword(emailId, password);
        System.out.println(user);
    if (user != null  ){
//      if(iRepositoryUser.equals("amruta") && iRepositoryUser.equals("Pass@123") && iRepositoryUser.equals("STUDENT")){
        return "success";
    }
    return "failure";
}

	/*
	 * @Override public User loginUser(Long userId, String name,String emailId,
	 * String password, Long contactNo) { User user =
	 * userRepo.findByEmailId(emailId); if (user == null ||
	 * !user.getPassword().equals(password)) {
	 * 
	 * } return user; }
	 */
	@Override
	public User getUserId(Long userId) {
		return userRepo.findById(userId)
                .orElse(null);
	}

	@Override
	public User getEmailId(String emailId) {
		return userRepo.findByEmailId(emailId);
	}

	

	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
		
	}
	@Override
	public void updateUser(Long userId, String name, String emailId, String password) {
		User user = userRepo.findById(userId)
                .orElseThrow(null);
        
        user.setName(name);
        user.setEmailId(emailId);
        user.setPassword(password);
        // Update other user properties if needed
        
        userRepo.save(user);
		
	}



	

}
