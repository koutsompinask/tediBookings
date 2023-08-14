package com.project.tedi.wrapper;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement
public class GuestRatings {

	private Long guestId;
	private String username;
	private Set<RatingWrapper> ratings;
}