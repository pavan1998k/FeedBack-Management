package com.ty.feedback.service;

import java.util.List;

import com.ty.feedback.dao.AdminDao;
import com.ty.feedback.dto.Admin;

public class AdminService {
	AdminDao adminDao=new AdminDao();
	public Admin createAdmin(Admin admin){
		return adminDao.createAdmin(admin);
	}
	public List<Admin> getAllAdmin(){
		return adminDao.getAllAdmin();
	}
	public Admin updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}
	public Admin deleteAdmin(int id) {
		return adminDao.deleteAdmin(id);
	}
	public List<Admin> vallidateAdmin(String email,String password) {
		return adminDao.vallidateAdmin(email, password);
	}
}
