/**
 * 
 */
package com.example.conferencetrackmanagement.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.conferencetrackmanagement.input.InputParser;
import com.example.conferencetrackmanagement.model.Conference;
import com.example.conferencetrackmanagement.model.Talk;
import com.example.conferencetrackmanagement.scheduler.Scheduler;

/**
 * @author abhijit
 *
 */
public class ConferenceService {
	
	
	public static void main() throws IOException {
		InputParser parser = new InputParser();
		Scheduler scehduler = new Scheduler();
		
		List<Talk> talks = parser.parse("src/main/resources/input.txt");
		Conference conference= scehduler.scheduleTalks(talks);
		
	}
}
