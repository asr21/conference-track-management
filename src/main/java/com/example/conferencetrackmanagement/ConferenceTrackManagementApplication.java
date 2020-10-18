package com.example.conferencetrackmanagement;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.conferencetrackmanagement.input.InputParser;
import com.example.conferencetrackmanagement.model.Conference;
import com.example.conferencetrackmanagement.model.Talk;
import com.example.conferencetrackmanagement.output.OutputPrinter;
import com.example.conferencetrackmanagement.scheduler.Scheduler;

@SpringBootApplication
public class ConferenceTrackManagementApplication {

	public static void main(String[] args) throws IOException {
		
		InputParser parser = new InputParser();
		Scheduler scehduler = new Scheduler();
		OutputPrinter printer = new OutputPrinter();
		
		List<Talk> talks = parser.parse("src/main/resources/input.txt");
		Conference conference= scehduler.scheduleTalks(talks);
		printer.print(conference);
		
	}

}
