package com.revature;

import java.util.List;

import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.model.Bear;
import com.revature.model.Cave;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
//		Session s = HibernateUtil.getSession();

		CaveDao cd = new CaveDaoImpl();
		
//		Cave c1 = new Cave("Indian Echo Caverns");
//		Cave c2 = new Cave("Mammoth Cave");
//		Cave c3 = new Cave("Luray Caverns");
		
//		cd.createCave(c1);
//		cd.createCave(c2);
//		cd.createCave(c3);
//		
		
//		List<Cave> caves = cd.getCaves();
//		for(Cave c: caves) {
//			System.out.println(c);
//		}
		
//		System.out.println(cd.getCaveById(2));
//		System.out.println(cd.getCaveById(5));
		
//		cd.updateCave(new Cave(3, "Skyline Caverns"));
		
//		cd.deleteCave(2);
		
		Cave c1 = new Cave(1);
		Cave c3 = new Cave(3);
		Cave c4 = new Cave(4);
//		Bear b = new Bear("Smokey",c1);
		
		BearDao bd = new BearDaoImpl();
//		System.out.println(bd.createBear(b));
//		System.out.println(bd.getBearById(1));
		
		
//		Bear b2 = new Bear("Todd", c3);
//		Bear b3 = new Bear("Yogi", c1);
//		Bear b4 = new Bear("Fernando", c4);
//		Bear b5 = new Bear("Yoda",c1);
//		bd.createBear(b2);
//		bd.createBear(b3);
//		bd.createBear(b4);
//		bd.createBear(b5);
		
		
//		List<Bear> bears = bd.getBearsByName("Todd");
//		for(Bear b: bears) {
//			System.out.println(b);
//		}
		
//		List<Bear> bears = bd.getYBears();
//		for(Bear b: bears) {
//			System.out.println(b);
//		}
		
		System.out.println(bd.getBearCount());
		
		
		
		
		
		
		HibernateUtil.closeSessionFactory();
	}

}
