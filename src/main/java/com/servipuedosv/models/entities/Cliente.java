package com.servipuedosv.models.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_Seq")
	@SequenceGenerator(name = "customers_Seq", sequenceName = "CUSTOMERS_SEQ")
	@Column(name = "cli_num_documento", updatable = false, nullable = false)
	private Long cli_num_documento;
	
	@Column(name="nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name="apell_1")
	@NotEmpty
	private String apell_1;
	
	@Column(name="apell_2")
	@NotEmpty
	private String apell_2;
	
	@Column(name="tip_documento")
	@NotEmpty
	private String tip_documento;
	
	@Column(name="nacionalidad")
	@NotEmpty
	private String nacionalidad;
	
	@Column(name="f_ingreso")
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyy")
	@NotNull
	private Date f_ingreso;
	
	
	@Column(name="f_baja")
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyy")
	private Date f_baja;
	@NotNull

	@Column(name="email")
	@NotEmpty
	private String email;
	@NotNull
	
	@Column(name="tip_cli")
	@NotEmpty
	private String tip_cli;
	@NotNull
	
	@Column(name="cod_estado")
	@NotEmpty
	@NotNull
	private String cod_estado;
	
	public Long getCli_num_documento() {
		return cli_num_documento;
	}
	public void setCli_num_documento(Long cli_num_documento) {
		this.cli_num_documento = cli_num_documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApell_1() {
		return apell_1;
	}
	public void setApell_1(String apell_1) {
		this.apell_1 = apell_1;
	}
	public String getApell_2() {
		return apell_2;
	}
	public void setApell_2(String apell_2) {
		this.apell_2 = apell_2;
	}
	public String getTip_documento() {
		return tip_documento;
	}
	public void setTip_documento(String tip_documento) {
		this.tip_documento = tip_documento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Date getF_ingreso() {
		return f_ingreso;
	}
	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}
	public Date getF_baja() {
		return f_baja;
	}
	public void setF_baja(Date f_baja) {
		this.f_baja = f_baja;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTip_cli() {
		return tip_cli;
	}
	public void setTip_cli(String tip_cli) {
		this.tip_cli = tip_cli;
	}
	public String getCod_estado() {
		return cod_estado;
	}
	public void setCod_estado(String cod_estado) {
		this.cod_estado = cod_estado;
	}	

}
