package com.psych.game.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable{
	@Id
	@GeneratedValue(generator="sequence",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="sequence",allocationSize=10)
	@Getter
	@Setter
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	@CreatedDate
	@Getter
	@Setter
	private Date createdAt=new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(nullable = false)
	@Getter
	@Setter
	private Date updatedAt=new Date();
}
