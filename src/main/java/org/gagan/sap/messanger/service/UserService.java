package org.gagan.sap.messanger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gagan.sap.messanger.database.HibernateUtil;
import org.gagan.sap.messanger.exceptions.DataNotFoundException;
import org.gagan.sap.messanger.model.UserDTO;
import org.gagan.sap.messanger.persistance.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UserService {

	@SuppressWarnings("unchecked")
	public List<UserDTO> getAllUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Object> users = session.createCriteria(User.class).list();
		List<UserDTO> userDTOlist = new ArrayList<>();
		for (int index = 0; index < users.size(); index++) {
			User user = (User) users.get(index);
			UserDTO userDTO = new UserDTO(user.getUserId(), user.getUserName(), user.getPassword(), user.getApiKey(),
					user.getDateOfBirth(), user.getCreatedDate());
			userDTOlist.add(userDTO);
		}
		return userDTOlist;

	}

	public UserDTO addUser(UserDTO userDTO) {
		User user = new User();
		user.setApiKey(userDTO.getUserName());
		user.setUserName(userDTO.getUserName());
		user.setCreatedDate(new Date());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return userDTO;
	}

	public UserDTO getUser(Integer userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = (User) session.get(User.class, userId);
		if (user == null)
			throw new DataNotFoundException("User with Id:" + userId + " Not found");
		UserDTO userDTO = new UserDTO(user.getUserId(), user.getUserName(), user.getPassword(), user.getApiKey(),
				user.getDateOfBirth(), user.getCreatedDate());
		return userDTO;

	}

	public void deleteUser(int userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.delete(userId);

	}

}
