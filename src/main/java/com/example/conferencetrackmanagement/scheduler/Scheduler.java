/**
 * 
 */
package com.example.conferencetrackmanagement.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.example.conferencetrackmanagement.config.TrackConfig;
import com.example.conferencetrackmanagement.model.Conference;
import com.example.conferencetrackmanagement.model.Talk;
import com.example.conferencetrackmanagement.model.Track;

/**
 * @author abhijit
 *
 */
public class Scheduler {

	public Conference scheduleTalks(List<Talk> talkList) {
		long numberOfTracksRequired = getNumberOfTracksRequired(talkList);
		List<Track> tracks = initTracks(numberOfTracksRequired);
		tracks = assignTalksToTracks(tracks, talkList);
		Conference conference = new Conference(tracks);
		return conference;
	}

	private List<Track> assignTalksToTracks(List<Track> tracks, List<Talk> talkList) {
		List<Talk> remainingTalks = new ArrayList<>(talkList);
		int numberOfTalks = talkList.size();
		for(int i=0;i<numberOfTalks;i++) {
			Talk talk = getTalkWithLargestDuration(remainingTalks);
			boolean added = addTalkToAnyRandomTrack(talk,tracks);
			if(added) {
				remainingTalks.remove(talk);
			}
		}
		if(remainingTalks.size()!=0) {
			shuffleTalks(tracks,remainingTalks);
			
			return tracks;
		}
		return tracks;
	}
	
	private void shuffleTalks(List<Track> tracks, List<Talk> remainingTalks) {
		//getting a talk from first track 
		Talk talk = tracks.get(0).getTalks().get(0);
		tracks.get(0).removeTalk(talk);
		
		//
	}

	private boolean addTalkToAnyRandomTrack(Talk talk,List<Track> tracks) {
		Track track = getRandomTrack(tracks);
		if(track.addTalk(talk)) {
			return true;
		} else {
			for(Track t:tracks) {
				if(!t.equals(track) && t.addTalk(talk)) {
					return true;
				}
			}
		}
		return false;
	}

	private Talk getTalkWithLargestDuration(List<Talk> remainingTalks) {
		Collections.sort(remainingTalks,Collections.reverseOrder());
		return remainingTalks.get(0);
	}

	private Track getRandomTrack(List<Track> tracks) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, tracks.size());
		return tracks.get(randomNum);
	}

	private List<Track> initTracks(long numberOfTracksRequired) {
		List<Track> tracks = new ArrayList<>();
		for (int i = 0; i < numberOfTracksRequired; i++) {
			Track track = new Track();
			tracks.add(track);
		}
		return tracks;
	}

	private long getNumberOfTracksRequired(List<Talk> talkList) {
		long sum = talkList.stream().mapToInt(talk -> talk.getDurationInMinutes()).reduce(0, Integer::sum);
		long trackTalkDuration = TrackConfig.TOTAL_TALK_SESSION_TIME_IN_MINUTES;
		long numberOfTracksRequired = sum /trackTalkDuration  + (sum % trackTalkDuration == 0 ? 0 : 1);
		return numberOfTracksRequired;
	}

}
