/**
 * 
 */
package com.example.conferencetrackmanagement.fetch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.conferencetrackmanagement.model.Talk;

/**
 * @author abhijit
 *
 */
public class TalkFetcher {

	Map<Talk, Boolean> talkMap = new HashMap<>();

	public TalkFetcher(List<Talk> talkList) {
		for (Talk t : talkList) {
			talkMap.put(t, false);
		}
	}

	public Talk getTalk() {
		for (Map.Entry<Talk, Boolean> entry : talkMap.entrySet()) {
			if (!entry.getValue().booleanValue()) {
				talkMap.put(entry.getKey(), true);
				return entry.getKey();
			}
		}
		return null;
	}
}
