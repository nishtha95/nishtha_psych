package com.psych.game.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="playerAnswers")
public class PlayerAnswer extends Auditable{
	@NotNull
	@ManyToOne
	@Getter
	@Setter
	private Round round;
	
	@NotNull
	@ManyToOne
	@Getter
	@Setter
	private Player player;
	
	@NotBlank
	@Getter
	@Setter
	private String answers;
}
