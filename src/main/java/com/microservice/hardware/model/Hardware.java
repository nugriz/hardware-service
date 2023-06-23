package com.microservice.hardware.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Setter //Untuk Set Paramater
@Getter //Untuk Get Paramater
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Builder //
@Entity //Untuk Memberikan Identitas Data yang mengakses ke Database
public class Hardware {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Untuk Menggenerate AutoIncrement
    private Long id;
	
	@Column(name = "tipe")
	private String tipe;

	@Column(name = "merk")
	private String merk;
	
	@Column(name = "harga")
	private Long harga;

	@Column(name = "jenis_garansi")
	private String jenisGaransi;

	@Override
	public String toString() {
		return "Hardware [id=" + id + ", tipe=" + tipe + ", merk=" + merk + ", harga=" + harga + ", jenisGaransi="
				+ jenisGaransi + "]";
	}

//	public Long getId() {
//		// TODO Auto-generated method stub
//		return this.id;
//	}
	
	
	
}