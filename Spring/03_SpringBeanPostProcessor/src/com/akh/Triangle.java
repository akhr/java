package com.akh;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle /* implements InitializingBean, DisposableBean */ implements BeanNameAware{
	
	private String beanName;
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



	/*
	@Override
	public void destroy() throws Exception {
		System.out.println("Bean is being destroyed");
		
	}



	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean is being initialized");
	}
	*/
	
	public void myInit() {
		System.out.println(beanName + " Bean is initialized - myInit() called");
	}
	
	public void myDestroy() {
		System.out.println(beanName + " Bean is detroyed - myDestroy() called");
	}



	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

}
