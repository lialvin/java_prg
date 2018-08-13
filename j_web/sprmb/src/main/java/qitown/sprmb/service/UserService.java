package qitown.sprmb.service;

import java.util.List;

import qitown.sprmb.pojo.User;

public interface UserService {
		List<User> findAll();
		User findById(Integer idUser);
		void update(User user);
		void deleteById(Integer iduser);
		void insert(User user);
}
