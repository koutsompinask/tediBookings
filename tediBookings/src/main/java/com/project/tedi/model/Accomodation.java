package com.project.tedi.model;

import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "accomodation" )
@XmlRootElement
public class Accomodation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	
	@NonNull
	@Column(nullable = false)
	private String location;
	
	@Column(nullable = true)
	private float lat;
	
	@Column(nullable = true)
	private float lng;
	
	@Lob
	private String transportation; 
	
	@NonNull
	@Column(nullable = false)
	private int floor;
	
	@NonNull
	@Column(nullable = false)
	private int price;
	
	@NonNull
	@Column(nullable = false)
	private int extraCost;
	
	@NonNull
	@Column(nullable = false)
	private int size;
	
	@NonNull
	@Column(nullable = false)
	private int beds;
	
	@NonNull
	@Column(nullable = false)
	private int rooms;
	
	@NonNull
	@Column(nullable = false)
	private int bathrooms;
	
	@NonNull
	@Column(nullable = false)
	private int maxPerson;
	
	@NonNull
	@Column(nullable = false)
	private Date availableFrom;
	
	@NonNull
	@Column(nullable = false)
	private Date availableTo;
	
	@NonNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private AccType type;
	
	@Lob
	private String description;
	
	@Column(nullable = false,columnDefinition = "boolean default false")
	private boolean smokingAllowed;
	
	@Column(nullable = false,columnDefinition = "boolean default false")
	private boolean petsAllowed;
	
	@Column(nullable = false,columnDefinition = "boolean default false")
	private boolean eventsAllowed;

	@Column(nullable = false)
	private boolean sittingRoom;
	
	@Column(nullable = false)
	private boolean wifi;
	
	@Column(nullable = false)
	private boolean heat;
	
	@Column(nullable = false)
	private boolean kitchen;
	
	@Column(nullable = false)
	private boolean tv;
	
	@Column(nullable = false)
	private boolean parking;
	
	@Column(nullable = false)
	private boolean elevator;
	
	@ManyToOne
	@JsonIncludeProperties({"username","firstName","lastName","id","email","photoUrl"})
	@JoinColumn(name = "user_id", nullable = false)
	@EqualsAndHashCode.Exclude
	private User owner;
	
	@OneToMany(mappedBy = "accomodation")
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	private Set<Booking> bookings;
	
	@OneToMany(mappedBy ="accomodation")
	@EqualsAndHashCode.Exclude
	private Set<Photo> photos;
	
	@OneToMany(mappedBy = "accomodation")
	@EqualsAndHashCode.Exclude
	private Set<Rating> ratings;
	
	@OneToMany(mappedBy = "accomodation")
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	private Set<UserViewAccomodation> viewed;
	
	@OneToMany(mappedBy = "accomodation")
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<UserSearch> searched;
}
