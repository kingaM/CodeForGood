package org.centrepoint.ucl;

import java.util.ArrayList;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class HostelLocations {

	public ArrayList<OverlayItem> hostelLocations;
	private int[] latitudes = {51514171,51513894,51499017,51506430,51518436,51493013,54913407,51512105,51545851,51528058,51513853,51513853,51450741,51458959,51446826,51512354,51435181,51445338,51457071,51497707};
	private int[] longitudes = {-135474,-136449,-233706,-127683,-114997,-155868,-1381009, -303898,8239,-117181,-130797,-13080,-211848,-360188,-243558,-90361,-44713,-325528,-181782,-129903};
	private String[] names = {"Berwick Street Soho","Bruce House Soho","Buffy House London","Camberwell Foyer London","Camden Housing Support and Development","Chalcombe Road London","Dundas Street Sunderlund","Ealing London","East Housing Support And Development","Frederick Street London"
			,"Greek Street London","Greek Street Safestop","Haberdasher's House","Comerford Road London","Farnborough House London","Mansion House London","Perry Vale London","Rivercourt London","Wandsworth Housing Support and Development","Westminster Housing Support and Development"};
	private String[] descriptions = {"An emergency service for short stays (9-28 days) based in the London Borough of Westminster where homeless young people can make a temporary home and find support.",
			"A long stay foyer where residents stay for up to 2 year, based in the London Borough of Westminster. There is a fully equipped Foundations for Life centre under development to help young people access work and learning.",
			"A long stay service, up to 2 years, for 16 and 17 year olds based in the London Borough of Hammersmith & Fulham.",
			"A foyer service for long stays of up to 2 years based in the London Borough of Lambeth. There is a fully equipped Foundations for Life centre to help young people access work and learning.",
			"Our Camden Housing support and development service is made up of a range of small flats and bedsit properties across the London Borough of Camden. Young people are supported with independent living and learning opportunities.",
			"A longer stay service (up to 2 years) based in the London Borough of Greenwich and primarily working with care leavers.",
			"Dundas Street is a purpose built direct access hostel, housing 18 young people aged 16 - 21. It opened in January 2012.",
			"A longer stay service (12 to 24 months) based in the London Borough of Ealing and primarily working with care leavers.",
			"Our Housing support and development East service is made up of a range of small flats and bedsit properties across the London Boroughs of Newham, Hackney and Waltham Forest. Young people are supported with independent living and learning opportunities.",
			"A longer stay service (6 to 12 months) for young people, including those with a history of offending, based in London Borough of Camden.",
			"Somewhere to live, get support and learn for up to six months in the London Borough of Westminster. There is a strong emphasis on becoming ready and able to move on to other Centrepoint services.",
			"A very short stay (nine nights) service for rough sleepers, operating from our home in Greek Street in the London Borough of Westminster.",
			"A longer stay service (6 to 12 months) based in the London Borough of Lewisham with fully equipped Foundations for Life centre to help young people take up work or learning.",
			"A shorter stay (6 months) service for 16-17 year olds based in the London Borough of Lewisham.",
			"A shorter stay (3 months) self-catering service based in the London Borough of Lewisham.",
			"A longer stay floating support service (up to two years) based in the London Borough of Lewisham, mainly working with young people with a history of offending.",
			"A longer stay (up to 2 years) service based in the London Borough of Lewisham and helping young people to develop independent living skills.",
			"A longer stay (up to one year) service based in the London Borough of Hammersmith and Fulham and helping young people to develop independent living skills.",
			"Our Wandsworth Housing support and development service is made up of a range of small flats and bedsit properties across the London Borough of Wandsworth. Young people are supported with independent living and learning opportunities.",
			"Our Westminster Housing support and development service is made up of a range of small flats and bedsit properties across the London Borough of Westminster. Young people are supported with independent living and learning opportunities."
			};


	public HostelLocations() {
		
		hostelLocations = new ArrayList<OverlayItem>();
		
		for(int i=0;i<20;i++){
		hostelLocations.add(new OverlayItem(new GeoPoint(latitudes[i],longitudes[i]),names[i],descriptions[i]));
		}
	}
}
