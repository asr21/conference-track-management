package com.example.conferencetrackmanagement.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TalkSession extends Session {

	public List<Talk> talks;
	String sessionName;
	LocalTime startTime;
	LocalTime endTime;

	long durationInMinutes;
	long timeLeft;
	LocalTime endTimeOfLastTalk;

	public TalkSession(String sessionName, LocalTime startTime, LocalTime endTime) {
		super(sessionName, startTime, endTime);
		durationInMinutes = Duration.between(startTime, endTime).toMinutes();
		timeLeft = durationInMinutes;
		endTimeOfLastTalk = startTime;
		talks = new ArrayList<>();
	}

	public long getDurationInMinutes() {
		return durationInMinutes;
	}

	public void addTalk(Talk talk) {
		talks.add(talk);
		timeLeft = timeLeft - talk.durationInMinutes;
		talk.setStartTime(endTimeOfLastTalk);
		endTimeOfLastTalk = talk.getEndTime();
	}
	
	public List<Talk> getTalks() {
		return talks;
	}

	@Override
	public String toString() {
		return "Session [talks=" + talks + "]";
	}

}
