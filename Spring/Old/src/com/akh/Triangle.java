package com.akh;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware{
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	
	
	public Point getPointA() {
		return pointA;
	}



	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}



	public Point getPointB() {
		return pointB;
	}



	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}



	public Point getPointC() {
		return pointC;
	}



	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}



	public void draw() {
		System.out.println("Triangle Drawn");
		System.out.println("PointA - ("+pointA.getX()+", "+pointA.getY()+")");
		System.out.println("PointB - ("+pointB.getX()+", "+pointB.getY()+")");
		System.out.println("PointC - ("+pointC.getX()+", "+pointC.getY()+")");
	}



	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name of Triangle Class: "+beanName);
		
	}



	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		System.out.println("ApplicationContext: "+context.getApplicationName());
		
	}
	

}
