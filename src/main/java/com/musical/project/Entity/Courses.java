package com.musical.project.Entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.SequenceGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="music_tbl")

public class Courses {
     


	@Id
	@Column(name="Course_id")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "music_tb_seq")
	 @SequenceGenerator(name = "music_tb_seq", sequenceName = "music_tb_seq", allocationSize = 1)
	private int courseId;
	
	
	@Column(name="Course_Name")
	private String courseName;
	
	@Column(name="Course_Details")
	private String courseDetails;
	
	@Column(name="Course_Price")
	private String coursePrice;
	
	@Column(name="Course_Date")
	private LocalDate courseDate; 
	


	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}

	public String getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}

	public LocalDate getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(LocalDate courseDate) {
		this.courseDate = courseDate;
	}
}
