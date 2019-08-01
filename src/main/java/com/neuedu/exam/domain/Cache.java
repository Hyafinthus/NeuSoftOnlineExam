package com.neuedu.exam.domain;

import java.util.HashMap;
import java.util.Map;

public class Cache {

	private Cache() {}
	
	private static Cache cache = new Cache();
	
	public static Cache getCache() {
		return cache;
	}
	
	// <exam_id, <ques_id, ans>>
	public Map<String, Map<Integer, Question>> examMultAnswers = new HashMap<>();
	public Map<String, Map<Integer, Integer>> examSubjScores = new HashMap<>();
	
}
