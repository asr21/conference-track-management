package com.example.conferencetrackmanagement.scheduler;

import java.util.List;

import com.example.conferencetrackmanagement.model.Conference;
import com.example.conferencetrackmanagement.model.Talk;

public interface TalkScheduler {

	public Conference scheduleTalks(List<Talk> talkList) ;
}
