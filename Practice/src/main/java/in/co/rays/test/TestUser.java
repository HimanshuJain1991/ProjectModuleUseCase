package in.co.rays.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.dto.UserDTO;
import in.co.rays.model.UserModel;

public class TestUser {
	UserDTO dto = new UserDTO();

	public static void main(String[] args) {
		testAdd();
		// testUpdate();
		// testDelete();
		 testFindbyPk();
		// testfindByLogin();
		// testAutheticate();
		//testSearch();
	}

	private static void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(21);
		dto.setFirstName("Raj");
		dto.setLastName("Soni");
		dto.setLoginId("akshat@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("Indore");
		UserModel model = new UserModel();
		model.add(dto);
	}

	private static void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(19);
		dto.setFirstName("Akshat Kumar");
		dto.setLastName("Jain");
		dto.setLoginId("akshat@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("Bhopal");
		UserModel model = new UserModel();
		model.update(dto);

	}

	private static void testDelete() {
		UserDTO dto = new UserDTO();
		dto.setId(21);
		UserModel model = new UserModel();
		model.delete(dto);

	}

	private static void testFindbyPk() {
		UserModel model = new UserModel();
		UserDTO dto = model.findByPk(3);
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		System.out.println(dto.getDob());
		System.out.println(dto.getDob());

	}

	private static void testfindByLogin() {
		UserModel model = new UserModel();
		UserDTO dto = model.findByLogin("akshat@gmail.com");
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getPassword());
			System.out.println(dto.getAddress());
			System.out.println(dto.getAddress());
			System.out.println(dto.getDob());
		} else {
			System.out.println("No Record Found...Try Again");
		}
	}

	private static void testAutheticate() {
		UserModel model = new UserModel();
		UserDTO dto = model.autheticate("akshat@gmail.com", "123");
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getPassword());
			System.out.println(dto.getAddress());
			System.out.println(dto.getAddress());
			System.out.println(dto.getDob());
		} else {
			System.out.println("No Record Found...Try Again");
		}
	}

	private static void testSearch() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("akshat");
		UserModel model = new UserModel();
		 List  list= model.search(dto, 1, 10);
		 Iterator it=list.iterator();
		 while (it.hasNext()) {
			 UserDTO dto1=(UserDTO) it.next();
				System.out.println(dto1.getId());
				System.out.println(dto1.getFirstName());
				System.out.println(dto1.getLastName());
				System.out.println(dto1.getPassword());
				System.out.println(dto1.getAddress());
				System.out.println(dto1.getAddress());
				System.out.println(dto1.getDob());
			} 

	}

}
