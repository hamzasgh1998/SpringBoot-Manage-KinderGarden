package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import tn.esprit.spring.entities.enumerations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Activities")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="kinder_garten_id_kinder_garten")
public class Activities implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdActivity")
	private Long IdActivity;
	@Column(name="NameActivity")
	private String NameActivity;

	@Enumerated(EnumType.STRING)
	@Column(name="TypeActivity")
	private TypeActivity TypeActivity;
	@Enumerated(EnumType.STRING)
	@Column(name="WeekDay")
	private Days WeekDay;
	@Temporal(TemporalType.TIME)
	@Column(name="HourActivity")
	private Date HourActivity;
	@Column(name="teacher")
	private String teacher;
	
	@ManyToOne
	//@JsonIgnore
	KinderGarten KinderGarten;

	public Long getIdActivity() {
		return IdActivity;
	}

	public void setIdActivity(Long idActivity) {
		IdActivity = idActivity;
	}

	public String getNameActivity() {
		return NameActivity;
	}

	public void setNameActivity(String nameActivity) {
		NameActivity = nameActivity;
	}

	public TypeActivity getTypeActivity() {
		return TypeActivity;
	}

	public void setTypeActivity(TypeActivity typeActivity) {
		TypeActivity = typeActivity;
	}

	public Days getWeekDay() {
		return WeekDay;
	}

	public void setWeekDay(Days weekDay) {
		WeekDay = weekDay;
	}

	public Date getHourActivity() {
		return HourActivity;
	}

	public void setHourActivity(Date hourActivity) {
		HourActivity = new Date();
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public KinderGarten getKinderGarten() {
		return KinderGarten;
	}

	public void setKinderGarten(KinderGarten kinderGarten) {
		KinderGarten = kinderGarten;
	}

	public Activities(Long idActivity, String nameActivity,
			tn.esprit.spring.entities.enumerations.TypeActivity typeActivity, Days weekDay, Date hourActivity,
			String teacher, tn.esprit.spring.entities.KinderGarten kinderGarten) {
		super();
		IdActivity = idActivity;
		NameActivity = nameActivity;
		TypeActivity = typeActivity;
		WeekDay = weekDay;
		HourActivity = hourActivity;
		this.teacher = teacher;
		KinderGarten = kinderGarten;
	}
	
	
	public Activities(String nameActivity,
			tn.esprit.spring.entities.enumerations.TypeActivity typeActivity, Days weekDay, Date hourActivity,
			String teacher, tn.esprit.spring.entities.KinderGarten kinderGarten) {
		super();
		NameActivity = nameActivity;
		TypeActivity = typeActivity;
		WeekDay = weekDay;
		HourActivity = hourActivity;
		this.teacher = teacher;
		KinderGarten = kinderGarten;
	}

	public Activities() {
		super();
	}

	@Override
	public String toString() {
		return "Activities [IdActivity=" + IdActivity + ", NameActivity=" + NameActivity + ", TypeActivity="
				+ TypeActivity + ", WeekDay=" + WeekDay + ", HourActivity=" + HourActivity + ", teacher=" + teacher
				+ ", KinderGarten=" + KinderGarten.getIdKinderGarten() + "]";
	}

	public Activities(String nameActivity, tn.esprit.spring.entities.enumerations.TypeActivity typeActivity,
			Days weekDay, Date hourActivity, String teacher) {
		super();
		NameActivity = nameActivity;
		TypeActivity = typeActivity;
		WeekDay = weekDay;
		HourActivity = hourActivity;
		this.teacher = teacher;
	}
	
	
	
	
	
}
