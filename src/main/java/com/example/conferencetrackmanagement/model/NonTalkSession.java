package com.example.conferencetrackmanagement.model;

import java.time.LocalTime;

public class NonTalkSession extends Session {
	public NonTalkSession(String sessionName, LocalTime startTime, LocalTime endTime) {
		super(sessionName, startTime, endTime);
	}
}
